package com.example.grift.flaxgt_individual_project_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameETV, passwordETV;
    String username = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //associate the edit text views for data retrieval
        usernameETV = (EditText)findViewById(R.id.username_etv);
        passwordETV = (EditText)findViewById(R.id.password_etv);

        //get the intent sent from the start screen that includes a bundle of extras including username and password
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //ensure the bundle is not null or empty so that data can be retrieved
        if(bundle != null && !bundle.isEmpty())
        {
            username = bundle.getString("username");
            password = bundle.getString("password");
        }
    }

    public void confirm_login(View view) {
        //ensure the password and username are not empty, and if they are, show a Toast
        if(usernameETV.getText().toString().isEmpty())
            Toast.makeText(LoginActivity.this, "Please enter a valid username.", Toast.LENGTH_LONG).show();
        else if(passwordETV.getText().toString().isEmpty())
            Toast.makeText(LoginActivity.this, "Please enter a valid password.", Toast.LENGTH_LONG).show();
        else {
            //need to confirm username & password existence & then login & return to previous screen, otherwise
            //show a toast saying the entered username and password are not correct and need to be re-entered
            if(usernameETV.getText().toString().equals(username) && passwordETV.getText().toString().equals(password))
                startActivity(new Intent(LoginActivity.this, StartScreenActivity.class));
            else
                Toast.makeText(LoginActivity.this, "The username or password you entered is incorrect.",
                        Toast.LENGTH_LONG).show();
        }
    }
}
