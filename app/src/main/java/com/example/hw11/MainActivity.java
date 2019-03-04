package com.example.hw11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {

    EditText toConvert;
    TextView toConvertSlider;
    SeekBar timeBar;
    TextView convertedTime;
    TextView title;
    Button convertButton;
    double w700Time;
    double w1200Time;
    static final double conversionTo1200 = .6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toConvert = findViewById(R.id.toConvert);
        timeBar = findViewById(R.id.timeBar);
        title = findViewById(R.id.title);
        convertButton = findViewById(R.id.convertButton);
        convertedTime = findViewById(R.id.convertedTime);
        toConvertSlider = findViewById(R.id.toConvertSlider);

        toConvert.addTextChangedListener(textChangeLister);
        timeBar.setOnSeekBarChangeListener(timeBarListener);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        w1200Time = w700Time * conversionTo1200;
        convertedTime.setText(String.format("%.0f", w1200Time) + " seconds");
    }

    private TextWatcher textChangeLister = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence input, int i, int i1, int i2) {

            try {
                w700Time = Double.parseDouble(input.toString());
                toConvertSlider.setText(String.format("%.0f", w700Time) + " seconds");
            } catch (NumberFormatException e) {
                w700Time = 0;
                toConvert.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private OnSeekBarChangeListener timeBarListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar timeBar, int progress, boolean b) {
            w700Time = (double) progress;
            toConvertSlider.setText(String.valueOf(progress) + " seconds");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };


}
