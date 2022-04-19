package Models;

import java.util.ArrayList;

public abstract class Extensible extends Element{

    private final ArrayList<Element> elements = new ArrayList<>();

    public String openingTag() {
        return "";
    }

    public String closingTag(){
        return "";
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public String toString() {
        StringBuilder string = new StringBuilder(openingTag());

        for(Element e : elements) {
            string.append(e.toString());
        }
        string.append(closingTag());

        return string.toString();
    }

}
