package model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "developers")
public class DeveloperDao {
    Integer id;
    String name;
    Integer age;
    String sex;
    Integer salary;
    Set<SkillDao> skills;
    Set<ProjectDao> projects;

    public DeveloperDao(Integer id, String name, Integer age, String sex, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public DeveloperDao(String name, Integer age, String sex, Integer salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public DeveloperDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "sex", length = 10)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @ManyToMany(mappedBy = "developers")
    public Set<SkillDao> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDao> skills) {
        this.skills = skills;
    }

    @ManyToMany(mappedBy = "developers")
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
        DeveloperDao that = (DeveloperDao) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(sex, that.sex) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, salary);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", sex = '" + sex + '\'' +
                ", salary = " + salary +
                '}';
    }
}
