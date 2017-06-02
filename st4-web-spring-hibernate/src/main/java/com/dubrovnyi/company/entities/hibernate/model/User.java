package com.dubrovnyi.company.entities.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bohdan on 01.06.2017.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "users_id", nullable = false)
    private int userId;

    @Column(name = "users_name", nullable = false, length = 20)
    private String userName;

    @Column(name = "users_login", nullable = false, unique = true, length = 17)
    private String userLogin;

    @Column(name = "users_password", nullable = false, length = 17)
    private String userPassword;

    @Column(name = "users_block", nullable = false, length = 6)
    private String userBlockingValue;

    @Column(name = "id_role", nullable = false)
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserBlockingValue() {
        return userBlockingValue;
    }

    public void setUserBlockingValue(String userBlockingValue) {
        this.userBlockingValue = userBlockingValue;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (userId != user.userId && roleId != user.roleId) {
            return false;
        }

        if (!userName.equals(user.userName) && !userLogin.equals(user.userLogin)) {
            return false;
        }

        return userPassword.equals(user.userPassword)
                && userBlockingValue.equals(user.userBlockingValue);

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + userName.hashCode();
        result = 31 * result + userLogin.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + userBlockingValue.hashCode();
        result = 31 * result + roleId;
        return result;
    }
}
