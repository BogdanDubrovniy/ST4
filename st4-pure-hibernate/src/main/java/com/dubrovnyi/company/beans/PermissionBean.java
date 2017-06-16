package com.dubrovnyi.company.beans;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class PermissionBean {
    private String userRole;
    private boolean isBlocked;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PermissionBean that = (PermissionBean) o;

        return isBlocked == that.isBlocked && userRole.equals(that.userRole);
    }

    @Override
    public int hashCode() {
        int result = userRole.hashCode();
        result = 31 * result + (isBlocked ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PermissionBean{"
                + "userRole='" + userRole + '\''
                + ", isBlocked=" + isBlocked
                + '}';
    }
}
