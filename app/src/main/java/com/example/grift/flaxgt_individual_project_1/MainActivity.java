package com.example.grift.flaxgt_individual_project_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void move_to_next_screen(View view) {
        //moving to the start screen for registration/login choice
        startActivity(new Intent(MainActivity.this, StartScreenActivity.class));
    }
}
