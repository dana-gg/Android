package com.example.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main1 extends AppCompatActivity {

    EditText name_product;
    EditText price;
    EditText count;
    EditText manufacturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        name_product = findViewById(R.id.name_product);
        price = findViewById(R.id.price);
        count = findViewById(R.id.count);
        manufacturer = findViewById(R.id.manufacturer);
        EditText[] inputArr = {name_product, price, count, manufacturer};
        this.focusEdit(inputArr);

       /* Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);


        setContentView(textView);*/
    }

    private void focusEdit(EditText[] inputArr) {
        int length = inputArr.length;
        for(int i = 0; i < length; i++ ) {
            final EditText input = inputArr[i];
            input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        input.setBackgroundResource(R.drawable.edit_text_border);
                    }
                }
            });
        }
    }

    public void save(View view){
        Toast toast = Toast.makeText(this, "Click",Toast.LENGTH_LONG);
        toast.show();
    }


}