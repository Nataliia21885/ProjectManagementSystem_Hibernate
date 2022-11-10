package model.dto;

import java.util.Objects;

public class CustomerDto {
    Integer id;
    String name;
    String contact;

    public CustomerDto(Integer id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public CustomerDto(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public CustomerDto() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
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
