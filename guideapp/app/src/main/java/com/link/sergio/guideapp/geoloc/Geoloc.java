package com.link.sergio.guideapp.geoloc;

import android.location.*;
import android.os.Bundle;

/**
 * @author ARAUJO David
 *
 * Classe Geoloc permettant de récupérer les données de géolocalisation du téléphone utilisant l'application.
 */

public class Geoloc implements LocationListener {

    private Geoloc instance = null;
    private double latitude;
    private double longitude;
    private double altitude;
    private float  accuracy;
    private int    status;

    private Geoloc() {
    }

    public Geoloc getInstance() {
        if(this.instance == null) {
            this.instance = new Geoloc();
        }
        return this.instance;
    }

    @Override
    public void onLocationChanged(Location location) {
        this.latitude  = location.getLatitude();
        this.longitude = location.getLongitude();
        this.altitude  = location.getAltitude();
        this.accuracy  = location.getAccuracy();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        this.status = status;
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public int getStatus() {
        return status;
    }

    /**
     * Fonction getLonLat
     * Les valeurs numériques de longitude et de latitude peuvent être obtenues avec les fonctions getLatitude() et getLongitude().
     * @return La longitude et la atitude sous forme de texte au format JSON.
     */

    public String getLonLat() {
        return "{lon:" + this.longitude + ",lat:" + this.latitude + "}";
    }
}
