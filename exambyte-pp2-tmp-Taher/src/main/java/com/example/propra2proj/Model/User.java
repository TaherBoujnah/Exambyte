package com.example.propra2proj.Model;
import jakarta.persistence.*;

public abstract class User {
    @Id
    private long id ;
    private String name ;
    private String email ;
    private Role role ;

public User(int id, String name, String email, Role role) {

    this.id = id;
    this.name = name;
    this.email = email;
    this.role = role;
}
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public Role getRole() {
    return role;
}
public void setRole(Role role) {
    this.role = role;
}
public abstract String getDashboard () ;

}