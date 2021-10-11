package by.oz.utils;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class PropertyReader {
    private final Properties properties = new Properties();

    public PropertyReader(String filepath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String propertyName) {
        if (properties.getProperty(propertyName) != null) {
            return properties.getProperty(propertyName);
        } else {
            log.error("Cannot find properly by key: {}", propertyName);
            throw new RuntimeException();
        }
    }

    public String getProperty(String envVariable, String propertyName) {
        return System.getenv().getOrDefault(envVariable, getProperty(propertyName));
    }

    public void setProperty(String propertyName, String value) {
        properties.setProperty(propertyName, value);
    }
}