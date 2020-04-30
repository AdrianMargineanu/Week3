package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpinerActivity extends AppCompatActivity {
    private Spinner spinner;
    private List<String> desert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiner);
        spinner = findViewById(R.id.spinner);
        setSpinnerSource();
        spinner.setAdapter(getSpinnerAdapter());
    }

    private void setSpinnerSource(){
        desert = new LinkedList<>();
        desert.add("Cupcake");
        desert.add("Donut");
        desert.add("Eclair");
        desert.add("KitKat");
        desert.add("Pie");
    }

    private ArrayAdapter<String> getSpinnerAdapter(){
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,desert);
    }
}
