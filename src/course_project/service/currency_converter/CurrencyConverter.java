package course_project.service.currency_converter;

import course_project.packages.do_log.Logging;

import java.util.Date;

/**
 * Currency Converter
 */

public class CurrencyConverter {

    public static double convertCurrency(String currency, double value){

        switch (currency){

            case "EURO": value *= 0.95;
                Logging.EXECUTION_LOG(new Date(),"Convert EURO to USD\n");
                break;
            case "GBR": value *= 1.26;
                Logging.EXECUTION_LOG(new Date(),"Convert GBR to USD\n");
                break;

        }

        return value;

    }

}
