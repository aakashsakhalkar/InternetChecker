 package com.aakash.internetchecker;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aakash.netstatus.NetStatus;

 public class MainActivity extends AppCompatActivity {
     private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        boolean connected = NetStatus.isConnectedToInternet(this);
        boolean hasWiFi = NetStatus.hasWiFi(this);
        boolean hasMobile = NetStatus.hasMobileData(this);
        String connectionType = NetStatus.getConnectionType(this);

        Log.d(TAG, "Connected: " + connected);
        Log.d(TAG, "WiFi: " + hasWiFi);
        Log.d(TAG, "Mobile: " + hasMobile);
        Log.d(TAG, "Connection Type: " + connectionType);
    }
}