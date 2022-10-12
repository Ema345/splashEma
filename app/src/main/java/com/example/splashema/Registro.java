package com.example.splashema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import com.example.splashema.Json.MyInfo;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {
    Switch SwitchM;
    EditText NumeroMas;
    Button Regresar;
    private static final String TAG = "MainActivity";
    public static final String archivo = "archivo.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        SwitchM= (Switch) findViewById(R.id.idswitch);
        NumeroMas = (EditText) findViewById(R.id.NumeroM);
        Regresar = (Button)findViewById(R.id.button4);
        setContentView(R.layout.activity_registro);

        List<MyInfo> list =new ArrayList<MyInfo>();
        Regresar = findViewById(R.id.button4);
        Button button4 = findViewById(R.id.button4);
        EditText usuario = findViewById(R.id.TxtUsu);
        EditText pswd = findViewById(R.id.TxtContra);
        EditText mail = findViewById(R.id.TxtCorreo);
        EditText edad = findViewById(R.id.TxtEdad);
        RadioButton r1 = findViewById(R.id.radioBMujer);
        RadioButton r2 = findViewById(R.id.radioBHombre);
        CheckBox tipo = findViewById(R.id.checkBoxEsTra);
        CheckBox tipo2 = findViewById(R.id.checkBoxEstu);

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(Registro.this, Login.class);
                startActivity(registro);
            }
        });
    }

    public void onclick2(View view) {
        if(view.getId()==R.id.idswitch){
            if (SwitchM.isChecked()){
                NumeroMas.setText("Numero de Mascotas");
                NumeroMas.setEnabled(true);
            }
            else{
                NumeroMas.setText("Campo desabilitado");
                NumeroMas.setEnabled(false);
            }
        }
    }public void Objet2Json(MyInfo info){
        Gson gson =null;
        String json= null;
        String mensaje = null;
        gson =new Gson();
        json = gson.toJson(info);
        if (json != null) {
            Log.d(TAG, json);
            mensaje = "object2Json OK";
        } else {
            mensaje = "Error object2Json";
        }
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
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