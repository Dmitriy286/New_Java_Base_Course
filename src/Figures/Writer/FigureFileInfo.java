package Figures.Writer;

import org.codehaus.plexus.components.io.fileselectors.FileInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FigureFileInfo {
    File file = new File("Figure JSON file.json");

    public boolean isFileEmpty() {
        return file.length() == 0;
    }

}


