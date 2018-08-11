package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void saveAdd(Resume r) {
        int newIndex = -getIndex(r.getUuid()) - 1;

        if (newIndex < size) {
            System.arraycopy(storage, newIndex, storage, newIndex + 1, size + 1);
            storage[newIndex] = r;
            size++;
        } else {
            storage[size] = r;
            size++;
        }

    }

    @Override
    protected void deleteAdd(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        size--;
    }
}
