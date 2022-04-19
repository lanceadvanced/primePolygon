package Controller;

public class Colors {

    public static final String RED = "red";
    public static final String BLACK = "black";

    public static String randomColor(){
        String r = String.format("%02X", Math.round(Math.random() * 255));
        String g = String.format("%02X", Math.round(Math.random() * 255));
        String b = String.format("%02X", Math.round(Math.random() * 255));

        return "#" + r + g + b;
    }

}
