package com.example.alex.task_1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    String strToPrint;

    public void translate() {
        int x[] = new int [4];
        int div = 1000;
        int var = count;
        int rest;
        for (int i = 0; i<4; i++) {
            rest = (var/div);
            x[i] = rest;
            var = var - rest*div;
            div = div/10;
        }
        switch (x[0]) {
            case 1: strToPrint = "Тысяча "; break;
            default: break;
        }
        switch (x[1]) {
            case 1: strToPrint = strToPrint+"сто "; break;
            case 2: strToPrint = strToPrint+"двест "; break;
            case 3: strToPrint = strToPrint+"триста "; break;
            case 4: strToPrint = strToPrint+"четыреста ";break;
            case 5: strToPrint = strToPrint+"пятьсот "; break;
            case 6: strToPrint = strToPrint+"шестьсот "; break;
            case 7: strToPrint = strToPrint+"семьсот "; break;
            case 8: strToPrint = strToPrint+"восемьсот "; break;
            case 9: strToPrint = strToPrint+"девятьсот "; break;
        }
        switch (x[2]) {
            case 1:
                switch (x[3]) {
                    case 0: strToPrint = strToPrint+"десять "; break;
                    case 1: strToPrint = strToPrint+"одиннадцать "; break;
                    case 2: strToPrint = strToPrint+"двеннадцать "; break;
                    case 3: strToPrint = strToPrint+"тринадцать "; break;
                    case 4: strToPrint = strToPrint+"четырнадцать ";break;
                    case 5: strToPrint = strToPrint+"пятнадцать "; break;
                    case 6: strToPrint = strToPrint+"шестнадцать "; break;
                    case 7: strToPrint = strToPrint+"семнадцать "; break;
                    case 8: strToPrint = strToPrint+"восемнадцать "; break;
                    case 9: strToPrint = strToPrint+"девятнадцать "; break;
                }
                x[3] = 0;
                break;
            case 2: strToPrint = strToPrint+"двадцать "; break;
            case 3: strToPrint = strToPrint+"тридцать "; break;
            case 4: strToPrint = strToPrint+"сорок ";break;
            case 5: strToPrint = strToPrint+"пятьдесят "; break;
            case 6: strToPrint = strToPrint+"шестьдесят "; break;
            case 7: strToPrint = strToPrint+"семьдесят "; break;
            case 8: strToPrint = strToPrint+"восемьдесят "; break;
            case 9: strToPrint = strToPrint+"девяносто "; break;
            default: break;
        }
        switch (x[3]) {
            case 1: strToPrint = strToPrint+"один "; break;
            case 2: strToPrint = strToPrint+"два "; break;
            case 3: strToPrint = strToPrint+"три "; break;
            case 4: strToPrint = strToPrint+"четыре ";break;
            case 5: strToPrint = strToPrint+"пять "; break;
            case 6: strToPrint = strToPrint+"шесть "; break;
            case 7: strToPrint = strToPrint+"семь "; break;
            case 8: strToPrint = strToPrint+"восемь "; break;
            case 9: strToPrint = strToPrint+"девять "; break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNTER);
            counterActive = savedInstanceState.getBoolean(COUNTER_RUN);
            strToPrint = savedInstanceState.getString(SAVED_LABEL);
            txt.setText(strToPrint);
            if (counterActive == true) {
                activeState();
            } else {
                defaultState();
            }
        } else {
            count = 0;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counterActive == false) {
                    activeState();
                } else {
                    defaultState();
                }
            }
        });
    }

    public void defaultState() {
        btn.setText("Start");
        finalCountdown.cancel();
        counterActive = false;
        txt.setText(strToPrint);
    }
    public void activeState() {
        btn.setText("Stop");
        finalCountdown.start();
        counterActive = true;
    }

    static final String COUNTER = "counterState";
    static final String COUNTER_RUN = "counterRun";
    static final String SAVED_LABEL = "savedLabel";

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(COUNTER, count);
        savedInstanceState.putBoolean(COUNTER_RUN, counterActive);
        savedInstanceState.putString(SAVED_LABEL, strToPrint);
        super.onSaveInstanceState(savedInstanceState);
    }
    public int count;
    public boolean counterActive = false;
    public Button btn;
    public TextView txt;
    CountDownTimer finalCountdown = new CountDownTimer(1000000,1000) {
        @Override
        public void onTick(long l) {
            count++;
            translate();
            txt.setText(strToPrint);
            strToPrint = " ";
        }

        @Override
        public void onFinish() {
            defaultState();
        }
    };
}
