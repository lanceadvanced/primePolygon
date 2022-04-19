package Controller;

import Models.*;

public class SVGController {

    public static SVG generatePrimePolygonSVG(int corners, int width, String mode) {
        String baseFill = Colors.randomColor();
        String alteringFill = Colors.randomColor();
        SVG svg = new SVG(width);
        Rect background = new Rect(0, 0, svg.getWidth(), svg.getWidth(), baseFill);
        svg.addElement(background);

        String id = "polygon" + corners;
        Polygon basePolygon = new Polygon(corners, svg.getWidth(), id, mode);
        basePolygon.setPoints();

        Defs defs = new Defs();
        defs.addElement(basePolygon);
        svg.addElement(defs);

        double height = basePolygon.getDimensionValues().maxHeight;
        double radius = basePolygon.getDimensionValues().r;

        double offset = (width - height * corners / (corners + 1)) / 2 - (1 - (double) corners / (corners + 1)) * radius;
        for (int i = 0; i < corners; i++) {
            Use use = new Use(id);
            use.addAttribute("fill", i % 2 == 0 ? alteringFill : baseFill);
            double scale = ((double) corners - i) / ((double) corners + 1);
            double translateX = (((double) width / 2) - ((double) width / 2 * scale));
            double translateY = (1 - scale) * radius + offset;

            use.addAttribute("transform", "translate(" + translateX + ", " + translateY + ") scale(" + scale + ")");

            svg.addElement(use);
        }


        return svg;
    }

}
