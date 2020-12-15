package com.example.product1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    //public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, new TovarListFragment())
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.terms_using :
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new UsingTermsFragment()).commit();
                return true;
            case R.id.action_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new AboutFragment()).commit();
                return true;
            case R.id.add_product:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new add_product()).commit();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}