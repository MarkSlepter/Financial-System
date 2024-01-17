package course_project.service.action_with_files;

import course_project.packages.do_log.Logging;
import course_project.service.validation.ValidatingStringToNumber;

import java.io.*;
import java.util.Date;

/**
 *   Method reads lines in a file
 *   and sends them for verification,
 *   will return a number
 */

public class ReadFiles {

    public static double readingFiles(String path){

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){

            double sum = 0;
            String line = reader.readLine();
            Logging.EXECUTION_LOG(new Date(),"Start reading file -> " + path + "\n");

            while (line != null) {

                sum = ValidatingStringToNumber.checkingLineForAmountAndCurrency(line);
                line = reader.readLine();

            }

            Logging.EXECUTION_LOG(new Date(), "End of file reading\n");
            return sum;

        } catch (FileNotFoundException e) {

            Logging.ERROR_LOG(new Date(), e.getMessage(), e);
            System.out.println("An error occurred reading the file, check if the file exists and try again.");

        } catch (IOException e) {

            Logging.ERROR_LOG(new Date(), e.getMessage(), e);
            System.out.println("An error occurred while writing to the file, check if the file exists and try again.");

        }

        return 0;

    }

}
