package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    private Button button2;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2=(Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SellActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        db= FirebaseDatabase.getInstance().getReference().child("Product");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                listItems.clear();
                for(DataSnapshot ds:snapshot.getChildren()){
                    String pname=ds.child("pname").getValue().toString();
                    String price=ds.child("price").getValue().toString();
                    String cTime=ds.child("cTime").getValue().toString();
                    String cDate=ds.child("cDate").getValue().toString();
                    String tQuan=ds.child("tQuan").getValue().toString();
                    String amount=ds.child("amount").getValue().toString();
                    String unit=ds.child("unit").getValue().toString();
                    ListItem recycleModel = new ListItem(pname,price,cTime,cDate,tQuan,amount,unit);
                    listItems.add(recycleModel);
                    adapter = new MyAdapter(listItems,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });


    }
}