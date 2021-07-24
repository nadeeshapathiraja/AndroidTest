package com.techswords.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity1 extends AppCompatActivity {

    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);


        Button button = findViewById(R.id.button2);

        Intent intent = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        intent.setData(Uri.parse("mailto:"));

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pdncpathiraja@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"This is test Emailm Subject");
        intent.putExtra(Intent.EXTRA_TEXT,"This is Test Email Body");
        intent.setType("message/rfc822");
//        intent.setType("message/textpain");
        chooser = Intent.createChooser(intent,"Send Email Chooser");

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(chooser);
            }
        });


    }
}