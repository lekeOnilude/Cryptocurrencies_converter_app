package com.example.android.cryptocurrenciesconverterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class ConversionActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        TextView countryName = (TextView)findViewById(R.id.country_short_name);
        final EditText currency = (EditText)findViewById(R.id.curr_price);
        Button convert = (Button)findViewById(R.id.convert);

        final double btcPrice = MainActivity.currentCrypto.getBitcoinPrice();
        final double ethPrice = MainActivity.currentCrypto.getEnthernetPrice();
        String country = MainActivity.currentCrypto.getShortFormName();
        countryName.setText(country);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currency.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(ConversionActivity.this, "Please fill in the value to convert", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    int currencyToConvert = Integer.parseInt(currency.getText().toString());
                    double bitCoin = currencyToConvert / btcPrice;
                    double ethereum = currencyToConvert / ethPrice;

                    TextView bitCoinPrice = (TextView)findViewById(R.id.bitCoin_price);
                    TextView ethereumPrice = (TextView)findViewById(R.id.eth_price);

                    DecimalFormat formatter = new DecimalFormat("#,###,###,###,##0.00000");
                    bitCoinPrice.setText(formatter.format(bitCoin));
                    ethereumPrice.setText(formatter.format(ethereum));
                }



            }
        });


    }
}
