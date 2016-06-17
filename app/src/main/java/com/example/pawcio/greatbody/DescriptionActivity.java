package com.example.pawcio.greatbody;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
    }

    //Powrót do Menu
    public void onOkClicked(View view) {
        finish();
        System.exit(0);
    }
}
