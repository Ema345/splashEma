package com.example.splashema;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ApisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apis);
        Button boton = (Button)findViewById(R.id.buttonV);
        Button boton2 = (Button)findViewById(R.id.buttonI);
        Button boton3 = (Button)findViewById(R.id.buttonNFC);
        boton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Intent panelIntent = new Intent(Settings.Panel.ACTION_VOLUME);
                startActivity(panelIntent);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
                startActivity(panelIntent);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Intent panelIntent = new Intent(Settings.Panel.ACTION_NFC);
                startActivity(panelIntent);
            }
        });
    }
}
