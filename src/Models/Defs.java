package Models;

import java.util.HashMap;
import java.util.Map;

public class Defs extends Extensible {

    @Override
    public String openingTag() {
        return "<defs>";
    }

    @Override
    public String closingTag() {
        return "</defs>";
    }

}
