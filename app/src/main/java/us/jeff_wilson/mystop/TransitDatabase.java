package us.jeff_wilson.mystop;

import java.util.Map;

/**
 * Created by Jeff on 3/22/2016.
 */
public class TransitDatabase {
    Map<String, MetroArea> _metroAreas;

    public MetroArea findMetroArea(String name) {
        return _metroAreas.get(name);
    }
}
