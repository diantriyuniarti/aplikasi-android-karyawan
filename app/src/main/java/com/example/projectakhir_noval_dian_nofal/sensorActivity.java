package com.example.projectakhir_noval_dian_nofal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.projectakhir_noval_dian_nofal.R;

import java.util.ArrayList;

public class sensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer, proximitySensor, gyroscopeSensor;
    private TextView tvAccelerometerData, tvGyroscopeData, tvProximityData;
    private Switch switchAccelerometer, switchGyroscope, switchProximity;
    private int activeSensorType = -1;

    private long lastTime = 0;
    private ArrayList<Long> beatTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        // Inisialisasi views
        switchAccelerometer = findViewById(R.id.switchAccelerometer);
        switchGyroscope = findViewById(R.id.switchGyroscope);
        switchProximity = findViewById(R.id.switchProximity);
        tvAccelerometerData = findViewById(R.id.tvAccelerometerData);
        tvGyroscopeData = findViewById(R.id.tvGyroscopeData);
        tvProximityData = findViewById(R.id.tvProximityData);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager == null) {
            Toast.makeText(this, "Sensor tidak tersedia di perangkat ini", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        switchAccelerometer.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchGyroscope.setChecked(false);
                switchProximity.setChecked(false);
                aktifkanSensor(Sensor.TYPE_ACCELEROMETER);
            } else if (activeSensorType == Sensor.TYPE_ACCELEROMETER) {
                nonaktifkanSensor();
            }
        });
        switchGyroscope.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchAccelerometer.setChecked(false);
                switchProximity.setChecked(false);
                aktifkanSensor(Sensor.TYPE_GYROSCOPE);
            } else if (activeSensorType == Sensor.TYPE_GYROSCOPE) {
                nonaktifkanSensor();
            }
        });
        switchProximity.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                switchAccelerometer.setChecked(false);
                switchGyroscope.setChecked(false);
                aktifkanSensor(Sensor.TYPE_PROXIMITY);
            } else if (activeSensorType == Sensor.TYPE_PROXIMITY) {
                nonaktifkanSensor();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbarSensor);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Sensor Activity");
        }
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void aktifkanSensor(int sensorType) {
        nonaktifkanSensor();
        activeSensorType = sensorType;
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                if (accelerometer != null) {
                    sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
                } else {
                    tvAccelerometerData.setText("Accelerometer tidak tersedia di perangkat ini.");
                }
                break;
            case Sensor.TYPE_GYROSCOPE:
                if (gyroscopeSensor != null) {
                    sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
                } else {
                    tvGyroscopeData.setText("Gyroscope tidak tersedia di perangkat ini.");
                }
                break;
            case Sensor.TYPE_PROXIMITY:
                if (proximitySensor != null) {
                    sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
                } else {
                    tvProximityData.setText("Proximity sensor tidak tersedia di perangkat ini.");
                }
                break;
        }
    }

    private void nonaktifkanSensor() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        activeSensorType = -1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Tidak auto aktifkan sensor apapun
    }

    @Override
    protected void onPause() {
        super.onPause();
        nonaktifkanSensor();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event == null || event.sensor == null) return;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            tvAccelerometerData.setText(String.format("x-axis: %.2f m/s²\ny-axis: %.2f m/s²\nz-axis: %.2f m/s²", x, y, z));
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            tvGyroscopeData.setText(String.format("x-axis: %.4f rad/s\ny-axis: %.4f rad/s\nz-axis: %.4f rad/s", x, y, z));
        } else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float distance = event.values[0];
            tvProximityData.setText(String.format("Jarak: %.2f cm", distance));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Tidak digunakan
    }
}
