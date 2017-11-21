package com.link.sergio.guideapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        SharedPreferences sharedPref = this.getSharedPreferences("setting",Context.MODE_PRIVATE);
        String unite = sharedPref.getString("unite", null);
        if (unite != null) {
            if (unite.equals("mi")) {
                CheckBox checkboxEnMile = ( CheckBox ) findViewById( R.id.checkboxEnMile );
                checkboxEnMile.setChecked(true);
            } else {
                CheckBox checkboxEnKm = ( CheckBox ) findViewById( R.id.checkboxEnKm );
                checkboxEnKm.setChecked(true);
            }
        } else {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("unite", "km");
            editor.apply();
            CheckBox checkboxEnKm = ( CheckBox ) findViewById( R.id.checkboxEnKm );
            checkboxEnKm.setChecked(true);
        }


        this.initEventCheckBox();

    }

    private void initEventCheckBox() {
        final CheckBox checkboxEnKm = ( CheckBox ) findViewById( R.id.checkboxEnKm );
        final CheckBox checkboxEnMile = ( CheckBox ) findViewById( R.id.checkboxEnMile );

        SharedPreferences sharedPref = this.getSharedPreferences("setting",Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        checkboxEnKm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    checkboxEnMile.setChecked(false);
                    editor.putString("unite", "km");
                    editor.apply();
                }

            }
        });

        checkboxEnMile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    checkboxEnKm.setChecked(false);
                    editor.putString("unite", "mi");
                    editor.apply();
                }

            }
        });

    }
}
