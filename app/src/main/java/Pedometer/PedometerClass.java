package Pedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class PedometerClass {

    PedometerClass(Context context) {
        SensorManager sensorManager =
                (SensorManager) context.getSystemService(Activity.SENSOR_SERVICE);
        // sensorType is either Sensor.TYPE_STEP_COUNTER or Sensor.TYPE_STEP_DETECTOR
       // Sensor sensor = sensorManager.getDefaultSensor(sensorType);


    }
}
