package by.itclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//ORM Hibernate
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    //private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
