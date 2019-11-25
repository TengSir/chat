package edu.hbuas.chat.control;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    @Override
    public String toString() {
        return "User{" +
                "username=" + username.toString() +
                ", password=" + password.toString() +
                '}';
    }
    public User() {
        this.username=new SimpleStringProperty("");
        this.password=new SimpleStringProperty("");
    }

    public User(StringProperty username, StringProperty password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    private StringProperty  username;
    private StringProperty  password;
}
