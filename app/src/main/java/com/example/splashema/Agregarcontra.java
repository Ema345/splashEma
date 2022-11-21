package com.example.splashema;

import static com.example.splashema.Registro.archivo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DirectAction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashema.Json.MyData;
import com.example.splashema.Json.MyInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Agregarcontra extends AppCompatActivity {
    public static String TAG = "mensaje";
    private List<MyData> lista;
    Button regiscontra;
    private EditText contra2, red;
    private TextView contrasena, red2;
    private int []images = { R.drawable.icono1,R.drawable.icono2,R.drawable.icono3, R.drawable.icono4, R.drawable.icono5,
            R.drawable.icono6, R.drawable.icono7, R.drawable.icono8, R.drawable.icono9, R.drawable.icono10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarcontra);
        regiscontra = findViewById(R.id.regiscontra);
        red = findViewById(R.id.red);
        contra2 = findViewById(R.id.nuevacontra);
        contrasena = findViewById(R.id.nuevacontra);
        red2 = findViewById(R.id.red);
        Intent intent = getIntent();
        Object object = null;
        MyInfo info = null;
        List<MyInfo> list =new ArrayList<MyInfo>();
        regiscontra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyData myData = null;
                Object object = null;
                MyInfo info = null;
                object = intent.getExtras().get("MyInfo");
                info = (MyInfo) object;
                lista = info.getContras();
                myData = new MyData();
                myData.setContra(String.valueOf(contrasena.getText()));
                myData.setRed(String.valueOf(red.getText()));
                myData.setImage(images[lista.size()]);
                lista.add(myData);
                info.setContras(lista);
                List2Json(info,list);
                Intent intent = new Intent(Agregarcontra.this, menu.class);
                intent.putExtra("MyInfo", info);
                startActivity(intent);
            }
        });

    }
    public void List2Json(MyInfo info,List<MyInfo> list){
        Gson gson =null;
        String json= null;
        gson =new Gson();
        list.add(info);
        json =gson.toJson(list, ArrayList.class);
        if (json == null)
        {
            Log.d(TAG, "Error json");
        }
        else
        {
            Log.d(TAG, json);
            writeFile(json);
        }
        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
    }
    private boolean writeFile(String text){
        File file =null;
        FileOutputStream fileOutputStream =null;
        try{
            file=getFile();
            fileOutputStream = new FileOutputStream( file );
            fileOutputStream.write( text.getBytes(StandardCharsets.UTF_8) );
            fileOutputStream.close();
            Log.d(TAG, "Hola");
            return true;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    private File getFile(){
        return new File(getDataDir(),archivo);
    }

}