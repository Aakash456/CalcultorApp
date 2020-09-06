package com.example.server;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.inputValue);
    }
    //  this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClick(View view){
        if (view.getId() == R.id.button1) {
            RadioButton celsiusButton = (RadioButton)
                    findViewById(R.id.radio0);
            RadioButton fahrenheitButton = (RadioButton)
                    findViewById(R.id.radio1);
            if (text.getText().length() == 0) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                return;
            }
            float inputValue = Float.parseFloat(text.getText().toString());
            if (celsiusButton.isChecked()) {
                text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                celsiusButton.setChecked(false);
                fahrenheitButton.setChecked(true);
            } else {
                text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit((inputValue))));
                celsiusButton.setChecked(true);
                fahrenheitButton.setChecked(false);
            }
        }
    }
}