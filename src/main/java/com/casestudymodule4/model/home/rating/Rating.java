package com.casestudymodule4.model.home.rating;

import com.casestudymodule4.model.user.User;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "rates")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RatingPoint point;

    private enum RatingPoint {
        VERYBAD(1), BAD(2), NORMAL(3), GOOD(4), VERYGOOD(5);
        private int point;

        RatingPoint(int point) {
            this.point = point;
        }

        public int getPoint() {
            return point;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RatingPoint getPoint() {
        return point;
    }

    public void setPoint(int point) {
        switch (point) {
            case 1:
                this.point = RatingPoint.VERYBAD;
                break;
            case 2:
                this.point = RatingPoint.BAD;
                break;
            case 3:
                this.point = RatingPoint.NORMAL;
                break;
            case 4:
                this.point = RatingPoint.GOOD;
                break;
            case 5:
                this.point = RatingPoint.VERYGOOD;
                break;

        }
    }
}
