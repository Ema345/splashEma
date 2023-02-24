package com.example.splashema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashema.Json.MyData;
import com.example.splashema.Json.MyInfo;
import com.example.splashema.MyAdapter.MyAdapter;
import com.example.splashema.service.BdContras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity {
    private TextView usuario;
    private Button api;
    private ListView listView;
    private List<MyData> list;
    public static String TAG = "Menu";
    private int []images = { R.drawable.icono1,R.drawable.icono2,R.drawable.icono3, R.drawable.icono4, R.drawable.icono5,
            R.drawable.icono6, R.drawable.icono7, R.drawable.icono8, R.drawable.icono9, R.drawable.icono10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        int idusu = 0;
        String aux = null;
        MyInfo info = null;
        Object object = null;
        MyData myData = null;
        BdContras contrasbd = null;
        contrasbd = new BdContras(getBaseContext());
        api = findViewById(R.id.config);
        usuario = findViewById(R.id.textUser);
        Intent intent = getIntent();
        listView = (ListView) findViewById(R.id.listViewId);
        api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, ApisActivity.class);
                startActivity(intent);
            }
        });
        list = new ArrayList<MyData>();
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
                        idusu = info.getIdUser();
                        Log.d(TAG, String.valueOf(idusu));
                        list = contrasbd.getContras(idusu);
                        if(list == null){
                            Toast.makeText(getBaseContext(), "No hay contras", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
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

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        boolean flag = false;
        flag = super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu ,  menu);
        return flag;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        MyInfo info = null;
        Object object = null;
        Intent intent = getIntent();
        object = intent.getExtras().get("MyInfo");
        info = (MyInfo) object;
        switch (item.getItemId() ) {
            case R.id.agregarId:
                Intent olvideContra = new Intent(menu.this, Agregarcontra.class);
                olvideContra.putExtra("MyInfo", info);
                startActivity(olvideContra);
                break;
            case R.id.elimId:
                Intent elimContra = new Intent(menu.this, eliminacontra.class);
                elimContra.putExtra("MyInfo", info);
                startActivity(elimContra);
                break;
            case R.id.editarId:
                Intent editaContra = new Intent(menu.this, editacontra.class);
                editaContra.putExtra("MyInfo", info);
                startActivity(editaContra);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
    private void toast( int i )
    {
        Toast.makeText(getBaseContext(), list.get(i).getContra(), Toast.LENGTH_SHORT).show();
    }

}