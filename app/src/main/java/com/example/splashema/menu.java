package com.example.splashema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashema.Json.MyData;
import com.example.splashema.Json.MyInfo;
import com.example.splashema.MyAdapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity {
    private TextView usuario;
    private ListView listView;
    private List<MyData> list;
    private int []images = { R.drawable.icono1,R.drawable.icono2,R.drawable.icono3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String aux = null;
        MyInfo info = null;
        Object object = null;
        MyData myData = null;
        usuario = findViewById(R.id.textUser);
        Intent intent = getIntent();
        listView = (ListView) findViewById(R.id.listViewId);
        list = new ArrayList<MyData>();
        for( int i = 0; i < 3; i++)
        {
            myData = new MyData();
            myData.setContra( String.format( "Contraseña%d" , (int)(Math.random()*10000) ) );
            if(i==0){
                myData.setRed(String.format( "Facebook"));
                myData.setImage(images[0]);
            }
            if(i==1){
                myData.setRed(String.format( "Instagram"));
                myData.setImage(images[1]);
            }
            if(i==2){
                myData.setRed(String.format( "Whatsapp" ));
                myData.setImage(images[2]);
            }
            list.add( myData );
        }
        MyAdapter myAdapter = new MyAdapter( list , getBaseContext() );
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                toast( i );
            }
        });
        if( intent != null)
        {
            aux = intent.getStringExtra("Usuario" );
            if( aux != null && aux.length()> 0 )
            {
                usuario.setText(aux);
            }
            if( intent.getExtras() != null ) {
                object = intent.getExtras().get("MyInfo");
                if (object != null) {
                    if (object instanceof MyInfo) {
                        info = (MyInfo) object;
                        usuario.setText("Bienvenido " + info.getUsuario() + " de edad " + info.getEdad());
                    }
                }
            }
        }

    }
    private void toast( int i )
    {
        Toast.makeText(getBaseContext(), list.get(i).getContra(), Toast.LENGTH_SHORT).show();
    }

}