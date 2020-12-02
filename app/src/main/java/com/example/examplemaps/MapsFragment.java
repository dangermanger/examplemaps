package com.example.examplemaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsFragment extends Fragment {
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        @Override
        public void onMapReady(GoogleMap googleMap) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                googleMap.setMyLocationEnabled(true);
            } else {
            // Show rationale and request permission.
            }
            googleMap.setMyLocationEnabled(true);
            LatLng ufa = new LatLng(54.73470881278453, 55.95769702404469);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(ufa));
            googleMap.getMyLocation();
            googleMap.setMinZoomPreference(6.0f);
            googleMap.setMaxZoomPreference(14.0f);
            ArrayList<LatLng> coordinates   = new ArrayList<LatLng>();
            coordinates.add(new LatLng(54.72995287160151, 55.95189954910356));
            coordinates.add(new LatLng(54.729626668074495, 55.93186036370503));
            coordinates.add(new LatLng(54.72980190172553, 55.94412609064547));
            coordinates.add(new LatLng(54.730636730145356, 55.96708840388781));
            coordinates.add(new LatLng(54.747463963302124, 55.93585999132654));
            coordinates.add(new LatLng(54.64173737101645, 55.56135800167238));
            for(LatLng coordinate : coordinates){
                googleMap.addMarker(new MarkerOptions().position(coordinate).title("1"));
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}
