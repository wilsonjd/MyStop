package us.jeff_wilson.mystop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jeff on 3/22/2016.
 */
public class MetroArea {
    String _name;
    Map<String, TransitSystem> _systems;

    MetroArea(String n) {
        _name = new String(n);
        _systems = new HashMap<>();
    }
    public String getName() { return _name;}

    TransitSystem findSystem(String n) {
        return _systems.get(n);
    }

    TransitSystem createSystem(String n) {
        TransitSystem s = new TransitSystem(n);
        _systems.put(n, s);
        return s;
    }

    Set<String> getSystemNames() {
        Set<String> names = _systems.keySet();
        return names;
    }
}
