package course_project.service.validation;

import course_project.packages.do_log.Logging;
import course_project.service.action_with_files.ReadFiles;
import course_project.packages.util.Consts;
import course_project.packages.util.Variables;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

/**
 *    Method for checking the file format and filter for the year of the document,
 *    document type determination,
 *    receiving the amount and recording the amount.
 *    Moving invalid documents.
 */

public class ValidationNameFiles {

    public static void validatingNameDocuments (String nameFile, String path) {

        Logging.EXECUTION_LOG(new Date(),"Document verification -> " + nameFile + "\n");

        if (nameFile.endsWith(Consts.fileExtension) && nameFile.contains("2023")) {

            Logging.EXECUTION_LOG(new Date(),"The document has been verified -> " + nameFile + "\n");

            if(nameFile.toLowerCase().contains("order")){

                Variables.setSumOrder(Variables.getSumOrder() + ReadFiles.readingFiles(path));

            } else if (nameFile.toLowerCase().contains("invoice")){

                Variables.setSumInvoice(Variables.getSumInvoice() + ReadFiles.readingFiles(path));

            } else if (nameFile.toLowerCase().contains("bill")){

                Variables.setSumBill(Variables.getSumBill() + ReadFiles.readingFiles(path));

            } else { // Moving files with inappropriate names

                Logging.EXECUTION_LOG(new Date(),"Invalid file -> " + nameFile + "\n");
                File sourceFile = new File(path);
                File destinationFolder = new File(Consts.INVALID_FILE_NAME_PATH);

                try {

                    Path sourcePath = sourceFile.toPath();
                    Path destinationPath = new File(destinationFolder, sourceFile.getName()).toPath();
                    Files.move(sourcePath, destinationPath);

                } catch (IOException e) {

                    Logging.ERROR_LOG(new Date(),"Error moving file" + nameFile + "\n", e);
                    System.out.println("Error moving file, try again.");

                }

            }

        } else { //Moving files with incorrect extension

            Logging.EXECUTION_LOG(new Date(),"Invalid file -> " + nameFile + "\n");
            File sourceFile = new File(path);
            File destinationFolder = new File(Consts.INCORRECT_FILE_EXTENSION_PATH);

            try {

                Path sourcePath = sourceFile.toPath();
                Path destinationPath = new File(destinationFolder, sourceFile.getName()).toPath();
                Files.move(sourcePath, destinationPath);

            } catch (IOException e) {

                Logging.ERROR_LOG(new Date(),"Error moving file" + nameFile + "\n", e);
                System.out.println("Error moving file, try again.");

            }

        }

    }

}
