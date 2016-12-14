package com.example.martin.captainlunch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Martin on 13/12/2016.
 */

public class JoinTeamActivity extends AppCompatActivity implements View.OnClickListener {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jointeam);

        next = (Button) findViewById(R.id.jointeambutton);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.jointeambutton) {
            Intent MainActivity = new Intent(this, MainActivity.class);
            Intent intent_finish = new Intent("finish_activity");
            startActivity(MainActivity);
            finish();
            sendBroadcast(intent_finish);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
