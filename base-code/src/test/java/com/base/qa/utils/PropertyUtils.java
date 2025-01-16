package com.base.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    public static Properties loadProperty(String product) throws IOException {
        Properties properties = new Properties();
        InputStream stream = PropertyUtils.class.getClassLoader().getResourceAsStream(product + ".properties");
        properties.load(stream);
        return properties;
    }
}
