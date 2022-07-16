package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "enrollment_id")
    private String enrollmentId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "guide_id")
    @ToString.Exclude
    private Guide guide;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return new EqualsBuilder().append(id, student.id).append(enrollmentId, student.enrollmentId).append(name, student.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(enrollmentId).append(name).toHashCode();
    }
}
