package Models;

public class SVG extends Extensible {

    private final int width;
    private final int height;

    public SVG(){
        int defaultDimension = 1000;
        this.width = defaultDimension;
        this.height = defaultDimension;
    }

    public SVG(int dimension){
        this.width = dimension;
        this.height = dimension;
    }

    public int getWidth() {
        return this.width;
    }

    public String openingTag() {
        return String.format("<svg width='%s' height='%s' xmlns='http://www.w3.org/2000/svg'>", this.width, this.height);
    }


    public String closingTag(){
        return "</svg>";
    }
}
