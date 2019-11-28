package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String mensaje = intent.getStringExtra("EXTRA_INFO");

        TextView textview = (TextView)findViewById(R.id.textResultado2);
        textview.setText(mensaje);
    }
}
