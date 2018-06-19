package abc.com.example.hp.broadcastmessagereceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread th = new Thread()
        {
          public void run()
          {
              try {
                  sleep(3000);
                  Intent i = new Intent(getApplicationContext(),CheckBoxActivity.class);
                  startActivity(i);

              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        th.start();
    }
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}
