package Helpers;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    public static String getPrivateProperty(String propertyName){
        FileInputStream fis;
        Properties property = new Properties();
        String propertyValue = null;

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            propertyValue = property.getProperty(propertyName);
        } catch (IOException e) {
            System.err.println("Errors");
        }

        return propertyValue;
    }

    public static String getCommonProperty(String propertyName){
        FileInputStream fis;
        Properties property = new Properties();
        String propertyValue = null;

        try {
            fis = new FileInputStream("src/main/resources/common.properties");
            property.load(fis);

            propertyValue = property.getProperty(propertyName);
        } catch (IOException e) {
            System.err.println("Errors");
        }

        return propertyValue;
    }
}
