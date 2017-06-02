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
@Table(name = "statuses")
public class Status implements Serializable {
    @Id
    @Column(name = "statuses_id", nullable = false)
    private int statusId;

    @Column(name = "statuses_name", nullable = false, length = 10, unique = true)
    private String statusName;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Status status = (Status) o;
        return statusId == status.statusId
                && statusName.equals(status.statusName);
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + statusName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Status{"
                + "statusId=" + statusId
                + ", statusName='" + statusName + '\''
                + '}';
    }
}
