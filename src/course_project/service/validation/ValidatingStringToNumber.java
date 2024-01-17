package course_project.service.validation;

import course_project.packages.do_log.Logging;
import course_project.service.currency_converter.CurrencyConverter;
import course_project.service.finding_number_in_string.NumberSearch;

import java.util.Date;

/**
 *    Checking whether the line contains the amount and its currency,
 *    calling a method for getting a number from a string,
 *    call conversion,
 *    return value.
 */

public class ValidatingStringToNumber {

    public static double checkingLineForAmountAndCurrency (String line){

        if (line.toLowerCase().contains("total")){

            Logging.EXECUTION_LOG(new Date(),"Line with amount found\n");

            if (line.toUpperCase().contains("EURO")){

                Logging.EXECUTION_LOG(new Date(),"EURO currency\n");
                double euro = NumberSearch.searchAmount(line);
                return CurrencyConverter.convertCurrency("EURO", euro);

            } else if (line.toUpperCase().contains("GBR")) {

                Logging.EXECUTION_LOG(new Date(),"GBR currency\n");
                double gbr = NumberSearch.searchAmount(line);
                return CurrencyConverter.convertCurrency("GBR", gbr);

            } else {

                Logging.EXECUTION_LOG(new Date(),"USD currency\n");
                return NumberSearch.searchAmount(line);

            }

        }

        return 0;

    }

}
