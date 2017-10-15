package droidtuts4you.com.webviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private EditText mUrlBox;
    private ImageButton mSearchButton;
    private WebView mWebView;
    private String url;
    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUrlBox = (EditText) findViewById(R.id.urlBox);
        mSearchButton = (ImageButton) findViewById(R.id.searchButton);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mProgressbar = (ProgressBar) findViewById(R.id.progressbar_Horizontal);
        mProgressbar.setMax(100);
        mProgressbar.setVisibility(View.GONE);


        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mUrlBox.equals("")) { //for checking mUrlBox is empty or not.

                    url = mUrlBox.getText().toString(); //for get value of mUrlBox

                    mWebView.loadUrl(url); //for load url

                    showProgressBar();
                }
            }
        });
    }

    public void showProgressBar() {
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                mProgressbar.setProgress(newProgress);
                if (newProgress == 100) {
                    // hide the progress bar if the loading is complete
                    mProgressbar.setVisibility(View.GONE);

                } else {

                    mProgressbar.setVisibility(View.VISIBLE);

                }
            }
        });
    }

}
