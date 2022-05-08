package br.com.finance.controlefinanceiro.util;

import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;

@Component
public class DataTimeFormatUtil {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
