package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("รายละเอียดเพิ่มเติม");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

            mWebView = (WebView) findViewById(R.id.web_view);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("https://medthai.com/การตรวจน้ำตาลในเลือด");



        int num =getIntent().getExtras().getInt("n");

        if(num == 1){
            mWebView.loadUrl("https://medthai.com/การตรวจน้ำตาลในเลือด");
        }
        else if(num == 2){
            mWebView.loadUrl("https://medthai.com/การตรวจไขมันในเลือด");
        }
        else{
            mWebView.loadUrl("https://www.thairath.co.th/home");
        }

        WebSettings sett  = mWebView.getSettings();
        sett.setJavaScriptEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {

        if(mWebView.canGoBack()){
            mWebView.goBack();
        }
       else{
            onBackPressed();
        }
        return true;
    }

}
