package com.link.sergio.guideapp.geoloc;

import android.content.Context;
import android.location.*;
import android.os.Bundle;

/**
 * @author ARAUJO David
 *
 * Classe Geoloc permettant de r&eacute;cup&eacute;rer les donn&eacute;es de g&eacute;olocalisation du t&eacute;l&eacute;phone utilisant l'application.
 */

public class Geoloc implements LocationListener {

    private LocationManager lm = null;
    private Geoloc instance = null;
    private double latitude;
    private double longitude;
    private double altitude;
    private float  accuracy;
    private int    status;

    //////////////////////////
    //
    //  Constructeur
    //

    private Geoloc() {
        this.latitude  = 0;
        this.longitude = 0;
        this.altitude  = 0;
        this.accuracy  = 0;
        this.status    = 0;
    }

    //
    //
    //
    //////////////////////////

    //////////////////////////
    //
    //  M&eacute;thodes de l'interface
    //

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

    //
    //
    //
    //////////////////////////

    //////////////////////////
    //
    //  Getters
    //

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

    /**
     * Fonction getLatitude
     *
     * @return La latitude &agrave; laquelle se trouve le t&eacute;l&eacute;phone.
     *
     * @see getLonLat()
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Fonction getLongitude
     *
     * @return La longitude &agrave; laquelle se trouve le t&eacute;l&eacute;phone.
     *
     * @see getLonLat()
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Fonction getAltitude
     *
     * @return L'altitude &agrave; laquelle se trouve le t&eacute;l&eacute;phone.
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Fonction getAccuracy
     *
     * @return La pr&eacute;cision de la mesure.
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
     * Les valeurs num&eacute;riques de longitude et de latitude peuvent &ecirc;tre obtenues avec les fonctions getLatitude() et getLongitude().
     *
     * @return La longitude et l'altitude sous forme de texte au format JSON.
     *
     * @see getLongitude()
     * @see getLatitude()
     */
    public String getLonLat() {
        return "{lon:" + this.longitude + ",lat:" + this.latitude + "}";
    }

    //
    //
    //
    //////////////////////////

    /**
     * Fonction startLocationManager
     *
     * D&eacute;marre la mise &agrave; jour du LocationManager.
     *
     * @param context Le context de l'application.
     * @throws SecurityException
     */
    void startLocationManager(Context context) throws SecurityException {
        lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        try {
            if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
            }
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, this);
        }
        catch(SecurityException e) {
            throw e;
        }
    }
}
