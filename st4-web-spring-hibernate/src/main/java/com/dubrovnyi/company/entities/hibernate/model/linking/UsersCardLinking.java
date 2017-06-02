package com.dubrovnyi.company.entities.hibernate.model.linking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bohdan on 01.06.2017.
 */
@Entity
@Table(name = "users_card")
public class UsersCardLinking implements Serializable {
    @Id
    @Column(name = "id_user", nullable = false)
    private int userId;

    @Id
    @Column(name = "id_card", nullable = false, unique = true)
    private int cardId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsersCardLinking that = (UsersCardLinking) o;
        return userId == that.userId && cardId == that.cardId;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + cardId;
        return result;
    }

    @Override
    public String toString() {
        return "UsersCardLinking{"
                + "userId=" + userId
                + ", cardId=" + cardId
                + '}';
    }
}
