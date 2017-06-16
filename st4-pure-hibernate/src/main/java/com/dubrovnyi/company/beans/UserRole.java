package com.dubrovnyi.company.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bohdan on 15.06.2017.
 */

@Entity
@Table(name = "roles")
public class UserRole implements Serializable {
    @Id
    @Column(name = "roles_id", nullable = false)
    private int id;

    @Column(name = "roles_name", length = 10, nullable = false, unique = true)
    private String userRole;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserRole userRole1 = (UserRole) o;
        return id == userRole1.id && userRole.equals(userRole1.userRole);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userRole.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{"
                + "id=" + id
                + ", userRole='" + userRole + '\''
                + '}';
    }
}
