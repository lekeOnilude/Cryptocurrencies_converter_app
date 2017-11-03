package com.example.android.cryptocurrenciesconverterapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by GBEMILEKE on 24/10/2017.
 */
public class CryptocurrencyAdpater extends ArrayAdapter<Cryptocurrency> {

    public CryptocurrencyAdpater(Activity context, List<Cryptocurrency> cryptocurrencyList){
        super(context, 0, cryptocurrencyList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        // check if the @param listItemView is empty and if so populate it.
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.visible_layout, parent, false);
        }

        Cryptocurrency currentCryptocurrency  = getItem(position);


        TextView bitcoinPrice = (TextView)listItemView.findViewById(R.id.btc_value);
        TextView ethereumPrice = (TextView)listItemView.findViewById(R.id.eth_value);
        TextView countryName = (TextView)listItemView.findViewById(R.id.country_name);
        ImageView countryFlag = (ImageView)listItemView.findViewById(R.id.country_flag);
        TextView currency1 = (TextView)listItemView.findViewById(R.id.curr1);
        TextView currency2 = (TextView)listItemView.findViewById(R.id.curr2);

        DecimalFormat formatter = new DecimalFormat("#,###,###,###,###.00");
        String btc = formatter.format(currentCryptocurrency.getBitcoinPrice());
        bitcoinPrice.setText(btc);

        String eth = formatter.format(currentCryptocurrency.getEnthernetPrice());
        ethereumPrice.setText(eth);

        countryName.setText(currentCryptocurrency.getCountryName().toUpperCase());

        currency1.setText(currentCryptocurrency.getShortFormName());
        currency2.setText(currentCryptocurrency.getShortFormName());

        //float radius = 10.0f;
        //Resources res = listItemView.getResources();
        //Bitmap src = BitmapFactory.decodeResource(res, countryFlag.getId());
        //RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(listItemView.getResources(), src);
        //dr.setCornerRadius(radius);
        countryFlag.setImageResource(currentCryptocurrency.getCountryFlag());
        //countryFlag.setImageDrawable(dr);



        return listItemView;
    }
}
