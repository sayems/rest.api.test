package org.sayem.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by syed.sayem on 6/21/15.
 */

public class PropertiesUtil {
    private String dataLocation;
    private Properties properties;

    private PropertiesUtil(String dataLocation) throws IOException {
        this.dataLocation = dataLocation;
        loadProperties();
    }

    public static PropertiesUtil create(String dataLocation) throws IOException {
        return new PropertiesUtil(dataLocation);
    }

    static <T> T valueOf(Class<T> klazz, String arg) {
        Exception cause = null;
        T ret = null;
        try {
            ret = klazz.cast(klazz.getDeclaredMethod("valueOf", String.class).invoke(null, arg)
            );
        } catch (NoSuchMethodException e) {
            cause = e;
        } catch (IllegalAccessException e) {
            cause = e;
        } catch (InvocationTargetException e) {
            cause = e;
        }
        if (cause == null) {
            return ret;
        } else {
            throw new IllegalArgumentException(cause);
        }
    }

    private void loadProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(dataLocation); //"src/test/resources/api.properties"
        properties = new Properties();
        properties.load(fileInputStream);
    }

    @SuppressWarnings("unchecked")
    public <T> T getProperties(String name) {
        T prop = null;
        try {

            String temp = properties.getProperty(name);
            prop = (T) temp;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public <T> T getProperties(String name, Class<T> type) {
        T prop = null;
        try {

            String temp = properties.getProperty(name);
            prop = valueOf(type, temp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String data(Repository value) {
        return getProperties(value.getValue());
    }
}
