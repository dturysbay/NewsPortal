package news.portal.bitlab.kz.db;

public class User {
    Long id;
    String email;
    String password;
    String fullName;
    Integer role_id;
    public User(){}
    public User(String email, String password, String fullName, Integer role_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role_id = role_id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
