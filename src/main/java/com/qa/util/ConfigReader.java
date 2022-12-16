package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     private Properties prop;

    // This method used to load the properties from config.properties file
    // @return it returns properties prop object
    public Properties init_prop()  {
        // create object of properties class
        prop =new Properties();

        // here i'm inttracting with config.properties i have to use FileInputStream class
      //  FileInputStream ip =new FileInputStream("src/test/java/config/config.properties");
        try {
            FileInputStream ip =new FileInputStream("src/test/java/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }



}
