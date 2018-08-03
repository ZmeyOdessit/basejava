package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage,0, sizeStorage, null);
        sizeStorage = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("OK.");
        } else {
            System.out.println("Resume " + resume.toString() + " not exist.");
        }
    }

    public void save(Resume resume) {
        if (sizeStorage <= storage.length) {
            if (getIndex(resume.getUuid()) < 0) {
                storage[sizeStorage++] = resume;
            } else {
                System.out.println("Resume is exist.");
            }
        } else {
            System.out.println("Storage is full.");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, sizeStorage - index - 1);
            sizeStorage--;
        } else {
            System.out.println("Resume " + uuid + "not exist.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, sizeStorage);
    }

    public int size() {
        return sizeStorage;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
