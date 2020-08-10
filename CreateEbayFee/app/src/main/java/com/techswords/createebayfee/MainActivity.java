package com.techswords.createebayfee;

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
    public void calculate(View v){
        //Get Test in UI
        EditText etsell = findViewById(R.id.sellingPrice);
        EditText etship = findViewById(R.id.shippingPrice);
        EditText etebay = findViewById(R.id.ebayFee);
        EditText etpaypal = findViewById(R.id.paypalFee);

        //Get text From usd TextField
        String price1= etsell.getText().toString();
        String price2= etship.getText().toString();

        //Convert Text To Double
        double price = Double.parseDouble(price1);
        double ship = Double.parseDouble(price2);

        // Convert to LKR
        double ebay = (price+ship)*0.1;
        double paypal = (price+ship)*2.9+0.3;

        //convert double to string
        String Cebay = String.valueOf(ebay);
        String Cpaypal = String.valueOf(paypal);

        //Set lkrTest Value to Test Field
        etebay.setText(Cebay);
        etpaypal.setText(Cpaypal);
    }
}
