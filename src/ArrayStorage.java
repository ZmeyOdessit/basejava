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

    void update(Resume r) {
        if (get(r.uuid) != null) {
            System.out.println("OK.");
        } else {
            System.out.println("Resume " + r.uuid + "not exist.");
        }
    }

    void save(Resume r) {
        if (get(r.uuid) == null) {
            storage[sizeStorage++] = r;
        } else {
            System.out.println("Resume is exist.");
        }
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
        if (get(uuid) != null) {
            for (int i = 0; i < sizeStorage; i++) {
                if (storage[i].uuid.equals(uuid)) {
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
    Resume[] getAll() {
        Resume[] result = new Resume[sizeStorage];
        System.arraycopy(storage, 0, result, 0, sizeStorage);
        return result;
    }

    int size() {
        return sizeStorage;
    }
}
