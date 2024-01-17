package course_project.service.finding_number_in_string;

import course_project.packages.do_log.Logging;

import java.util.Date;

/**
 * Method for finding and returning a number from a string to double
 */

public class NumberSearch {

    public static double searchAmount (String line){

        StringBuilder number = new StringBuilder();
        boolean decimalPointFound = false;
        boolean commaFound = false;

        for (int i = 0; i < line.length(); i++){

            char c = line.charAt(i);

            if (Character.isDigit(c) || c == ',' || (c == '.' )) {

                if (c != ',' && c != '.') {

                    number.append(c);

                } else if (c == '.' && !decimalPointFound) {

                    number.append(c);
                    decimalPointFound = true;

                } else if (c == ',' && !commaFound) {

                    number.append(c);
                    commaFound = true;

                }

            } else {

                if (!number.isEmpty() && !decimalPointFound) {

                    String numStr = number.toString().replace(",", ".");
                    double num = Double.parseDouble(numStr);
                    Logging.EXECUTION_LOG(new Date(),"check amount\n");
                    return num;

                } else if (!number.isEmpty()){

                    String numStr = number.toString().replace(",", "");
                    double num = Double.parseDouble(numStr);
                    Logging.EXECUTION_LOG(new Date(),"check amount\n");
                    return num;

                }

            }

        }
        if (!number.isEmpty() && !decimalPointFound) {

            String numStr = number.toString().replace(",", ".");
            double num = Double.parseDouble(numStr);
            Logging.EXECUTION_LOG(new Date(),"check amount\n");
            return num;

        } else if (!number.isEmpty()){

            String numStr = number.toString().replace(",", "");
            double num = Double.parseDouble(numStr);
            Logging.EXECUTION_LOG(new Date(),"check amount\n");
            return num;

        }

        return 0;

    }

}
