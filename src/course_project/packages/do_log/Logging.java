package course_project.packages.do_log;

import course_project.packages.util.Consts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 *   Logging Methods
 */

public class Logging {

    public static void EXECUTION_LOG(Date date, String infoMessage){

        try {

            String message = date +  " -> " + infoMessage;
            Files.write(Paths.get(Consts.EXECUTION_LOG_FILE), message.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {

            //do nothing;

        }

    }
    public static void ERROR_LOG(Date date, String errorMessage, Exception exception){

        try {

            StringBuilder sb = new StringBuilder();
            sb.append(date + " -> " + errorMessage + "\n");

            StackTraceElement[] traceElements = exception.getStackTrace();
            for(StackTraceElement element: traceElements){

                sb.append(element.toString());
                sb.append("\n");

            }

            Files.write(Paths.get(Consts.ERROR_LOG_FILE), sb.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

            //do nothing;

        }

    }

}
