package Models;

public class Polygon extends Element {

    public static String MODE_NORMAL = "normal";
    public static String MODE_INVERSE = "inverse";

    private String points;
    private final int corners;
    private final int contextWidth;
    private final String mode;

    private final String id;

    private DimensionValues dimensionValues;

    public Polygon(int corners, int contextWidth, String id, String mode) {
        this.corners = corners;
        this.contextWidth = contextWidth;
        this.id = id;
        this.mode = mode.equals(MODE_INVERSE) ? MODE_INVERSE : MODE_NORMAL;
    }

    public void setDimensionValues() {
        DimensionValues dV = new DimensionValues();

        dV.w = contextWidth;
        dV.n = corners;
        dV.maxLength = dV.w;
        dV.nthAngle = 360 / dV.n;

        dV.maxAngle = Math.floor(dV.n / 2) * dV.nthAngle;
        dV.r = dV.maxLength / (2 * Math.sin(Math.toRadians(dV.maxAngle / 2)));
        dV.unitLength = 2 * dV.r * Math.sin(Math.toRadians(dV.nthAngle) / 2);
        dV.unitHeight = Math.sin(Math.toRadians(180 - dV.nthAngle) / 2) * dV.r;
        dV.maxHeight = dV.unitHeight + dV.r;

        dimensionValues = dV;
    }

    public void setPoints() {
        this.setDimensionValues();
        DimensionValues dV = dimensionValues;
        StringBuilder pString = new StringBuilder();
        StringBuilder mirrorPString = new StringBuilder();
        boolean inverse = mode.equals(MODE_INVERSE);

        double[][] mirrorPoints = new double[(int) dV.n / 2][2];

        for (int i = 0; i < Math.ceil(dV.n / 2); i++) {
            double deg = 90 - i * dV.nthAngle;
            double sin = Math.sin(Math.toRadians(deg)) * dV.r;
            double cos = Math.cos(Math.toRadians(deg)) * dV.r;

            double x = (dV.maxLength / 2) + cos;
            double y = (sin < 0 ? -sin + dV.r : dV.r - sin);
            pString.append(x).append(",").append(y).append(" ");

            if (y != 0) {
                double mirrorPX = (dV.maxLength / 2) - cos;
                if (inverse) {
                    pString.append(mirrorPX).append(",").append(y).append(" ");
                } else {
                    mirrorPoints[i - 1] = new double[]{mirrorPX, y};
                }
            }
        }

        if (!inverse) {
            int index = mirrorPoints.length;
            while (0 < index--) {
                mirrorPString.append(mirrorPoints[index][0]).append(",").append(mirrorPoints[index][1]).append(" ");
            }
        }

        pString.append(mirrorPString);

        points = pString.toString();
    }

    public DimensionValues getDimensionValues() {
        return dimensionValues;
    }

    public String toString() {
        return "<polygon id='" + id + "' points='" + points + "'/>";
    }
}
