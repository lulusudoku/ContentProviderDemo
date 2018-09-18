package com.example.getappdata;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    public static final String AUTHORITY = "com.example.tnt.contentproviderdemo.NoteBookProvider";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri noteBookUri = Uri.parse("content://"+AUTHORITY+"/"+NoteBook.NB_tableName);
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
