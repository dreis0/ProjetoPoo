package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

//    public static final SimpleDateFormat FORMATO_PADRAO = new SimpleDateFormat("dd/MM/yyyy");
	public static final DateTimeFormatter FORMATO_PADRAO = DateTimeFormatter.BASIC_ISO_DATE;

	public static LocalDate minDate() {
		return LocalDate.of(1900, 1, 1);
	}
}
