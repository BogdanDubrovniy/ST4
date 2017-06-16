package com.dubrovnyi.company.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Bohdan on 15.06.2017.
 */
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @Column(name = "payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_date", nullable = true)
    private Date paymentDate;

    @Column(name = "payment_cost", nullable = false)
    private int paymentAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status", nullable = false)
    private PaymentStatus paymentStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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

        return id == payment.id && paymentAmount == payment.paymentAmount
                && paymentDate.equals(payment.paymentDate)
                && paymentStatus.equals(payment.paymentStatus);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + paymentDate.hashCode();
        result = 31 * result + paymentAmount;
        result = 31 * result + paymentStatus.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Payment{"
                + "id=" + id
                + ", paymentDate=" + paymentDate
                + ", paymentAmount=" + paymentAmount
                + ", paymentStatus=" + paymentStatus
                + '}';
    }
}
