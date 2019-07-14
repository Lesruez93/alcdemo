package com.lester.alcdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Toast.makeText(this,"Please Wait",Toast.LENGTH_LONG).show();
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ProgressDialog pd = new ProgressDialog(Webview.this);
        pd.setMessage("Loading");
        pd.show();
        WebView webView = findViewById(R.id.wb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        pd.dismiss();
                    }
                },
                5000);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                // progDailog.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                //pd.dismiss();

            }
        });

        webView.loadUrl("https://andela.com/alc/");
    }}