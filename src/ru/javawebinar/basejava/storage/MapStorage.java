package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected void makeUpdate(Resume r, Object pointer) {
        mapResume.put((String) pointer, r);
    }

    @Override
    protected void makeSave(Resume r, Object pointer) {
        mapResume.put((String) pointer, r);
    }

    @Override
    protected void makeDelete(Object pointer) {
        mapResume.remove(pointer);
    }

    @Override
    protected Resume makeGet(Object pointer) {
        return mapResume.get(pointer);
    }

    @Override
    protected boolean isExist(Object pointer) {
        return mapResume.containsKey(pointer);
    }

    @Override
    protected String getPointer(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return mapResume.values().toArray(new Resume[mapResume.size()]);
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
