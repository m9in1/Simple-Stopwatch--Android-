package LL;

import static androidx.core.content.ContextCompat.getSystemService;


import android.app.Activity;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class VibrationClass {

    final private VibrationEffect vMax = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);
    final private VibrationEffect vMin = VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE);
    final Vibrator vibrator;
    public VibrationClass(Context context){
        this.vibrator    = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }
    public  void  vibrateMax(){ vibrator.vibrate(vMax); }
    public  void vibrateMin(){ vibrator.vibrate(vMin); }

}
