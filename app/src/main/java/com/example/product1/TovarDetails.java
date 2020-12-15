package com.example.product1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TovarDetails extends AppCompatActivity {
    TextView name_product;
    TextView price;
    TextView count;
    TextView manufacturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tovar_details);

        name_product = findViewById(R.id.name_product);
        price = findViewById(R.id.price);
        count = findViewById(R.id.count);
        manufacturer = findViewById(R.id.manufacturer);
    }


    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}