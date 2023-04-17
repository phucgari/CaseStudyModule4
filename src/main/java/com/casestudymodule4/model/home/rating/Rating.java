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
    @JoinColumn(name = "user_id")
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

    public void setPoint(RatingPoint point) {
        this.point = point;
    }
}
