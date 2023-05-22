package com.example.testar;

import android.location.Location;

import androidx.annotation.NonNull;

public class CLocation extends Location{
    private boolean bUseMetricUnits = false;

    public CLocation(Location location)
    {
        this(location, true);
    }
    public CLocation(Location location, boolean bUseMetricUnits)
    {
        super(location);
        this.bUseMetricUnits = bUseMetricUnits;
    }

    public boolean getUseMetricUnits()
    {
        return this.bUseMetricUnits;
    }
    public void setUseMetricUnits(boolean bUseMetricUnits)
    {
        this.bUseMetricUnits = bUseMetricUnits;
    }

    @Override
    public float distanceTo(Location dest) {
        float nDistance = super.distanceTo(dest);

        if(!this.getUseMetricUnits())
        {
            // Konverterar meter till feet
            nDistance = nDistance * 3.28083989501312f;


        }
        return nDistance;
    }

    @Override
    public float getAccuracy() {
        double nAccuracy = super.getAccuracy();

        if(!this.getUseMetricUnits())
        {
            // Konverterar meter till feet
            nAccuracy = nAccuracy * 3.28083989501312d;


        }
        return (float) nAccuracy;
    }

    @Override
    public double getAltitude() {
        double nAltitude = super.getAltitude();

        if(!this.getUseMetricUnits())
        {
            // Konverterar meter till feet
            nAltitude = nAltitude * 3.28083989501312d;


        }
        return nAltitude;
    }

    @Override
    public float getSpeed() {
        float nSpeed = super.getSpeed() * 3.6f;

        if(!this.getUseMetricUnits())
        {
            // Konverterar meter/sek till mph
            nSpeed = nSpeed * 2.2369629f;


        }
        return nSpeed;
    }
}
