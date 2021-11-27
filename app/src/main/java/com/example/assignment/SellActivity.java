package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class SellActivity extends AppCompatActivity {

    EditText productName;
    EditText price;
    EditText unit;
    EditText tquantity;
    Button save;
    TextView Date;
    TextView Time, Amount;

    double proprice;
    double quant;
    double bill;

    DatabaseReference db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        TextView textView= findViewById(R.id.currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(new Date());
        textView.setText(currentDate);

        TextView timeView = findViewById(R.id.currentTime);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
        String strDate = stf.format(calendar.getTime());
        display(strDate);

        productName = findViewById(R.id.productName);
        price = findViewById(R.id.price);
        unit = findViewById(R.id.unit);
        tquantity = findViewById(R.id.tquantity);
        save = findViewById(R.id.save);
        Date = findViewById(R.id.currentDate);
        Time = findViewById(R.id.currentTime);
        Amount = findViewById(R.id.calculation);

        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String priceString = price.getText().toString();
                if(priceString.length()>0){
                    proprice=Double.parseDouble(priceString);
                }
                String quantString = tquantity.getText().toString();
                if(quantString.length()>0){
                    quant=Double.parseDouble(quantString);
                }

                double bill= Tbill();
                Amount.setText(Double.toString(bill));

            }
        });

        tquantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String priceString = price.getText().toString();
                if(priceString.length()>0){
                    proprice=Double.parseDouble(priceString);
                }
                String quantString = tquantity.getText().toString();
                if(quantString.length()>0){
                    quant=Double.parseDouble(quantString);
                }
                double bill= Tbill();
                Amount.setText(Double.toString(bill));
            }
        });


        db = FirebaseDatabase.getInstance().getReference().child("Product");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertProductData();
            }
        });


    }

    double Tbill(){
        return proprice*quant;
    }

    private void insertProductData(){
       String  pname = productName.getText().toString();
       String Price = price.getText().toString();
       String Unit = unit.getText().toString();
       String tQuan = tquantity.getText().toString();
       String cDate = Date.getText().toString();
       String cTime = Time.getText().toString();
       String amount = Amount.getText().toString();

       ProductData productData = new ProductData(pname,Price,Unit,tQuan,cDate,cTime,amount);

       db.push().setValue(productData);
        Toast.makeText(SellActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();
    }


    private void display(String num){
        TextView timeView = findViewById(R.id.currentTime);
        timeView.setText(num);
    }


}