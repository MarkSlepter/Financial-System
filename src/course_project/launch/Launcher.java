package course_project.launch;

import course_project.packages.do_log.Logging;
import course_project.service.authorisation.Authorisation;
import course_project.service.session.Session;
import course_project.service.validation.ValidationFolderExistence;
import course_project.service.action_with_files.WriteFiles;

import java.util.Date;

/**
 *  Method for launching a program,
 *  authorization is carried out if it is successful,
 *  we receive a session,
 *  and perform the functionality.
 */

public class Launcher {

    public static void startProgram () {
        Logging.EXECUTION_LOG(new Date(), "Program launch\n");
        Session session = new Session();

        Session sessionOn = Authorisation.doLogin();
        if (sessionOn != null) {
            if (session.isSessionAlive()) {
                ValidationFolderExistence.checkPath();
                WriteFiles.writingFiles();
            } else {
                System.out.println("Session timed out");
                Logging.EXECUTION_LOG(new Date(), "Session timed out");
            }
        } else {
            Logging.EXECUTION_LOG(new Date(), "No session");
        }
        Logging.EXECUTION_LOG(new Date(), "Program end\n");
    }

}
