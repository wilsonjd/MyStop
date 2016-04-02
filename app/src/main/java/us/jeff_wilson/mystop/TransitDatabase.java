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

        Location testLoc = new Location("test");
        testLoc.setLatitude(41.706641);  // myLoc.lattitude
        testLoc.setLongitude(-73.938001); // myLoc.longitude

        TransitLineStop pokStop = hudsonLine.createStop("Poughkeepsie", testLoc);

        testLoc = new Location("test");
        testLoc.setLatitude(41.586692);
        testLoc.setLongitude(-73.947494);
        TransitLineStop newHambStop = hudsonLine.createStop("New Hamburgh", testLoc);
        TransitLineStop beaconStop = hudsonLine.createStop("Beacon", testLoc);

        TransitSystem LIRR = nyc.createSystem("Long Island Rail Road");

        TransitSystem NYCSubway = nyc.createSystem("Subway");

        MetroArea wash = createMetroArea("Washington");

    }
}
