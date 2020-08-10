package com.techswords.conveter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View v){
        //Get Test in UI
        EditText etUSD = findViewById(R.id.etUSD);
        EditText etLKR = findViewById(R.id.etLKR);

        //Get text From usd TextField
        String text= etUSD.getText().toString();
        //Convert Text To Double
        double usd = Double.parseDouble(text);

        // Convert to LKR
        double lkr = usd*195;
        //convert double to string
        String lkrText = String.valueOf(lkr);

        //Set lkrTest Value to Test Field
        etLKR.setText(lkrText);



    }
}
