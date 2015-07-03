package com.example.urosivesko.textexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    EditText input;
    RadioGroup boja;
    TextView display;
    SeekBar velicina;
    Button generate;
    String  setBoja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicijalizacija();
    }
    private void inicijalizacija() {
        input = (EditText) findViewById(R.id.editText);
        boja = (RadioGroup) findViewById(R.id.radioGroup1);
        boja.setOnCheckedChangeListener(this);

        display = (TextView) findViewById(R.id.textView);
        velicina = (SeekBar) findViewById(R.id.seekBar);
        velicina.setOnSeekBarChangeListener(this);

        generate =(Button) findViewById(R.id.button);
        generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            Intent pozovi = new Intent(MainActivity.this, Rezultat.class);
            Bundle prenesi = new Bundle();

            String unos = input.getText().toString();//unijeti tekst uzme i pretvori u string
            prenesi.putString("unos",unos);

            prenesi.putString("boja",setBoja);

            prenesi.putString("size",display.getText().toString());

            pozovi.putExtras(prenesi);
            startActivity(pozovi);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioButtonZelena:
                setBoja = "zelena";
                break;
            case R.id.radioButtonCrvena:
                setBoja = "crvena";
                break;
            case R.id.radioButtonPlava:
                setBoja = "plava";
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        display.setText("Size: "+(progress + 14));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //display.setText(seekBar.getProgress());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //display.setText(seekBar.getProgress());
    }
}
