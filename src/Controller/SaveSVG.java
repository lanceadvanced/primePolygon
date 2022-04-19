package Controller;

import Models.SVG;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class SaveSVG {

    private static String path = "/Users/francois/Desktop/primePolygon/";

    public static void save(String filename, SVG svg) throws IOException {
        filename = path + filename;
        File file = new File(filename);
        Files.deleteIfExists(file.toPath());
        if(file.createNewFile()){
            FileWriter fw = new FileWriter(file);
            fw.write(svg.toString());
            fw.close();
        }
    }

    public static void save(String path, String filename, SVG svg) throws IOException {
        SaveSVG.path = path;
        save(filename, svg);
    }

}
