package com.example.habrweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        browser = findViewById(R.id.webBrowser);
//        browser.
    }

    public void download (View view){
        browser = findViewById(R.id.webBrowser);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://vk.com/");
    }

    public void stop (View view){
        browser = findViewById(R.id.webBrowser);
        browser.stopLoading();
    }

    public void copyURL (View view){
        browser = findViewById(R.id.webBrowser);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", browser.getUrl().toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Скопировано", Toast.LENGTH_SHORT).show();
    }

    public void zoomOut(View view){
        browser = findViewById(R.id.webBrowser);
        browser.zoomOut();
    }

    public void zoomIn(View view){
        browser = findViewById(R.id.webBrowser);
        browser.zoomIn();
    }

    public void back(View view){
        browser = findViewById(R.id.webBrowser);
        browser.goBack();
    }

    public void next(View view){
        browser = findViewById(R.id.webBrowser);
        browser.goForward();
    }

    public void clearCache(View view){
        browser = findViewById(R.id.webBrowser);
        browser.clearCache(true);
        browser.clearView();
        Toast.makeText(this, "Кэш очищен", Toast.LENGTH_SHORT).show();
    }

}