package com.link.sergio.guideapp;

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

        this.initEventCheckBox();

    }

    private void initEventCheckBox() {
        final CheckBox checkboxEnKm = ( CheckBox ) findViewById( R.id.checkboxEnKm );
        final CheckBox checkboxEnMile = ( CheckBox ) findViewById( R.id.checkboxEnMile );

        checkboxEnKm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    checkboxEnMile.setChecked(false);
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
                }

            }
        });

    }
}
