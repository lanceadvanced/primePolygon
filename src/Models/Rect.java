package Models;

public class Rect extends Element {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final String fill;

    private String id = null;

    public Rect(int x, int y, int width, int height, String fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    public Rect(int x, int y, int width, int height, String fill, String id){
        this(x, y, width, height, fill);
        this.id = id;
    }

    public String toString() {
        return String.format(
                "<rect " + (this.id == null ? "id='" + this.id + "'" : "") + " x='%s' y='%s' width='%s' height='%s' fill='%s' />",
                x, y, width, height, fill
        );
    }
}
