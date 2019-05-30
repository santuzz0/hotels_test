package it.thinkopen.accessodb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalDBConf {

    public static final String SCHEMA_NAME = "hotels";
    public static final String HOTEL_TABLE_NAME = "\"hotel\"";
    public static final String CITY_TABLE_NAME = "\"city\"";

//    private FileInputStream fileInputStream;
//    private Properties properties;
//    private static String SCHEMA_NAME;
//    private static String HOTEL_TABLE_NAME;
//    private static String CITY_TABLE_NAME;
//    private static LocalDBConf instance;
//
//    private LocalDBConf() throws IOException {
//        fileInputStream = new FileInputStream("C:/Users/utente/IdeaProjects/hotels_test/src/main/resources/myProperties.properties");
//        properties = new Properties();
//        properties.load(fileInputStream);
//        SCHEMA_NAME = properties.getProperty("schemaName");
//        HOTEL_TABLE_NAME = properties.getProperty("hotelTableName");
//        CITY_TABLE_NAME = properties.getProperty("cityTableName");
//    }
//
//    public static LocalDBConf getInstance() throws IOException {
//        if (instance == null) {
//            instance = new LocalDBConf();
//        }
//        return instance;
//    }
//
//    public static String getSchemaName() {
//        return SCHEMA_NAME;
//    }
//
//    public static String getHotelTableName() {
//        return HOTEL_TABLE_NAME;
//    }
//
//    public static String getCityTableName() {
//        return CITY_TABLE_NAME;
//    }
}
