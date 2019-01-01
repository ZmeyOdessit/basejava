package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Company {
    private final String name;
    private final String url;
    private final LocalDate start;
    private final LocalDate end;
    private final String description;

    public Company(String name, String url, LocalDate start, LocalDate end, String description) {
        this.name = name;
        this.url = url;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (url != null ? !url.equals(company.url) : company.url != null) return false;
        if (start != null ? !start.equals(company.start) : company.start != null) return false;
        if (end != null ? !end.equals(company.end) : company.end != null) return false;
        return description != null ? description.equals(company.description) : company.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}
