package course_project.service.action_with_files;

import course_project.service.validation.ValidationNameFiles;

import java.io.File;

/**
 *   Method of iterating through folders to find files and transfer them further
 */

public class FileParsing {

    public static void listFilesForFolder(File folder) {

        for (File fileEntry : folder.listFiles()) {

            if (fileEntry.isDirectory()) {

                listFilesForFolder(fileEntry);

            } else {

                ValidationNameFiles.validatingNameDocuments(fileEntry.getName(), String.valueOf(fileEntry));

            }

        }

    }

}
