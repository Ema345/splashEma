package com.example.splashema.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.splashema.Json.MyInfo;
import com.example.splashema.contract.UsuariosContract;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDBService extends SQLiteOpenHelper {
    public static final String TAG = "UsuariosDBService";
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "REGISTROS.db";

    public static final String TABLE_USUARIOS= "TABLE_USUARIOS";
    public static final String TABLE_CONTRAS = "TABLE_CONTRAS";

    public UsuariosDBService(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UsuariosContract.UsuarioEntry.getCreateTable());
        sqLiteDatabase.execSQL(UsuariosContract.MyDataEntry.getCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USUARIOS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTRAS);
        onCreate(sqLiteDatabase);
    }


}

