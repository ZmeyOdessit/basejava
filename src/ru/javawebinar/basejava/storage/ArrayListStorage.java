package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStorage extends AbstractStorage {
    private List<Resume> arrayListStorage = new ArrayList();

    @Override
    protected void makeUpdate(Resume r, Object pointer) {
        arrayListStorage.set((Integer) pointer, r);
    }

    @Override
    protected void makeSave(Resume r, Object pointer) {
        //arrayListStorage.set((Integer) pointer, r);
        arrayListStorage.add(r);
    }

    @Override
    protected void makeDelete(Object pointer) {
        int index = (Integer) pointer;
        arrayListStorage.remove(index);
    }

    @Override
    protected Resume makeGet(Object pointer) {
        return arrayListStorage.get((Integer) pointer);
    }

    @Override
    protected boolean isExist(Object pointer) {
        return pointer != null;
    }

    @Override
    protected Integer getPointer(String uuid) {
        for (int i = 0; i < arrayListStorage.size(); i++) {
            if (arrayListStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        arrayListStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return arrayListStorage.toArray(new Resume[arrayListStorage.size()]);
    }

    @Override
    public int size() {
        return arrayListStorage.size();
    }
}
