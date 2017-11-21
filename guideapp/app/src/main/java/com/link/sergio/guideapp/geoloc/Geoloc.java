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
        this.latitude  = 0;
        this.longitude = 0;
        this.altitude  = 0;
        this.accuracy  = 0;
        this.status    = 0;
    }

    /**
     * Fonction getInstance
     *
     * @return L'instance du singleton.
     */
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

    /**
     * Fonction getLatitude
     *
     * @return La latitude à laquelle se trouve le téléphone.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Fonction getLongitude
     *
     * @return La longitude à laquelle se trouve le téléphone.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Fonction getAltitude
     *
     * @return L'altitude à laquelle se trouve le téléphone.
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Fonction getAccuracy
     * @return La précision de la mesure.
     */
    public float getAccuracy() {
        return accuracy;
    }

    /**
     * Fonction getStatus
     *
     * @return Le statut du provider.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Fonction getLonLat
     * Les valeurs numériques de longitude et de latitude peuvent être obtenues avec les fonctions getLatitude() et getLongitude().
     *
     * @return La longitude et la atitude sous forme de texte au format JSON.
     */
    public String getLonLat() {
        return "{lon:" + this.longitude + ",lat:" + this.latitude + "}";
    }
}
