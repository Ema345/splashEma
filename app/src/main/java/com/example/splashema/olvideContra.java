package com.example.splashema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.splashema.Json.MyInfo;
import com.example.splashema.des.MyDesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class olvideContra extends AppCompatActivity {
    /*Button olvideContra;
    private List<MyInfo> list;
    public static final String TAG = "Ema";
    public static final String KEY = "+4xij6jQRSBdCymMxweza/uMYo+o0EUg";
    private String testClaro, testDesCifrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvide_contra);
        olvideContra = findViewById(R.id.button);
        String testCifrado = null;
        MyDesUtil myDesUtil = null;


        //testCifrado = "KdSqSsH+W2gk1j361x9IlQ==";

        testDesCifrado = myDesUtil.desCifrar( testCifrado );
        if( !isNotNullAndNotEmpty( testDesCifrado ) )
        {
            return;
        }
        Log.i( TAG, testDesCifrado );

        Log.i( TAG , myDesUtil.toStringSecreteKey( ) );
        olvideContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MyDesUtil myDesUtil = null;
                String testCifrado = null;
                Intent intent = getIntent();
                String text = null;
                text = String.valueOf(intent.getExtras().get("Json"));
                json2List(text);
                String correo = null;
                int i = 0;
                for (MyInfo myInfo : list) {
                    correo = myInfo.getCorreo();
                    i = 1;
                }
                myDesUtil = new MyDesUtil( );
                if( isNotNullAndNotEmpty( KEY ) )
                {
                    myDesUtil.addStringKeyBase64( KEY );
                }
                if( !isNotNullAndNotEmpty( correo ) )
                {
                    return;
                }

                testCifrado = myDesUtil.cifrar( correo );
                if( !isNotNullAndNotEmpty( testCifrado ) )
                {
                    return;
                }
                Log.i( TAG , testCifrado );
                if( text == null || text.length() == 0 )
                {
                    Toast.makeText(getBaseContext() , "Text is null" , Toast.LENGTH_LONG );
                }
                if( sendInfo( text ) )
                {
                    Toast.makeText(getBaseContext() , "Se envío el texto" , Toast.LENGTH_LONG );
                    return;
                }
                Toast.makeText(getBaseContext() , "Error en el envío" , Toast.LENGTH_LONG );
            }
        });
    }

    public boolean sendInfo( String text )
    {
        JsonObjectRequest jsonObjectRequest = null;
        JSONObject jsonObject = null;
        String url = "https://us-central1-nemidesarrollo.cloudfunctions.net/envio_correo";
        RequestQueue requestQueue = null;
        if( text == null || text.length() == 0 )
        {
            return false;
        }
        jsonObject = new JSONObject( );
        try
        {
            jsonObject.put("hola" , text );
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                Log.i(TAG, response.toString());
            }
        } , new  Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        } );
        requestQueue = Volley.newRequestQueue( getBaseContext() );
        requestQueue.add(jsonObjectRequest);

        return true;
    }
    public boolean isNotNullAndNotEmpty( String aux )
    {
        return aux != null && aux.length() > 0;
    }
    public void json2List(String json) {
        Gson gson = null;
        String mensaje = null;
        if (json == null || json.length() == 0) {
            Toast.makeText(getApplicationContext(), "Error json null or empty", Toast.LENGTH_LONG).show();
            return;
        }
        gson = new Gson();
        Type listType = new TypeToken<ArrayList<MyInfo>>() {
        }.getType();
        list = gson.fromJson(json, listType);
        if (list == null || list.size() == 0) {
            Toast.makeText(getApplicationContext(), "Error list is null or empty", Toast.LENGTH_LONG).show();
            return;
        }
    }*/
}