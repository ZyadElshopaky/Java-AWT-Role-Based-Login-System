import java.util.ArrayList;

public class AuthService {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "1234", "Student"));
        users.add(new User("ali", "pass", "Professor"));
    }

    public static User login(String username, String password,String Role) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)&& u.getRole().equals(Role)) {
                return u; 
            }
        }
        return null; 
    }
}