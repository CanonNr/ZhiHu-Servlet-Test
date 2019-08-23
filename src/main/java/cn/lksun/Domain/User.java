package cn.lksun.Domain;

public class User {
    private int id;
    private String username;
    private String password;
    private int create_time;
    private int lastly_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getLastly_time() {
        return lastly_time;
    }

    public void setLastly_time(int lastly_time) {
        this.lastly_time = lastly_time;
    }

}
