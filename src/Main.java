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
        boolean commandline = args.length != 0;

        int corners = commandline ? Integer.parseInt(args[0]) : Main.corners;
        int width = commandline ? Integer.parseInt(args[1]) : Main.width;
        String mode = commandline ? args.length == 3 ? (args[2].equals("--inverse") ? Polygon.MODE_INVERSE : Polygon.MODE_NORMAL) : Polygon.MODE_NORMAL : Main.mode;
        SVG svg = SVGController.generatePrimePolygonSVG(corners, width, mode);
        if (commandline) {
            System.out.println(svg);
        } else {
            String filename = corners + ".svg";
            SaveSVG.save(filename, svg);
        }
    }

}
