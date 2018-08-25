package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final String UUID_4 = "uuid4";


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume firstResume = new Resume(UUID_1);
        storage.update(firstResume);
        //assertFalse(firstResume != storage.get(UUID_1));
        assertTrue(firstResume == storage.get(UUID_1));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] arResume = storage.getAll();
        assertEquals(arResume.length, storage.size());
        assertEquals(arResume[0], storage.get(UUID_1));
        assertEquals(arResume[1], storage.get(UUID_2));
        assertEquals(arResume[2], storage.get(UUID_3));

    }

    @Test
    public void save() throws Exception {
        Resume resume = new Resume(UUID_4);
        storage.save(resume);
        assertEquals(4, storage.size());
        assertEquals(resume, storage.get(UUID_4));

    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test
    public void get() throws Exception {
        Resume resume1 = storage.get("uuid1");
        Resume resume2 = storage.get("uuid2");
        Resume resume3 = storage.get("uuid3");
        assertEquals(resume1, storage.get(UUID_1));
        assertEquals(resume2, storage.get(UUID_2));
        assertEquals(resume3, storage.get(UUID_3));

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

}