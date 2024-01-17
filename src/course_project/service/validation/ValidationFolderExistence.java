package course_project.service.validation;

import course_project.packages.do_log.Logging;
import course_project.service.action_with_files.FileParsing;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

/**
 *   Method for getting folder path
 *   checking it for existence and transmitting it for reading
 */

public class ValidationFolderExistence {

    public static void checkPath() {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path to the folder");
            String pathFolderString;
            pathFolderString = scanner.nextLine();
            Path pathFolder = Paths.get(pathFolderString);
            Logging.EXECUTION_LOG(new Date(), "Getting folder path\n");

            if (Files.exists(pathFolder) && Files.isDirectory(pathFolder)){

                Logging.EXECUTION_LOG(new Date(), "Path received -> " + pathFolder + "\n");
                File folder = new File(pathFolderString);
                FileParsing.listFilesForFolder(folder);
                break;

            } else {

                System.out.println("invalid folder path\n");
                Logging.EXECUTION_LOG(new Date(), "Invalid folder path: " + pathFolder + "\n");

            }

        }

    }

}
