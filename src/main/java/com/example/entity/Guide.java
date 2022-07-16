package com.example.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "staff_id")
    private String staffId;

    @ToString.Exclude
    @OneToMany(mappedBy = "guide", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Guide guide = (Guide) o;

        return new EqualsBuilder().append(id, guide.id).append(name, guide.name).append(salary, guide.salary).append(staffId, guide.staffId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(salary).append(staffId).toHashCode();
    }
}