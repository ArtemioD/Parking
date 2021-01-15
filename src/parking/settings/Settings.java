package parking.settings;

public final class Settings {
    private static String LANGUAGE = "es";

    public static String getLANGUAGE() {
        return LANGUAGE;
    }

    public static void setLANGUAGE(String LANGUAGE) {
        Settings.LANGUAGE = LANGUAGE;
    }

}
