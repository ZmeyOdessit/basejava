package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;

public class SectionWithList extends Section {

    private final List<String> descrition;

    public SectionWithList(String... descritions) {
        this(Arrays.asList(descritions));
    }

    public SectionWithList(List<String> descrition) {
        this.descrition = descrition;
    }

    public List<String> getDescrition() {
        return descrition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionWithList that = (SectionWithList) o;

        return descrition != null ? descrition.equals(that.descrition) : that.descrition == null;
    }

    @Override
    public int hashCode() {
        return descrition != null ? descrition.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");
        for (String item : descrition) {
            output.append("\n");
            output.append(item);
        }
        return output.toString();
    }
}
