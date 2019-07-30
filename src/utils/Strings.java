package utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public final class Strings {

    private Strings() {

    }

    public static final String DELIMITADOR = ";";
    public static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat FORMATO_DATA_GENERICO = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
}