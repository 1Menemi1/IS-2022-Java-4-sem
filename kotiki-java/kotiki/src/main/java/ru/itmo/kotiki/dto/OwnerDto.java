package ru.itmo.kotiki.dto;

import java.sql.Date;

public class OwnerDto {
    private String name;
    private Date birthDate;

    public OwnerDto() {
    }

    public OwnerDto(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OwnerDto that = (OwnerDto) o;

        if (birthDate != that.birthDate) {
            return false;
        }

        return !(name != null ? !name.equals(that.name) : that.name != null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + birthDate.getDay();
        return result;
    }

    @Override
    public String toString() {
        return "OwnerBean{" +
                "name='" + name + '\'' +
                ", birth date=" + birthDate +
                '}';
    }
}
