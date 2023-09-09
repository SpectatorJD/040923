package com.example3.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "faculty")
    private Set<Student> students;
    public Faculty(){

    }

    public Faculty(Long id, String color, String name) {
        this.id = id;
        this.color = color;
        this.name = name;
    }


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(color, faculty.color) && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, name);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}