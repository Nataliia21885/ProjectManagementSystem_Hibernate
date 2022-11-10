package model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyDao {
    Integer id;
    String name;
    String hrm;
    Set<ProjectDao> projects;

    public CompanyDao(Integer id, String name, String hrm) {
        this.id = id;
        this.name = name;
        this.hrm = hrm;
    }

    public CompanyDao(String name, String hrm) {
        this.name = name;
        this.hrm = hrm;
    }

    public CompanyDao() {
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

    @Column(name = "hrm", length = 100)
    public String getHrm() {
        return hrm;
    }

    public void setHrm(String hrm) {
        this.hrm = hrm;
    }

    @ManyToMany(mappedBy = "companies")
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
        CompanyDao that = (CompanyDao) o;
        return Objects.equals(name, that.name) && Objects.equals(hrm, that.hrm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hrm);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name = '" + name + '\'' +
                ", hrm = '" + hrm + '\'' +
                '}';
    }
}
