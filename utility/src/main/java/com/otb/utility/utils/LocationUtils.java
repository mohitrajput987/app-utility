package com.otb.utility.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;

import com.otb.utility.R;

/**
 * Created by Mohit Rajput on 14/7/17.
 * This class provides location related utility methods. It's a singleton class.
 */

public class LocationUtils {
    private static LocationUtils locationUtils;
    private Context context;
    private LocationManager locationManager;

    private LocationUtils(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public static LocationUtils getInstance(Context context) {
        if (locationUtils == null) {
            locationUtils = new LocationUtils(context);
        }

        return locationUtils;
    }

    /**
     * It checks whether device's location is on or not.
     *
     * @param context
     * @return true if device location is enabled, false otherwise.
     */
    public boolean isLocationEnabled(Context context) {
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            try {
                buildAlertMessageNoGps(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Call it if {@link #isLocationEnabled(Context)} returns false. On clicking yes, it will open location settings to turn it on.
     *
     * @param context
     */
    private void buildAlertMessageNoGps(final Context context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getString(R.string.your_gps_seems_to_be_disabled))
                .setCancelable(false)
                .setPositiveButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        context.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * Method finds the most accurate location of device and return it. It compares GPS and Network provided locations to find most accurate between these twos.
     *
     * @return Current @{@link Location} object of user/device.
     */
    public Location getMyLocation() {
        Location location;
        Location gpsLocation, networkLocation;

        try {
            gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        } catch (SecurityException e) {
            e.printStackTrace();
            return new Location("location1");
        }

        if (gpsLocation == null && networkLocation == null) {
            location = null;
        } else if (gpsLocation != null && networkLocation != null) {
            if (gpsLocation.getAccuracy() > networkLocation.getAccuracy()) {
                location = networkLocation;
            } else {
                location = gpsLocation;
            }
        } else {
            if (gpsLocation == null) {
                return networkLocation;
            } else {
                return gpsLocation;
            }
        }
        if (location == null) {
            location = new Location("Location1");
        }
        return location;
    }
}
