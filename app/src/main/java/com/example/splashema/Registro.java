package com.example.splashema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.splashema.Json.MyInfo;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {
    Switch SwitchH;
    RadioButton sexoB;
    Button login, Registro;
    TextView tienehijos;
    private static final String TAG = "MainActivity";
    public static final String archivo = "archivo.json";
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    byte []res = null;
    String pass, hijos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        sexoB = (RadioButton)findViewById(R.id.radioBMujer);
        tienehijos = (TextView)findViewById(R.id.textView13);
        SwitchH= (Switch) findViewById(R.id.idswitch);
        login = (Button)findViewById(R.id.sesion);
        Registro = (Button)findViewById(R.id.Registro);
        setContentView(R.layout.activity_registro);
        List<MyInfo> list =new ArrayList<MyInfo>();
        Button registro = findViewById(R.id.Registro);
        Button login = findViewById(R.id.sesion);
        EditText usuario = findViewById(R.id.TxtUsu);
        EditText pswd = findViewById(R.id.TxtContra);
        EditText mail = findViewById(R.id.TxtCorreo);
        EditText edad = findViewById(R.id.TxtEdad);
        EditText FechaNac = findViewById(R.id.TxtNac);
        EditText Telefono = findViewById(R.id.TxtTel);
        CheckBox trabajador = findViewById(R.id.checkBoxEsTra);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Registro.this, Login.class);
                startActivity(login);
            }
        });

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                res = createSha1(String.valueOf(pswd.getText())+"ola");
                if( res != null ) {
                    Log.d(TAG, String.format("%s", bytesToHex(res)));
                    pass = bytesToHex(res);
                }
                boolean estadoRb = sexoB.isChecked();
                String sexo = null;
                if (estadoRb==true){
                    sexo = "Femenino";
                    Toast.makeText(getApplicationContext(), sexo, Toast.LENGTH_LONG).show();
                }else{
                    sexo = "Masculino";
                }
                boolean estadoCb = trabajador.isChecked();
                String tipoU = null;
                if(estadoCb==true){
                    tipoU = "Trabajador";
                }else{
                    tipoU = "Estudiante";
                }




                MyInfo info= new MyInfo();
                info.setUsuario(String.valueOf(usuario.getText()));
                info.setPassword(pass);
                info.setCorreo(String.valueOf(mail.getText()));
                info.setEdad(String.valueOf(edad.getText()));
                info.setSexo(sexo);
                info.setTusu(tipoU);
                info.setHijos(hijos);
                info.setTelefono(String.valueOf(Telefono.getText()));
                info.setFechaNac(String.valueOf(FechaNac.getText()));
                List2Json(info,list);
            }
        });
    }
    public void onClick(View view){
        if (view.getId() == R.id.idswitch) {
            if(SwitchH.isChecked()){
                tienehijos.setText("Tiene hijos");
                hijos = "Con hijos";
            }else{
                tienehijos.setText("No tiene hijos");
                hijos = "sin hijos";
            }

        }
    }

    public void Objet2Json(MyInfo info){
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
    public byte[] createSha1( String text )
    {
        MessageDigest messageDigest = null;
        byte[] bytes = null;
        byte[] bytesResult = null;
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-1");
            bytes = text.getBytes("iso-8859-1");
            messageDigest.update(bytes, 0, bytes.length);
            bytesResult = messageDigest.digest();
            return bytesResult;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}