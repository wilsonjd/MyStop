package us.jeff_wilson.mystop;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Jeff on 6/5/2016.
 */
public class MyStopBackgroundService extends IntentService {


    MyStopBackgroundService() {
        super("MyStopBackgroundService");
    }

    boolean isNear(Location l1, Location l2) {

        double warnDistance = 2000;

        boolean rc = false;

        double dist = l1.distanceTo(l2);

        if (dist < warnDistance) {
            rc = true;
        }
        return rc;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String stopName = intent.getStringExtra("stop_name");
        String lineName = intent.getStringExtra("line_name");
        String systemName = intent.getStringExtra("system_name");
        String metroName = intent.getStringExtra("metro_name");

        TransitDatabase db = MainActivity._theDatabase;
        MetroArea ma = db.findMetroArea(metroName);
        TransitSystem sys = ma.findSystem(systemName);
        TransitLine line = sys.findLine(lineName);
        TransitLineStop stop = line.findStop(stopName);
        Location stopLocation = stop._stopLocation;


        boolean done = false;

        while (!done) {
            // get current location
            GoogleApiClient locationClient = new GoogleApiClient.Builder(this).addApi(LocationServices.API).build();
            Location myLocation = LocationServices.FusedLocationApi.getLastLocation(
                    locationClient);
            //  compare to requested stop
            //  if "close" raise alarm

            if (isNear(myLocation, stopLocation)) {
                // raise alarm
                done = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }

        }




    }
}
