/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    void clear() {
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
        sizeStorage = 0;
    }

    void save(Resume r) {
        storage[sizeStorage++] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, sizeStorage - i - 1);
                sizeStorage--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] all = new Resume[sizeStorage];
        System.arraycopy(storage, 0, all, 0, sizeStorage);
        return all;
    }

    int size() {
        return sizeStorage;
    }
}
