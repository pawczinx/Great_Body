package com.example.pawcio.greatbody;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_VALUE = "KeyValue";
    private static int idOfLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //pobranie wartości poziomu ćwiczenia do Menu Głównego z LoginActivity
        Bundle b = getIntent().getExtras();
        idOfLevel = b.getInt(KEY_VALUE,40);
        setLevelTextView();




    }

    //ustawienie Górnego Tekstu w Menu w zależności od tego jaki poziom został wybrany
    public void setLevelTextView(){
        TextView tex = (TextView)findViewById(R.id.actTrainingDay);
        if(idOfLevel==0)tex.setText("Ćwiczę pierwszy raz");
        else if(idOfLevel==1)tex.setText("Początkujący");
        else if(idOfLevel==2)tex.setText("Średnio-zaawansowany");
        else if(idOfLevel==3)tex.setText("Zaawansowany");
        else if(idOfLevel==4)tex.setText("Ekspert");
    }

    //Start Activity z ćwiczeniami
    public void onStartClicked(View view) {
        Intent intent = new Intent(this,StartAppActivity.class);
        intent.putExtra(StartAppActivity.KEY_VALUES, idOfLevel);
        startActivity(intent);
    }

    //Opis Ćwiczeń
    public void onDescribeBtnClicked(View view) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        startActivity(intent);
    }


    //Zwiększenie poziomu treningu
    public void onOptionsBtnClicked(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        if(idOfLevel<4){
        dialogBuilder.setMessage("Zmienić Poziom na wyższy o 1 stopień?\n");
        dialogBuilder.setPositiveButton("TAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(idOfLevel==0)idOfLevel=1;
                else if(idOfLevel==1)idOfLevel=2;
                else if(idOfLevel==2)idOfLevel=3;
                else if(idOfLevel==3)idOfLevel=4;
                setLevelTextView();
            }
        });
        dialogBuilder.setNegativeButton("NIE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });}
        else if(idOfLevel>=4){
            dialogBuilder.setMessage("To już najwyższy poziom!\n");
            dialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }
        dialogBuilder.create();
        dialogBuilder.show();
    }

    //O apkikacji
    public void onAboutClicked(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage("Great Body \n\nAutor: Paweł Czernicki \n\nRzeszów 2016");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogBuilder.create();
        dialogBuilder.show();
    }

    //Wyjście z Aplikacji
    public void onExitClicked(View view) {
        finish();
        System.exit(0);
    }
}
