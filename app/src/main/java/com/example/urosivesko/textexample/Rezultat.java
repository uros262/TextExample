package com.example.urosivesko.textexample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class Rezultat extends Activity{

    TextView rezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezultat);
        rezultat = (TextView) findViewById(R.id.rezultat);

        Bundle donesi = getIntent().getExtras();

        String unos = donesi.getString("unos");
        rezultat.setText(unos);

        String boja = donesi.getString("boja");
        switch (boja) {
            case "zelena":
                rezultat.setTextColor(Color.GREEN);
                break;
            case "crvena":
                rezultat.setTextColor(Color.RED);
                break;
            case "plava":
                rezultat.setTextColor(Color.BLUE);
                break;
        }

        String size = donesi.getString("size");
        rezultat.setTextSize(TypedValue.COMPLEX_UNIT_DIP,Float.parseFloat(size.substring(6)));
    }
}
