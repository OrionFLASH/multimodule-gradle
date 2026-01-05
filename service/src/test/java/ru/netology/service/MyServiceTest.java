package ru.netology.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.netology.db.MyEntity;

import java.util.UUID;

/**
 * Тесты для класса MyService
 */
class MyServiceTest {

    private final MyService myService = new MyService();

    @Test
    void testGetName() {
        assertEquals("myService", myService.getName());
    }

    @Test
    void testGetMyEntity() {
        MyEntity entity = myService.getMyEntity();
        assertNotNull(entity);
        assertNotNull(entity.getId());
        assertEquals("first", entity.getName());
    }

    @Test
    void testSetMyEntity() {
        MyEntity newEntity = new MyEntity("test");
        MyEntity result = myService.setMyEntity(newEntity);
        
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("test", result.getName());
        
        // Проверяем, что сущность действительно сохранена
        MyEntity savedEntity = myService.getMyEntity();
        assertEquals("test", savedEntity.getName());
        assertEquals(result.getId(), savedEntity.getId());
    }

    @Test
    void testSetMyEntityGeneratesUUID() {
        MyEntity newEntity = new MyEntity("test");
        assertNull(newEntity.getId());
        
        MyEntity result = myService.setMyEntity(newEntity);
        assertNotNull(result.getId());
    }
}

