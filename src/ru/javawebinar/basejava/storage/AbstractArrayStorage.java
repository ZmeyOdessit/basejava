package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void makeUpdate(Resume r, Object pointer) {
        storage[(Integer) pointer] = r;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void makeSave(Resume r, Object pointer) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (Integer) pointer);
            size++;
        }
    }

    @Override
    protected void makeDelete(Object pointer) {
        fillDeletedElement((Integer) pointer);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume makeGet(Object pointer) {
        return storage[(Integer) pointer];
    }

    @Override
    protected boolean isExist(Object pointer) {
        return (Integer) pointer >= 0;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer getPointer(String uuid);
}
