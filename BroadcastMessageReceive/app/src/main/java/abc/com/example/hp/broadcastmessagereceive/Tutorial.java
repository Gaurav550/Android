package abc.com.example.hp.broadcastmessagereceive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Tutorial extends AppCompatActivity {
  WebView webTutorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        webTutorial=(WebView)findViewById(R.id.webTutorial);
        webTutorial.loadUrl("file:///android_asset/Tutorial.html");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}
