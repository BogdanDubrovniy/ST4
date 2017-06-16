package com.dubrovnyi.company.entities.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Bohdan on 01.06.2017.
 */

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_cost", nullable = false)
    private int paymentRent;

    @Column(name = "id_status", nullable = false)
    private int statusId;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentRent() {
        return paymentRent;
    }

    public void setPaymentRent(int paymentRent) {
        this.paymentRent = paymentRent;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Payment payment = (Payment) o;
        if (paymentId != payment.paymentId && paymentRent != payment.paymentRent) {
            return false;
        }

        return statusId == payment.statusId && paymentDate.equals(payment.paymentDate);
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + paymentDate.hashCode();
        result = 31 * result + paymentRent;
        result = 31 * result + statusId;
        return result;
    }

    @Override
    public String toString() {
        return "Payment{"
                + "paymentId=" + paymentId
                + ", paymentDate=" + paymentDate
                + ", paymentRent=" + paymentRent
                + ", statusId=" + statusId
                + '}';
    }
}
