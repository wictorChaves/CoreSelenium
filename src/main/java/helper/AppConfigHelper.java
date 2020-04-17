package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfigHelper {

    public static String GetProp(String propName) {
        try {
            Properties prop     = new Properties();
            String     fileName = FileHelper.getRootPath() + File.separator +"app.config ";
            prop.load(new FileInputStream(fileName));
            return prop.getProperty(propName);
        } catch (IOException ex) {
            return "";
        }
    }

}
