package by.a1qa.task3_1.util;

public class ConfigManager {

    private static final String CONFIG_FILE_PATH = "src/test/resources/config.json";

    public static String getBrowserName(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "browserName");
    }

    public static String getURL(){
        return JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "url");
    }

    public static int getWaitDurationInSeconds(){
        return Integer.parseInt(JSONCustomParser.parseElementByName(CONFIG_FILE_PATH, "waitDuration"));
    }
}
