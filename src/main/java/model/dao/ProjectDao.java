package model.dao;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projects")
public class ProjectDao {
    Integer id;
    String projectName;
    String country;
    Integer cost;
    Date dateOfCreation;
    Set<CompanyDao> companies;
    Set<CustomerDao> customers;
    Set<DeveloperDao> developers;

    public ProjectDao(Integer id, String projectName, String country, Integer cost, Date dateOfCreation) {
        this.id = id;
        this.projectName = projectName;
        this.country = country;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDao(String projectName, String country, Integer cost, Date dateOfCreation) {
        this.projectName = projectName;
        this.country = country;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public ProjectDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "project_name", length = 255)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "country", length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "cost", length = 100)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column(name = "date_of_creation")
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @ManyToMany
    @JoinTable(
            name = "projects_companies",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id")}
    )
    public Set<CompanyDao> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompanyDao> companies) {
        this.companies = companies;
    }

    @ManyToMany
    @JoinTable(
            name = "projects_customers",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    public Set<CustomerDao> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerDao> customers) {
        this.customers = customers;
    }

    @ManyToMany
    @JoinTable(
            name = "developers_projects",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "developer_id")}
    )
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDao that = (ProjectDao) o;
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

