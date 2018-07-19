/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        int i = 0;
        boolean flag = true;
        while (flag) {
            if (storage[i] == null) {
                storage[i] = r;
                flag = false;
            }
            i++;
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int leng = size();
        for (int i = 0; i < leng; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = null;
            }
        }
        for (int i = 0; i < leng; i++) {
            if (storage[i] == null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
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
        int leng = 0;
        while (storage[leng] != null) {
            leng++;
        }
        return leng;
    }
}
