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
@Table(name = "statuses")
public class PaymentStatus implements Serializable {
    @Id
    @Column(name = "statuses_id", nullable = false)
    private int id;

    @Column(name = "statuses_name", length = 10, nullable = false, unique = true)
    private String statusName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        PaymentStatus that = (PaymentStatus) o;

        return id == that.id && statusName.equals(that.statusName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + statusName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PaymentStatus{"
                + "id=" + id
                + ", statusName='" + statusName + '\''
                + '}';
    }
}
