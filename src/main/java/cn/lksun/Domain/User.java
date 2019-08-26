package cn.lksun.Domain;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String create_time;
    private String lastly_time;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLastly_time() {
        return lastly_time;
    }

    public void setLastly_time(String lastly_time) {
        this.lastly_time = lastly_time;
    }




}
