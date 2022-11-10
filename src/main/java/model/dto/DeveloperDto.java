package model.dto;

import java.util.Objects;

public class DeveloperDto {
    Integer id;
    String name;
    Integer age;
    String sex;
    Integer salary;

    public DeveloperDto(Integer id, String name, Integer age, String sex, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public DeveloperDto(String name, Integer age, String sex, Integer salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public DeveloperDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperDto that = (DeveloperDto) o;
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
