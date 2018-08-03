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
        Arrays.fill(storage, null);
        sizeStorage = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
            System.out.println("OK.");
        } else {
            System.out.println("Resume " + r.toString() + " not exist.");
        }
    }

    public void save(Resume r) {
        if (size() <= 10000) {
            if (get(r.getUuid()) == null) {
                storage[sizeStorage++] = r;
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
        Resume[] result = new Resume[sizeStorage];
        System.arraycopy(storage, 0, result, 0, sizeStorage);
        return result;
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
