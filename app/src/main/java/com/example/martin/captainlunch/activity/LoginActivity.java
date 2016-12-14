package com.example.martin.captainlunch.activity;

import com.example.martin.captainlunch.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Martin on 13/12/2016.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button createTeam;
    private EditText code_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createTeam = (Button) findViewById(R.id.createteambutton);
        createTeam.setOnClickListener(this);

        monitorCode();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.createteambutton) {
            createTeamActivity();
        }
    }

    // set up broadcast to kill activity once the user has created a team
    BroadcastReceiver broadcast_receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent_finish) {
            String action = intent_finish.getAction();

            if(action.equals("finish_activity")) {
                finish();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcast_receiver, new IntentFilter("finish_activity"));
    }

    private void createTeamActivity() {
        Intent CreateTeam = new Intent(this, CreateTeamActivity.class);

        startActivity(CreateTeam);
    }

    // check for when the user typed 4 digits in the code input
    private void monitorCode() {
        code_count = (EditText) findViewById(R.id.codeinput);

        final TextWatcher codewatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.length() == 4) {
                    Intent JoinTeam = new Intent(LoginActivity.this, JoinTeamActivity.class);
                    startActivity(JoinTeam);
                    code_count.setText("");
                }
            }
        };

        code_count.addTextChangedListener(codewatcher);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
