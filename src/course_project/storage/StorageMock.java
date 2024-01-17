package course_project.storage;

public class StorageMock {

    private final String login = "bpwxo25108dXNlcg==bpwxo25108"; //encrypted with Base64 and salt. Original: user
    private final String password = "7fsf7l7oa5Y2hhbmdlbWUxMjM=7fsf7l7oa5"; //encrypted with Base64 and salt. Original: changeme123

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
