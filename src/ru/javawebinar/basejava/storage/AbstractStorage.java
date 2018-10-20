package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void makeUpdate(Resume r, Object pointer);

    protected abstract void makeSave(Resume r, Object pointer);

    protected abstract void makeDelete(Object pointer);

    protected abstract Resume makeGet(Object pointer);

    protected abstract boolean isExist(Object pointer);

    protected abstract Object getPointer(String uuid);

    public void update(Resume r) {
        Object pointer = getPointer(r.getUuid());
        if (!isExist(pointer)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            makeUpdate(r, pointer);
        }
    }

    public void save(Resume r) {
        Object pointer = getPointer(r.getUuid());
        if (isExist(pointer)) {
            throw new ExistStorageException(r.getUuid());
        } /*else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }*/ else {
            makeSave(r, pointer);
        }
    }

    public void delete(String uuid) {
        Object pointer = getPointer(uuid);
        if (!isExist(pointer)) {
            throw new NotExistStorageException(uuid);
        } else {
            makeDelete(pointer);
        }
    }

    public Resume get(String uuid) {
        Object pointer = getPointer(uuid);
        if (!isExist(pointer)) {
            throw new NotExistStorageException(uuid);
        }

        return makeGet(pointer);
    }
}
