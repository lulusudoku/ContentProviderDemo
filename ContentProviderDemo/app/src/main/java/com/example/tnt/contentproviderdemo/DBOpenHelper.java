package com.example.tnt.contentproviderdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    //数据库名
    private static final String DATA_BASE_NAME = "note.db";
    //数据库版本号
    private static final int DATE_BASE_VERSION = 1;
    public DBOpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATE_BASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        初始化表信息 无主键   只有 标题，日期
        String createTableNoteBookSQL = "create table "+NoteBook.NB_tableName+" ("+NoteBook.NB_title+" text ,"+NoteBook.NB_date+" text)";
        db.execSQL(createTableNoteBookSQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
