package com.example.pawcio.greatbody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String x=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Lista Rozwijana
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    //Przejście do Głównego MENU
    public void menuBtnClicked(View view) {
        Intent intent = new Intent(this,MenuActivity.class);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        int x = (int)spinner.getSelectedItemId();
        intent.putExtra(MenuActivity.KEY_VALUE,x);
        startActivity(intent);
        finish();
    }



    // Ustawienie Górnego Tekstu pomocnieczego w zależności od Wybranego poziomu
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        TextView helpText = (TextView)findViewById(R.id.helptext);
        if(spinner.getSelectedItemId()==0)
            helpText.setText("Idealny tryb do nauki ćwiczeń, poznasz technikę ich wykonywania");
        else if(spinner.getSelectedItemId()==1)
                helpText.setText("Jeżeli poznałeś już technikę wykonywania ćwiczeń");
        else if(spinner.getSelectedItemId()==2)
            helpText.setText("Poziom podstawowy przestał cię męczyć");
        else if(spinner.getSelectedItemId()==3)
            helpText.setText("Jest dobrze, a może być jeszcze lepiej!");
        else if(spinner.getSelectedItemId()==4)
            helpText.setText("Zastanów się dwa razy zanim przejdziesz do tego poziomu");

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
