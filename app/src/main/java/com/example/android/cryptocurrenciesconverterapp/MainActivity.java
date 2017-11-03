package com.example.android.cryptocurrenciesconverterapp;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Cryptocurrency>> {
    public static final String apiUrl = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,BTC&tsyms=NGN,USD,EUR,JPY,GBP,PRC,INR,CAD,KRW,RUB,AUD,ESP,MXN,BRL,IDR,SAR,ARS,AED,TRY,ZAR";
    private CryptocurrencyAdpater mAdapter;
    private ListView listView;
    private TextView emptyStateListView;
    private ProgressBar progressBarView;
    public static Cryptocurrency currentCrypto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        emptyStateListView = (TextView)findViewById(R.id.empty);


        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        //check if the device is connected to the internet
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(isConnected){
            // Start the Loader to fetch the earthquake data
            getLoaderManager().initLoader(0, null, this);
        }
        else {
            emptyStateListView.setText("No Internet Connection");
            listView.setEmptyView(emptyStateListView);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentCrypto = mAdapter.getItem(position);
                // create an intent to open up a new activity {@link NumbersActivity}
                Intent numberActivity = new Intent(MainActivity.this, ConversionActivity.class);
                startActivity(numberActivity);
            }
        });
    }

    @Override
    public Loader<List<Cryptocurrency>> onCreateLoader(int id, Bundle args) {
        progressBarView = (ProgressBar)findViewById(R.id.progress_bar);
        progressBarView.setVisibility(View.VISIBLE);

        Loader<List<Cryptocurrency>> crypotocurrency = new CryptoLoader(this, apiUrl);
        return crypotocurrency;
    }

    @Override
    public void onLoadFinished(Loader<List<Cryptocurrency>> loader, final List<Cryptocurrency> data) {
        progressBarView = (ProgressBar)findViewById(R.id.progress_bar);
        progressBarView.setVisibility(View.GONE);

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null ) {
            // Create a new adapter that takes an empty list of earthquakes as input
            mAdapter = new CryptocurrencyAdpater(this, data);
            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            listView.setAdapter(mAdapter);
            //mAdapter.addAll(data);

        }
        else {
            emptyStateListView = (TextView)findViewById(R.id.empty);
            emptyStateListView.setText("No earthquake data to display");
            listView.setEmptyView(emptyStateListView);
        }


    }

    @Override
    public void onLoaderReset(Loader<List<Cryptocurrency>> loader) {
        mAdapter.clear();
    }

    /**
     * This class perform the Network coonection on the back thread
     * and then return the a list of Earthquake
     */
    public static class CryptoLoader extends AsyncTaskLoader<List<Cryptocurrency>> {

        public String StringUrls;

        public CryptoLoader(Context context, String urls) {
            super(context);
            StringUrls = urls;
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        public List<Cryptocurrency> loadInBackground() {
            //Log.i(LOG_TAG, "Load in background");
            // Don't perform the request if there are no URLs, or the first URL is null.
            if ( StringUrls == null) {
                return null;
            }

            final List<Cryptocurrency> result = QueryUtils.fetchCryptocurrencyData(StringUrls);
            return result;
        }
    }
}

