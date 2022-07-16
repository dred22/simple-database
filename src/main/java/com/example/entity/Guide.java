package com.example.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@ToString
public class Guide {
    @Id
    @SequenceGenerator(name="generator", sequenceName="guide_id_seq")
    @GeneratedValue(strategy=SEQUENCE, generator="generator")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "staff_id")
    private String badge;

    @ToString.Exclude
    @OneToMany(mappedBy = "guide", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Guide guide = (Guide) o;

        return new EqualsBuilder().append(id, guide.id).append(name, guide.name).append(salary, guide.salary).append(badge, guide.badge).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(salary).append(badge).toHashCode();
    }
}
