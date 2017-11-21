package com.link.sergio.guideapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng markers[]=new LatLng[3];
        markers[0]= new LatLng(42.3,9.15);
        markers[1] = new LatLng(42.696749, 9.451948);
        markers[2] = new LatLng(41.923488, 8.738971);
        double lat=0, l=0;
        for(int i=0;i < markers.length;i++) {
            lat=lat+markers[i].latitude;
            l=l+markers[i].longitude;
        }
        LatLng centermap= new LatLng(lat/markers.length,l/markers.length);
        mMap.addMarker(new MarkerOptions().position(markers[0]).title("Marker in Corte"));
        mMap.addMarker(new MarkerOptions().position(markers[1]).title("Marker in Bastia"));
        mMap.addMarker(new MarkerOptions().position(markers[2]).title("Marker in Ajaccio"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centermap,10));
    }
}
