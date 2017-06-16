package com.dubrovnyi.company.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bohdan on 15.06.2017.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "users_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "users_name", length = 20, nullable = false)
    private String userName;

    @Column(name = "users_login", length = 17, nullable = false, unique = true)
    private String userLogin;

    @Column(name = "users_password", length = 17, nullable = false)
    private String userPassword;

    @Column(name = "users_block", length = 6, nullable = false)
    private String userBlockValue;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private UserRole userRole;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_card",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_card")}
    )
    private List<CreditCard> creditCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserBlockValue() {
        return userBlockValue;
    }

    public void setUserBlockValue(String userBlockValue) {
        this.userBlockValue = userBlockValue;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
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
        boolean isIdNameLoginAndPasswordAreEquals = (id == user.id)
                && userName.equals(user.userName)
                && userLogin.equals(user.userLogin)
                && userPassword.equals(user.userPassword);

        return isIdNameLoginAndPasswordAreEquals && userBlockValue
                .equals(user.userBlockValue)
                && userRole.equals(user.userRole)
                && creditCards.equals(user.creditCards);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userName.hashCode();
        result = 31 * result + userLogin.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + userBlockValue.hashCode();
        result = 31 * result + userRole.hashCode();
        result = 31 * result + creditCards.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", userName='" + userName + '\''
                + ", userLogin='" + userLogin + '\''
                + ", userPassword='" + userPassword + '\''
                + ", userBlockValue='" + userBlockValue + '\''
                + ", userRole=" + userRole
                + ", creditCards=" + creditCards
                + '}';
    }
}
