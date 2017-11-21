package com.link.sergio.guideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = (ListView) findViewById(R.id.list_settings);

        String[] items = new String[]{
                "Général information",
                "Crédits",
                "Contact support"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_settings, items);
        listView.setAdapter(adapter);
        setContentView(R.layout.activity_settings);
    }
}
