package bean;

import org.apache.ibatis.type.TypeHandler;

public class User {
    private Integer id;
    private String username;
    private Integer age;
    private String sex;
    private String address;
    private Dep dep;

    public User(Integer id, String username, Integer age, String sex, String address, Dep dep) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.dep = dep;
    }

    public User() {
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", dep=" + dep +
                '}';
    }
}
