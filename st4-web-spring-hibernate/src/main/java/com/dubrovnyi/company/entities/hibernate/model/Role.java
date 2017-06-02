package com.dubrovnyi.company.entities.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bohdan on 01.06.2017.
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column(name = "roles_id", nullable = false)
    private int roleId;

    @Column(name = "roles_name", nullable = false, unique = true, length = 10)
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Role role = (Role) o;
        return roleId == role.roleId && roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + roleName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{"
                + "roleId=" + roleId
                + ", roleName='" + roleName + '\''
                + '}';
    }
}
