package records.userRecords;

public class UserInfo {
    private static UserInfo instance;
    private static String username;

    public UserInfo() {

    }

    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public static String getUsername() {
        return username;
    }

    public void setname(String username) {
        this.username = username;
    }
}

