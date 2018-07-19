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
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int leng = sizeStorage;
        for (int i = 0; i < leng; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = null;
                System.arraycopy(storage, i + 1, storage, i, sizeStorage - i - 1);
                sizeStorage--;

            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] all = new Resume[size()];
        System.arraycopy(storage, 0, all, 0, size());
        return all;
    }

    int size() {
        return sizeStorage;
    }
}
