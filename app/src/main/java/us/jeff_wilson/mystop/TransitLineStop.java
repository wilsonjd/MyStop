package us.jeff_wilson.mystop;

import android.location.Location;

/**
 * Created by Jeff on 3/22/2016.
 */
public class TransitLineStop {
    String _name;
    Location _stopLocation;

    TransitLineStop(String n, Location l) {
        _name = n;
        _stopLocation = l;
    }

    public String getName() { return _name;}
    public Location getLocation() { return _stopLocation;}

}
