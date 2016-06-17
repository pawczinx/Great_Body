package com.example.pawcio.greatbody;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import layout.Fragment1;
import layout.Fragment2;
import layout.Fragment3;
import layout.Fragment4;
import layout.Fragment5;
import layout.Fragment6;
import layout.Fragment7;
import layout.Fragment8;
import layout.RestFragment;

public class StartAppActivity extends AppCompatActivity {

    private static int previousFragment=0;
    private static int autopreviousFragment = 0;
    public static final String KEY_VALUES = "KEY";
    private int idLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        //Pobranie poziomu ćwiczenia z MenuActivity
        Bundle b = getIntent().getExtras();
        idLevel = b.getInt(KEY_VALUES,40);

    }



    //Główny Timer
    @NonNull
    private CountDownTimer setCountDownTimer
            (final TextView textView, final int id, final Fragment fragme, long time1, final long time2) {
        return new CountDownTimer(time1,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    String v = String.format("%02d", millisUntilFinished / 60000);
                    int va = (int) ((millisUntilFinished % 60000) / 1000);
                    textView.setText("Zacznij Ćwiczyć za: " + v + ":" + String.format("%02d", va));
                }
                @Override
                public void onFinish() {
                    ImageView imageView = (ImageView) findViewById(id);
                    AnimationDrawable ani = (AnimationDrawable) imageView.getBackground();
                    ani.start();
                    Button buttonNext = (Button)findViewById(R.id.startAppButtonNext);
                    buttonNext.setBackgroundColor(Color.RED);
                    setCountDownTimer2(textView,fragme,time2);

                }

            }.start();
    }

    //Drugi Timer odpowiedzialny za czas wykonywania ćwiczenia
    @NonNull
    private CountDownTimer setCountDownTimer2
            (final TextView textView, final Fragment fragment, long time2) {
        return new CountDownTimer(time2,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                String v = String.format("%02d", millisUntilFinished / 60000);
                int va = (int) ((millisUntilFinished % 60000) / 1000);
                textView.setText("Ćwicz jeszcze : " + v + ":" + String.format("%02d", va));

            }
            @Override
            public void onFinish() {

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                Button buttonNext = (Button)findViewById(R.id.startAppButtonNext);
                buttonNext.setBackgroundColor(Color.GREEN);
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
                buttonNext.setEnabled(true);
                textView.setText("KONIEC!");
            }

        }.start();
    }

    //obsługa przycisku NEXT/START
    public void onNextClicked(View view) throws InterruptedException {
        ImageView imageView;
        AnimationDrawable ani;
        TextView countDown = (TextView)findViewById(R.id.countDownTimer) ;
        TextView textView = (TextView)findViewById(R.id.numberOfExcercise);
        Button buttonNext = (Button)findViewById(R.id.startAppButtonNext);
        if(previousFragment%2==0)buttonNext.setText("START");
        else if(previousFragment%2!=0)buttonNext.setText("DALEJ");
        if(idLevel==0) {
            //manualne przejście po wszystkich animacjach
            switch (previousFragment) {
                case 0:
                    textView.setText("Ćwicznenie 1");
                    getFragmentManager().beginTransaction().add(R.id.fragment_container, new Fragment1()).commit();
                    previousFragment++;
                    break;
                case 1:
                    imageView = (ImageView) findViewById(R.id.imageViev1);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.start();
                    previousFragment++;
                    break;
                case 2:
                    textView.setText("Ćwicznenie 2");

                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment2()).commit();
                    previousFragment++;
                    break;
                case 3:
                    imageView = (ImageView) findViewById(R.id.imageView2);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 4:
                    textView.setText("Ćwiczenie 3");
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment3()).commit();
                    previousFragment++;
                    break;

                case 5:
                    imageView = (ImageView) findViewById(R.id.imageView3);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 6:
                    textView.setText("Ćwiczenie 4");
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment4()).commit();
                    previousFragment++;
                    break;
                case 7:
                    imageView = (ImageView) findViewById(R.id.imageView4);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 8:
                    textView.setText("Ćwiczenie 5");
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment5()).commit();
                    previousFragment++;
                    break;
                case 9:
                    imageView = (ImageView) findViewById(R.id.imageView5);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 10:
                    textView.setText("Ćwiczenie 6");
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment6()).commit();
                    previousFragment++;
                    break;
                case 11:
                    imageView = (ImageView) findViewById(R.id.imageView6);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 12:
                    textView.setText("Ćwiczenie 7");
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment7()).commit();
                    previousFragment++;
                    break;
                case 13:
                    imageView = (ImageView) findViewById(R.id.imageView7);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 14:
                    textView.setText("Ćwiczenie 8");
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment8()).commit();
                    previousFragment++;
                    break;
                case 15:
                    imageView = (ImageView) findViewById(R.id.imageView8);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    ani.start();
                    previousFragment++;
                    break;
                case 16:
                    imageView = (ImageView) findViewById(R.id.imageView8);
                    ani = (AnimationDrawable) imageView.getBackground();
                    ani.stop();
                    previousFragment = 0;
                    finish();
                    Intent intent = new Intent(this, FinishActivity.class);
                    startActivity(intent);
                    break;
            }
        }

            //automatyczne przejścia gdy poziom ćwiczenia większy niż 0
            else if(idLevel>=1){
            long time1 = 5000;
            long time2 = 10000;
            long time3 = 5000;
            long time4 = 20000;
            long time5 = 5000;
            long time6 = 35000;
            long time7 = 3000;
            long time8 = 50000;


            switch(autopreviousFragment) {
                case 0:

                    getFragmentManager().beginTransaction().add(R.id.fragment_container, new Fragment1()).commit();
                    autopreviousFragment++;
                    break;
                case 1:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageViev1,new Fragment2(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageViev1,new Fragment2(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageViev1,new Fragment2(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageViev1,new Fragment2(),time7,time8);
                    autopreviousFragment++;
                    break;
                case 2:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageView2,new Fragment3(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView2,new Fragment3(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView2,new Fragment3(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView2,new Fragment3(),time7,time8);
                    autopreviousFragment++;
                    break;
                case 3:
                    setBTN(buttonNext);
                         if(idLevel==1)setCountDownTimer(countDown,R.id.imageView3,new Fragment4(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView3,new Fragment4(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView3,new Fragment4(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView3,new Fragment4(),time7,time8);
                    autopreviousFragment++;
                    break;
                case 4:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageView4,new Fragment5(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView4,new Fragment5(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView4,new Fragment5(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView4,new Fragment5(),time7,time8);
                    autopreviousFragment++;
                    break;

                case 5:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageView5,new Fragment6(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView5,new Fragment6(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView5,new Fragment6(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView5,new Fragment6(),time7,time8);
                    autopreviousFragment++;
                    break;

                case 6:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageView6,new Fragment7(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView6,new Fragment7(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView6,new Fragment7(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView6,new Fragment7(),time7,time8);
                    autopreviousFragment++;
                    break;

                case 7:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageView7,new Fragment8(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView7,new Fragment8(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView7,new Fragment8(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView7,new Fragment8(),time7,time8);
                    autopreviousFragment++;
                    break;
                case 8:
                    setBTN(buttonNext);
                    if(idLevel==1)setCountDownTimer(countDown,R.id.imageView8,new RestFragment(),time1,time2);
                    else if(idLevel==2)setCountDownTimer(countDown,R.id.imageView8,new RestFragment(),time3,time4);
                    else if(idLevel==3)setCountDownTimer(countDown,R.id.imageView8,new RestFragment(),time5,time6);
                    else if(idLevel==4)setCountDownTimer(countDown,R.id.imageView8,new RestFragment(),time7,time8);
                    autopreviousFragment++;
                    break;
                case 9:
                    autopreviousFragment = 0;
                    finish();
                    Intent intent = new Intent(this, FinishActivity.class);
                    startActivity(intent);
                    break;

            }

            }

    }


    //ustawienie niedostępności przycisku podczas gdy czas na wykonywanie ćwiczenia
    public void setBTN(Button button){
        button.setBackgroundColor(Color.RED);
        button.setEnabled(false);
    }


    @Override
    public void onPause(){
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    //powrót do Menu Głównego
    public void onMenuButtonClicked(View view) {
        previousFragment=0;
        autopreviousFragment=0;
        finish();
        System.exit(0);
    }


}
