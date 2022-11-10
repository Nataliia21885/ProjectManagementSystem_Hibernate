package model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")
public class CustomerDao {
    Integer id;
    String name;
    String contact;
    Set<ProjectDao> projects;

    public CustomerDao(Integer id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public CustomerDao(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public CustomerDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "contact", length = 50)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @ManyToMany(mappedBy = "customers")
    public Set<ProjectDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDao> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDao that = (CustomerDao) o;
        return Objects.equals(name, that.name) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contact);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name = '" + name + '\'' +
                ", contact = '" + contact + '\'' +
                '}';
    }
}
