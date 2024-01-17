package course_project.service.action_with_files;

import course_project.packages.do_log.Logging;
import course_project.packages.util.Consts;
import course_project.packages.util.RemoveExtraZeros;
import course_project.packages.util.Variables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 *   Method for writing to the statistics file
 */

public class WriteFiles {

    public static void writingFiles (){

        try {

            String message = "- total turnover for the year: " + RemoveExtraZeros.TWO_CHARACTERS_AFTER_DOT(Variables.getSumOrder() + Variables.getSumBill() + Variables.getSumInvoice()) + "\n" +
                    "- total turnover for all invoices: "+ RemoveExtraZeros.TWO_CHARACTERS_AFTER_DOT(Variables.getSumInvoice()) + "\n" +
                    "- total turnover for all orders: " + RemoveExtraZeros.TWO_CHARACTERS_AFTER_DOT(Variables.getSumOrder()) + "\n" +
                    "- total turnover for all checks: " + RemoveExtraZeros.TWO_CHARACTERS_AFTER_DOT(Variables.getSumBill());

            Files.write(Paths.get(Consts.STATISTIC_WRIT_PATH), message.getBytes(), StandardOpenOption.WRITE);
            Logging.EXECUTION_LOG(new Date(),"statistics.txt are written to a file along the path ->\n" + Consts.STATISTIC_WRIT_PATH + "\n");

        } catch (IOException e) {

            Logging.ERROR_LOG(new Date(), e.getMessage(), e);
            System.out.println("An error occurred while writing to the file, check if the file exists and try again.");

        }

    }

}
