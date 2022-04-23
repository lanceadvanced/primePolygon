import Controller.SVGController;
import Controller.SaveSVG;
import Models.Polygon;
import Models.SVG;

import java.io.IOException;

public class Main {

    private static final int corners = 501;
    private static final int width = 1000;
    private static final String mode = Polygon.MODE_INVERSE;

    public static void main(String[] args) throws IOException {
        int corners = args.length == 1 ? Integer.parseInt(args[0]) : Main.corners;
        String mode = args.length == 2 ? (args[1].equals("--inverse") ? Polygon.MODE_INVERSE : Polygon.MODE_NORMAL) : Main.mode;
        int width = args.length == 3 ? Integer.parseInt(args[2]) : Main.width;
        SVG svg = SVGController.generatePrimePolygonSVG(corners, width, mode);
        if (args.length != 0) {
            System.out.println(svg);
        } else {
            String filename = corners + ".svg";
            SaveSVG.save(filename, svg);
        }
    }

}
