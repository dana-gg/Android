package com.example.products;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    String[] days = { "Понеділок", "Вівторок", "Середа", "Четвер", "Пятниця"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView daysList = (ListView) findViewById(R.id.contactsList);
        final Intent intent = new Intent(this, Main2.class);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, days);

        daysList.setAdapter(adapter);

        daysList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                startActivity(intent);
            }
        });
    }

    public void Add(View view) {
        Intent intent = new Intent(this, Main1.class);
        startActivity(intent);
    }

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}