package com.techswords.vehical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText full_cost, profit, client_name, phone_number;
        Button button_submit;

//        full_cost = findViewById(R.id.full_cost);
//        profit = findViewById(R.id.profit);
//        client_name = findViewById(R.id.client_name);
//        phone_number = findViewById(R.id.phone_number);
        button_submit = findViewById(R.id.button_submit);
//
//        final String MailFullCost= full_cost.getText().toString();
//        final String MailProfit = profit.getText().toString();
//        final String MailPhoneNumber = phone_number.getText().toString();





        button_submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String mail = "pdncpathiraja95@gmail.com".trim();

                EditText MailClient_name = findViewById(R.id.client_name);
                String MailClientName = MailClient_name.getText().toString();

                EditText MailPhone_number = findViewById(R.id.phone_number);
                String MailPhoneNumber = MailPhone_number.getText().toString();

                EditText MailFullCostText = findViewById(R.id.full_cost);
                String MailFullCost = MailFullCostText.getText().toString();

                EditText MailProfitText = findViewById(R.id.profit);
                String MailProfit = MailProfitText.getText().toString();

                String msg = MailClientName + " Asked Vehicle Price "+ MailFullCost+ " And Its Profit "+MailProfit+ ". His Phone Number : " + MailPhoneNumber;
                String subject = "Vehicle Price";

                sendEmail(mail,subject,msg);
            }
        });
    }

    public void sendEmail(String mail, String subject, String msg) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);

        mEmailIntent.setData(Uri.parse("mailto: "));
        mEmailIntent.setType("text/plain");

        mEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});

        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);

        mEmailIntent.putExtra(Intent.EXTRA_TEXT,msg);

        try {
            startActivity(Intent.createChooser(mEmailIntent, "Store Vehicle Search Data"));
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }







    public void calculate(View v){
        EditText market_price = findViewById(R.id.market_price);
        EditText selling_price = findViewById(R.id.selling_price);
        EditText profit = findViewById(R.id.profit);
        EditText full_cost = findViewById(R.id.full_cost);

        //convert to String
        String m_price= market_price.getText().toString();
        String s_price = selling_price.getText().toString();

        //convert to Double
        double mark_price = Double.parseDouble(m_price);
        double sell_price = Double.parseDouble(s_price);

        //extra values
        double tax1 = 100;
        double tax2 = 20;

        //calculate full_cost
        double f_cost  = mark_price + tax1 + tax2;
        double profit_cal = sell_price - f_cost;

        //set to string
        String S_f_cost= String.valueOf(f_cost);
        String S_profit_cal = String.valueOf(profit_cal);

        //Send to text field
        profit.setText(S_profit_cal);
        full_cost.setText(S_f_cost);


    }

    public void cancle(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are You want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog  = builder.create();
        alertDialog.show();
    }
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are You want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog  = builder.create();
        alertDialog.show();
    }
}
