package com.example.akshat.attendence;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
{
    private WebView mWebView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //  private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isOnline())
        {
            // private boolean isOnline(){

                mWebView = (WebView) findViewById(R.id.activity_main_webview);
                WebSettings webSettings = mWebView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                mWebView.loadUrl("http://bpit.markattendance.in/");
                mWebView.setWebViewClient(new MyAppWebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        //hide loading image
                        findViewById(R.id.progressBar1).setVisibility(View.GONE);
                        //show webview
                        findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
                    }
                });

            }
            else
            {

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
               // AlertDialog alertDialog = new AlertDialog.Builder(getActivity());
                    alertDialog.setTitle("Info");
                    alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                   // alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which){
                            finish();

                        }
                    });

                alertDialog.show();
                    }

            }






    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

private ShareActionProvider mShareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /** Inflating the current activity's menu with res/menu/items.xml */
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /** Getting the actionprovider associated with the menu item whose id is share */
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider();

        /** Setting a share intent */
        mShareActionProvider.setShareIntent(getDefaultShareIntent());

        return super.onCreateOptionsMenu(menu);

    }

    /**
     * Returns a share intent
     */
    private Intent getDefaultShareIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        return intent;


    }


    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


}



