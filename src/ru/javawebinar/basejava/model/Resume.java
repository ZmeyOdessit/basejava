package ru.javawebinar.basejava.model;

import java.util.UUID;

/**
 * ru.javawebinar.basejava.model.Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;
    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        //TODO if uuid and fullName == null?
        if (fullName == null || uuid == null) {
            throw new NullPointerException("FullName and uuid mast be not null!!!");
        }
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) && fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + "Name is " + fullName;
    }

    @Override
    public int compareTo(Resume o) {
        int ctr = fullName.compareTo(o.fullName);
        if (ctr != 0) {
            return uuid.compareTo(o.uuid);
        }
        return ctr;
    }
}