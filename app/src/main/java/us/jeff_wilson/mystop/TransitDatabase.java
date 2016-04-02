package us.jeff_wilson.mystop;

import android.location.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Jeff on 3/22/2016.
 */
public class TransitDatabase {
    Map<String, MetroArea> _metroAreas;

    TransitLineStop[] hudsonLineStops;

    String[] hudsonLineStopNames = {
             "Poughkeepsie",
             "New Hamburgh",
             "Beacon",
             "Cold Spring",
             "Garrison",
             "Peekskill",
             "Cortlandt",
             "Croton-Harmon",
             "Ossining",
             "Tarrytown",
             "Yonkers",
             "Marble Hill",
             "Harlem-125th Street",
             "Grand Central Terminal",
    };
    double[] hudsonLineLatLng = {
            41.706641, -73.938001,
            41.586692, -73.947494,
            41.506443, -73.984787,
            41.415232, -73.958063,
            41.380994, -73.947398,
            41.284894, -73.931391,
            41.247025, -73.923111,
            41.189820, -73.882692,
            41.157602, -73.869118,
            41.075528, -73.865103,
            40.936769, -73.901762,
            40.874943, -73.91206,
            40.805082, -73.939018,
            40.752838, -73.977139,
    };

    /*
        StopInfo hudsonLineStops[] = {
                { "Poughkeepsie", 41.706641, -73.938001},
                { "New Hamburgh", 41.586692, -73.947494},
                { "Beacon", 41.506443, -73.984787},
                { "Cold Spring", 41.415232, -73.958063},
                { "Garrison", 41.380994, -73.947398},
                { "Peekskill", 41.284894, -73.931391},
                { "Cortlandt", 41.247025, -73.923111},
                { "Croton-Harmon", 41.189820, -73.882692},
                { "Ossining", 41.157602, -73.869118},
                { "Tarrytown", 41.075528, -73.865103},
                { "Yonkers", 40.936769, -73.901762},
                { "Marble Hill", 40.874943, -73.91206},
                { "Harlem-125th Street", 40.805082, -73.939018},
                { "Grand Central Terminal", 40.752838, -73.977139},
        };
        */


    TransitDatabase() { _metroAreas = new HashMap<>(); }

    public MetroArea findMetroArea(String name) {
        return _metroAreas.get(name);
    }

    public MetroArea createMetroArea(String n) {
        MetroArea m = new MetroArea(n);
        _metroAreas.put(n, m);
        return m;
    }

    public Set<String> getMetroAreaNames() {
        Set<String> names = _metroAreas.keySet();
        return names;
    }

    public void loadData() {

        // test data
        MetroArea boston = createMetroArea("Boston");

        MetroArea chicago = createMetroArea("Chicago");
        TransitSystem ctaL = chicago.createSystem("CTA L");
        TransitLine ctaLRed = ctaL.createLine("Red");
        TransitLine ctaLBlue = ctaL.createLine("Blue");
        TransitLine ctaLBrown = ctaL.createLine("Brown");
        TransitLine ctaLGreen = ctaL.createLine("Green");
        TransitLine ctaLOrange = ctaL.createLine("Orange");
        TransitLine ctaLPurple = ctaL.createLine("Purple");
        TransitLine ctaLPink = ctaL.createLine("Pink");
        TransitLine ctaLYellow = ctaL.createLine("Yellow");

        TransitSystem cteBus = chicago.createSystem("CTA Bus");
        TransitSystem chicagoMetra = chicago.createSystem("Metra");

        MetroArea nyc = createMetroArea("New York City");
        TransitSystem metroNorth = nyc.createSystem("Metro North");
        TransitLine hudsonLine = metroNorth.createLine("Hudson");
        TransitLine harlemLine = metroNorth.createLine("Harlem");
        TransitLine newHavenLine = metroNorth.createLine("New Haven");

        // LatLng myLoc = new LatLng();
        hudsonLineStops = new TransitLineStop[hudsonLineStopNames.length];
        for(int i = 0; i < hudsonLineStopNames.length; ++i) {
            Location testLoc = new Location("test");
            testLoc.setLatitude(hudsonLineLatLng[i*2]);  // myLoc.lattitude
            testLoc.setLongitude(hudsonLineLatLng[i*2 + 1]); // myLoc.longitude
            hudsonLineStops[i] = hudsonLine.createStop(hudsonLineStopNames[i], testLoc);
        }

        TransitSystem LIRR = nyc.createSystem("Long Island Rail Road");

        TransitSystem NYCSubway = nyc.createSystem("Subway");

        MetroArea wash = createMetroArea("Washington");

    }
}
