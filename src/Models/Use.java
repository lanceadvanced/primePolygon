package Models;

import java.util.HashMap;
import java.util.Map;

public class Use extends Element {

    private final HashMap<String, String> attributes = new HashMap<>();

    private final String href;

    public Use(String href) {
        this.href = href;
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String toString() {
        StringBuilder attributeString = new StringBuilder();
        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            attributeString.append(attribute.getKey()).append("='").append(attribute.getValue()).append("' ");
        }

        return "<use href='#" + href + "' " + attributeString + "/>";
    }
}
