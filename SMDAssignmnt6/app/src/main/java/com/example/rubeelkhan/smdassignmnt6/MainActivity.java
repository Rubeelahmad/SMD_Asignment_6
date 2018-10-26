package com.example.rubeelkhan.smdassignmnt6;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    private String  []mColumnProjection=new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER
    };

    private String mSelectionClaue=ContactsContract.Contacts.DISPLAY_NAME_PRIMARY+"='?'";

     private String[] mSelectionArguments=new String []{};

    private String mOrderBy=ContactsContract.Contacts.DISPLAY_NAME_PRIMARY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textview);

        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                mColumnProjection,
                null,
                null,
                null
        );

        if(cursor!=null && cursor.getCount()>0)
        {
            StringBuilder stringBuilder=new StringBuilder("");
            while(cursor.moveToNext())
            {
                stringBuilder.append(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+"\n");

            }
            textView.setText(stringBuilder.toString());
        }
        else{

            textView.setText("No Contact Found ");
        }
    }
}
