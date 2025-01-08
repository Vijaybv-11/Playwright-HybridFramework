package ui.utils;

import ui.frameworkconstants.FilePaths;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {


    /**
     * Reads properties from a file and returns them as a Map.
     *
     * @param filePath the path to the properties file
     * @return a Map containing the properties
     */
    public static Map<String, String> loadPropertiesAsMaps(String filePath) {
        Properties properties = new Properties();
        Map<String, String> propertiesMap = new HashMap<>();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                propertiesMap.put(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertiesMap;

    }

    public static Map<String, String> getInsuranceProperties() {
        return loadPropertiesAsMaps(FilePaths.INSURANCE_PROPERTY);
    }


    /**
     * @param filePath Passing the File Name
     * @param key      The Key which you want to Update
     * @param newValue The Value which you want to update for the given key
     */

    public static void updatePropertyWithoutEscapeCharacters(String filePath, String key, String newValue) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Error reading the properties file: " + e.getMessage());
            return;
        }
        properties.setProperty(key, newValue);
        // Save without escaping
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            properties.forEach((k, v) -> writer.println(k + "=" + v));
        } catch (IOException e) {
            System.err.println("Error writing to the properties file: " + e.getMessage());
        }
    }


}
