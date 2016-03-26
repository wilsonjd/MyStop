package us.jeff_wilson.mystop;

import java.util.Map;

/**
 * Created by Jeff on 3/22/2016.
 */
public class MetroArea {
    Map<String, TransitSystem> _systems;

    TransitSystem find_system(String n) {
        return _systems.get(n);
    }
}
