package zarovizsgapotvizsga2021.message;

public class User {

    private long id;
    private String username;

    public User(String username) {
        this.username = username;
    }

    public User(long id, String username) {
        this(username);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
