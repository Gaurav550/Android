package abc.com.example.hp.broadcastmessagereceive;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;


public class MainActivity extends AppCompatActivity {

    private Button Vibrate, Ring, Silent, Mode;
    private TextView sms;
    public static AudioManager myAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrate = (Button) findViewById(R.id.button2);
        Ring = (Button) findViewById(R.id.button4);
        Silent = (Button) findViewById(R.id.button3);
        myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Settings.System.putInt(getContentResolver(), Settings.System.AIRPLANE_MODE_ON,1);
    }




    public void vibrate(View view) {
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

    public void ring(View view) {
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }

    public void silent(View view) {
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
   /* public void airplane(View view) throws InvocationTargetException {
        Settings.System.putInt(this.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 1);
        Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intent.putExtra("state", true);
        sendBroadcast(intent);
    }
*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}