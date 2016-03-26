package us.jeff_wilson.mystop;

import android.location.Location;

import java.util.Map;

/**
 * Created by Jeff on 3/22/2016.
 */
public class TransitLine {
    String _name;
    Map<String, TransitLineStop> _stopMap;
    Map<Location, TransitLineStop> _locationStops;

    public String get_name() { return _name;}

}
