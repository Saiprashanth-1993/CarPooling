package com.contus.carpooling.dashboard.homepage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.contus.carpooling.R;
import com.contus.carpooling.login.view.LoginActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getIntent() != null) {
            TextView emailView = (TextView) findViewById(R.id.mailId);
            emailView.setText("Welcome !! " + getIntent().getExtras().getString("name"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menubar, menu);
        return true;
    }

    /**
     * Menu for logout, file, gallery, news
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_logout:
                startActivity(new Intent(this, LoginActivity.class));
                HomeActivity.this.finishAffinity();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
