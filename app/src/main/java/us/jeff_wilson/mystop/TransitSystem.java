package us.jeff_wilson.mystop;

import java.util.Map;

/**
 * Created by Jeff on 3/22/2016.
 */
public class TransitSystem {
    String _name;
    private Map<String, TransitLine> _lineMap;

    public String get_name() { return _name;}

    public TransitLine find_line(String n) {
        return _lineMap.get(n);
    }
}
