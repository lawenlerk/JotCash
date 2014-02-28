package com.lawenlerk.jotcash.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by enlerklaw on 2/27/14.
 */
public class CategoriesTable {
    public static final String TABLE_NAME = "categories";

    public static final String ID = "CATEGORY_ID";
    public static final String CATEGORY = "category";
    public static final String LAST_USED = "last_used";
    public static final String COUNT = "count";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CATEGORY + " TEXT NOT NULL, " +
            LAST_USED + " TEXT NOT NULL, " +
            COUNT + " INTEGER NOT NULL" + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(SQL_CREATE_TABLE);
        Log.w(CategoriesTable.class.getName(), SQL_CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(TransactionsTable.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

}
