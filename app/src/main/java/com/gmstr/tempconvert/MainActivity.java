package com.gmstr.tempconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tempEdittext;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextViev;
    private DecimalFormat round = new DecimalFormat("0.0");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEdittext = findViewById(R.id.editText);
        celButton = findViewById(R.id.celButtodId);
        fButton = findViewById(R.id.fButonId);
        showTempTextViev = findViewById(R.id.showTemptexdId);


        // Set up button evetlisteners
        celButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call convert to celsius
                String editTextVal = tempEdittext.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter a value",Toast.LENGTH_LONG).show();
                } else{
                    double intEditText = Double.parseDouble(editTextVal);
                    double convertedToCel = convertToCelsius(intEditText);

                    String stirngResult = String.valueOf(round.format(convertedToCel));

                    showTempTextViev.setText(stirngResult + " C");

                }

            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextVal = tempEdittext.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter a value",Toast.LENGTH_LONG).show();
                }else{
                    double intEditText = Double.parseDouble(editTextVal);
                    double convertedToF = convertToFarenheit(intEditText);

                    String stirngResult = String.valueOf(round.format(convertedToF));


                    showTempTextViev.setText(stirngResult + " F");
                }


            }
        });


    }

    public double convertToCelsius(double farVal){
        double resultCel;
        resultCel = (farVal-32) *5/9;
        return resultCel;
    }

    public double convertToFarenheit(double celVal){
        return celVal * 9/5 + 32;
    }
}
