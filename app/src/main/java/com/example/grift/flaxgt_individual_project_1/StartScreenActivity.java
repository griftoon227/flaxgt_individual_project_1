package com.example.grift.flaxgt_individual_project_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartScreenActivity extends AppCompatActivity {

    Button regBtn, loginBtn;
    boolean enableLogin = false;
    String username = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        //get the intent sent to the activity when created
        Intent intent = getIntent();
        //instantiate a bundle of the intent's extras
        Bundle extrasBundle = intent.getExtras();

        //determine if there are extras sent to the bundle from the intent, and if so, store the data in variables
        if(extrasBundle != null && !extrasBundle.isEmpty())
        {
            enableLogin = extrasBundle.containsKey("enableLogin");
            username = extrasBundle.getString("username");
            password = extrasBundle.getString("password");
        }

        //associate the buttons for usage
        regBtn = findViewById(R.id.registration_btn);
        loginBtn = findViewById(R.id.login_btn);

        //ensure that the button is not enabled when the user is not registered yet
        if(!enableLogin)
            loginBtn.setEnabled(false);
    }

    //move to a new screen depending on what button is clicked
    public void move_to_next_screen(View view) {
        //the view is a button
        Button btn = (Button)view;

        //go to the registration screen if its the registration button
        if (btn.getId() == regBtn.getId())
            startActivity(new Intent(StartScreenActivity.this, RegistrationActivity.class));
        //go to the login screen if its the login button & send over the username and password stored through an intent
        else if(btn.getId() == loginBtn.getId()) {
            Intent intent = new Intent(StartScreenActivity.this, LoginActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
