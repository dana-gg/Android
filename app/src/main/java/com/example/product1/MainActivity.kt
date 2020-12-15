package com.example.product1

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.view.MenuItem
import android.view.Menu
import com.example.product1.addtovar.AddTovarFragment
import com.example.product1.tovarslist.TovarListFragment
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    //public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        Timber.i("onCreate Called");
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main,  TovarListFragment())
                    .commit();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean  {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_tovar -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, AddTovarFragment()).commit()
            R.id.action_about -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, AboutFragment()).commit()
            R.id.terms_using -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, UsingTermsFragment()).commit()
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