package abc.com.example.hp.broadcastmessagereceive;



        import android.Manifest;
        import android.app.Activity;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.content.pm.PackageManager;
        import android.media.AudioManager;
        import android.support.v7.app.AppCompatActivity;
        import android.telephony.SmsMessage;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.Toast;
        import android.os.Bundle;

public class RecieveSMS extends BroadcastReceiver
{    public static final String SMS_BUNDLE = "pdus";
    //CheckBoxActivity cba;
    public static AudioManager audioManager;
    public static boolean status;
    Boolean st;
    //Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        //cba=new CheckBoxActivity();
        SharedPreferences sp = context.getSharedPreferences("checBox_status", Context.MODE_PRIVATE);
        st = sp.getBoolean("CheckBox", false);
        //cba.cb1.setChecked(cba.status);
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);

            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);
                String smsBody = smsMessage.getMessageBody().toString();
                //cba=new CheckBoxActivity(); //cba.str=smsBody;
               if(st==true)
               {
                   messageProcessing(smsBody);
               }
                //MainActivity.messageProcessing(smsBody);
                //MainActivity.myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(context, st+"", Toast.LENGTH_SHORT).show();
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
}