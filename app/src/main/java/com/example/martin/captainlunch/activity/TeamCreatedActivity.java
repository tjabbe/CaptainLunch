package com.example.martin.captainlunch.activity;

import com.example.martin.captainlunch.R;
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

public class TeamCreatedActivity extends AppCompatActivity implements View.OnClickListener {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamcreated);

        next = (Button) findViewById(R.id.nextcreateteambutton);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.nextcreateteambutton) {
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
