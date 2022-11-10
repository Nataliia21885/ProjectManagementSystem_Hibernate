package model.dto;

import java.util.Objects;

public class CompanyDto {
    Integer id;
    String name;
    String hrm;

    public CompanyDto(Integer id, String name, String hrm) {
        this.id = id;
        this.name = name;
        this.hrm = hrm;
    }

    public CompanyDto(String name, String hrm) {
        this.name = name;
        this.hrm = hrm;
    }

    public CompanyDto() {
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

    public String getHrm() {
        return hrm;
    }

    public void setHrm(String hrm) {
        this.hrm = hrm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDto that = (CompanyDto) o;
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
