package Testing;

import Controller.Colors;
import Controller.SaveSVG;
import Models.Defs;
import Models.Rect;
import Models.SVG;
import Models.Use;

import java.io.IOException;

public class MainTesting {

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 100; i++){
            System.out.println(Colors.randomColor());
        }
    }

}
