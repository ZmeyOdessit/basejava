package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
        sizeStorage = 0;
    }

    public void update(Resume r) {
        if (get(r.getUuid()) != null) {
            System.out.println("OK.");
        } else {
            System.out.println("Resume " + r.getUuid() + "not exist.");
        }
    }

    public void save(Resume r) {
        if (get(r.getUuid()) == null) {
            storage[sizeStorage++] = r;
        } else {
            System.out.println("Resume is exist.");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (get(uuid) != null) {
            for (int i = 0; i < sizeStorage; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    System.arraycopy(storage, i + 1, storage, i, sizeStorage - i - 1);
                    sizeStorage--;
                }
            }
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
}
