package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String login;
    private String pass;
    private String username;

    public Users() {}

    public Users(String login, String pass, String username) {
        this.login = login;
        this.pass = pass;
        this.username = username;
    }

    public int getId() { return id; }

    public String getLogin() { return login; }

    public String getPass() { return pass; }

    public String getUsername() { return username; }

    public void setLogin(String login) { this.login = login; }

    public void setPass(String pass) { this.pass = pass; }

    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(login, users.login) &&
                Objects.equals(pass, users.pass) &&
                Objects.equals(username, users.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, pass, username);
    }
}
