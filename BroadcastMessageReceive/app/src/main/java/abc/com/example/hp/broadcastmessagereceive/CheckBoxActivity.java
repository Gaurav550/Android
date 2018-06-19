package abc.com.example.hp.broadcastmessagereceive;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.R.color.white;

public class CheckBoxActivity extends AppCompatActivity {

    public static CheckBox cb1;
    Button setProfile,tutor;
    public static AudioManager audioManager;
    public static boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        if(ContextCompat.checkSelfPermission(CheckBoxActivity.this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(CheckBoxActivity.this, new String[] {Manifest.permission.RECEIVE_SMS}, 1);
            //Log.d("sdvsgss", "sfsfsga");

        }


        //cb2 = (CheckBox) findViewById(R.id.checkbox2);
        setProfile = (Button) findViewById(R.id.setProfile);
        tutor = (Button) findViewById(R.id.tutor);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        cb1 = (CheckBox)findViewById(R.id.checkbox1);


        SharedPreferences sp = getSharedPreferences("checBox_status", Context.MODE_PRIVATE);
        status = sp.getBoolean("CheckBox", false);
        cb1.setChecked(status);
        if(status)
        {
            cb1.setButtonDrawable(R.drawable.checked);
        }
        else
        {
            cb1.setButtonDrawable(R.drawable.unchecked);
        }

cb1.setTextColor(Color.parseColor("#ffffff"));
        setProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });
        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Tutorial.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"checked or unchecked",Toast.LENGTH_LONG).show();
                if(cb1.isChecked())
                    cb1.setButtonDrawable(R.drawable.checked);
                else
                cb1.setButtonDrawable(R.drawable.unchecked);
                saveInfo();
            }
        });
    }

   /* public void run() {
        cb1 = (CheckBox) findViewById(R.id.checkbox1);

    if(cb1.isChecked()==true)

    {
          status=true;
        //MainActivity.messageProcessing(str);

    }
}
*/
   @Override
   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
       if (requestCode == 1) {
           if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
    Toast.makeText(getApplicationContext(),"Your permission is granted now",Toast.LENGTH_LONG).show();
           }
       }
   }

    public static void messageProcessing(String message) {
        if (message.equalsIgnoreCase("Normal") || message.equalsIgnoreCase("Ring"))
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        if(message.equalsIgnoreCase("vibrate"))
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        if(message.equalsIgnoreCase("silent"))
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);


    }
    public void saveInfo() {
        SharedPreferences sp = getSharedPreferences("checBox_status", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("CheckBox", cb1.isChecked());
        editor.commit();

    };
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}



