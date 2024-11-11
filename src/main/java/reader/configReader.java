package reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    public static Properties propertiesReader() throws IOException {
        FileInputStream file = null;
        Properties prop = null;
        try {
            file = new FileInputStream("src/main/resources/configurations.properties");
            prop = new Properties();
            prop.load(file);
        } catch (FileNotFoundException fnf) {
            System.out.println("---File Not Found---");
            fnf.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("---IOException---");
            ioe.printStackTrace();
        } finally {
            assert file != null;
            file.close();
        }
        return prop;
    }

}
