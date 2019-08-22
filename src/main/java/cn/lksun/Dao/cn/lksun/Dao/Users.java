package cn.lksun.Dao.cn.lksun.Dao;

public class Users {
    private int id;
    private String username;
    private String password;
    private int create_time;
    private int lastlogin_time;

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

    public int getLastlogin_time() {
        return lastlogin_time;
    }

    public void setLastlogin_time(int lastlogin_time) {
        this.lastlogin_time = lastlogin_time;
    }
    
}
