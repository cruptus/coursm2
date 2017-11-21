package com.link.sergio.guideapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RelativeLayout credits = (RelativeLayout) findViewById(R.id.relativeLayoutSettingsCredits);
        RelativeLayout contactSupport = (RelativeLayout) findViewById(R.id.relativeLayoutSettingsContactSupport);
        RelativeLayout flushCache = (RelativeLayout) findViewById(R.id.relativeLayoutSettingsCacheFlush);

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        contactSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        flushCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlert("Alerte", "Voulez-vous supprimer les caches ?");
            }
        });

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

    public void createAlert(String title, String message) {
        new AlertDialog.Builder(SettingsActivity.this)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override public void onClick(DialogInterface dialog, int which) {
                    deleteCache(getApplicationContext());
                }
            })
            .create()
            .show();
    }

    public void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {}
    }

    public boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }

            Toast.makeText(SettingsActivity.this, "Le cache a été supprimer !", Toast.LENGTH_SHORT).show();

            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}
