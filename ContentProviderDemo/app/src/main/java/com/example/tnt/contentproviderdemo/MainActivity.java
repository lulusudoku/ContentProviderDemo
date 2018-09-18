package com.example.tnt.contentproviderdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    public static final String AUTHORITY = "com.example.tnt.contentproviderdemo.NoteBookProvider";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    将内容提交至数据库
    public void click(View view) {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        Uri noteBookUri = Uri.parse("content://"+AUTHORITY+"/"+NoteBook.NB_tableName);
//
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteBook.NB_title,"特朗普连任");
        contentValues.put(NoteBook.NB_date,"20220401");
//
////        调用中间者 携带 数据过去
        getContentResolver().insert(noteBookUri,contentValues);
//
//        调用中间者 查询 数据
        Cursor noteBookCursor =  getContentResolver().query(noteBookUri,new String[]{NoteBook.NB_title,NoteBook.NB_date},null,null,null);
        if(noteBookCursor!=null)
        {
            while(noteBookCursor.moveToNext())
            {
                Log.e(TAG,"信息如下："+noteBookCursor.getString(noteBookCursor.getColumnIndex(NoteBook.NB_title))+" "+noteBookCursor.getString(noteBookCursor.getColumnIndex(NoteBook.NB_date)));
            }
            noteBookCursor.close();
        }
    }
}
