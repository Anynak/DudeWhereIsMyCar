package com.innowise.dude_where_is_my_car.models;

import com.querydsl.core.annotations.QueryInit;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "announcement", schema = "dude_where_is_my_car")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id", nullable = false)
    private Long announcementId;

    @QueryInit("*.*")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "comment")
    private String comment;

    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("false")
    private Boolean isDeleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Announcement that = (Announcement) o;
        return announcementId != null && Objects.equals(announcementId, that.announcementId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
