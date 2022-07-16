package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@ToString
public class Student {
    @Id
    @SequenceGenerator(name="generator", sequenceName="student_id_seq")
    @GeneratedValue(strategy=SEQUENCE, generator="generator")
    private Integer id;

    @Column(name = "registration_number")
    private String registrationNumber;

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

        return new EqualsBuilder().append(id, student.id).append(registrationNumber, student.registrationNumber).append(name, student.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(registrationNumber).append(name).toHashCode();
    }
}
