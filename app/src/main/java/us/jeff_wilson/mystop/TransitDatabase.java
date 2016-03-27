package us.jeff_wilson.mystop;

import android.location.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        MetroArea nyc = createMetroArea("New York City");
        TransitSystem metroNorth = nyc.createSystem("Metro North");
        TransitLine hudsonLine = metroNorth.createLine("Hudson");
        TransitLine harlemLine = metroNorth.createLine("Harlem");
        TransitLine newHavenLine = metroNorth.createLine("New Haven");

        Location pokLoc = new Location("test");
        TransitLineStop pokStop = hudsonLine.createStop("Poughkeepsie", pokLoc);

        TransitSystem LIRR = nyc.createSystem("Long Island Rail Road");

        TransitSystem NYCSubway = nyc.createSystem("Subway");

        MetroArea wash = createMetroArea("Washington");

    }
}
