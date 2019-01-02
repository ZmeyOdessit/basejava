package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;

public class SectionCompany extends Section {
    private final List<Company> conpanies;

    public SectionCompany(Company... companies) {
        this(Arrays.asList(companies));
    }

    public SectionCompany(List<Company> conpanies) {
        this.conpanies = conpanies;
    }



    public List<Company> getConpanies() {
        return conpanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionCompany that = (SectionCompany) o;

        return conpanies != null ? conpanies.equals(that.conpanies) : that.conpanies == null;
    }

    @Override
    public int hashCode() {
        return conpanies != null ? conpanies.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SectionCompany{" +
                "conpanies=" + conpanies +
                '}';
    }
}
