package model.dto;

import java.sql.Date;
import java.util.Objects;

public class ProjectDto {
    Integer id;
    String projectName;
    String country;
    Integer cost;
    Date dateOfCreation;

    public ProjectDto(Integer id, String projectName, String country, Integer cost, Date dateOfCreation) {
        this.id = id;
        this.projectName = projectName;
        this.country = country;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDto(String projectName, String country, Integer cost, Date dateOfCreation) {
        this.projectName = projectName;
        this.country = country;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(projectName, that.projectName)
                && Objects.equals(country, that.country)
                && Objects.equals(cost, that.cost)
                && Objects.equals(dateOfCreation, that.dateOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, country, cost, dateOfCreation);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName = '" + projectName + '\'' +
                ", country = '" + country + '\'' +
                ", cost = " + cost +
                ", dateOfCreation = " + dateOfCreation +
                '}';
    }
}

