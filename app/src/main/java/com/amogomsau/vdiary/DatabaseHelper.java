package com.amogomsau.vdiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Diary.db";
    private static final int DATAVASE_VERSION = 1;

    // google id, date, post title, post description, image data, location data

    private static final String TABLE_NAME = "entries";
    private static final String COLUMN_ID = "google_id";
    private static final String COLUMN_DATE = "entry_date";
    private static final String COLUMN_TITLE = "entry_title";
    private static final String COLUMN_DESCRIPTION = "entry_description";
    private static final String COLUMN_IMAGE = "entry_image";
    private static final String COLUMN_LOCATION = "entry_location";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATAVASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_IMAGE + " TEXT, " +
                COLUMN_LOCATION + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
