package helper;

import java.io.File;

public class FileHelper {

    public static String getRootPath() {
        File   currDir = new File("");
        return currDir.getAbsolutePath();
    }
}
