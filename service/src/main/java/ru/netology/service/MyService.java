package ru.netology.service;

import ru.netology.db.Db;
import ru.netology.db.DbSetting;
import ru.netology.db.MyEntity;

import java.util.UUID;

/**
 * Сервисный класс для работы с бизнес-логикой
 * Использует модуль db для работы с базой данных
 */
public class MyService {

    private DbSetting dbSetting = new DbSetting("name", "password");
    private String name = "myService";
    private Db db = new Db(dbSetting);

    /**
     * Получить имя сервиса
     *
     * @return имя сервиса
     */
    public String getName() {
        return name;
    }

    /**
     * Установить новую сущность в базу данных
     * Автоматически генерирует UUID для новой сущности
     *
     * @param myEntity новая сущность для сохранения
     * @return сохраненная сущность с установленным UUID
     */
    public MyEntity setMyEntity(MyEntity myEntity) {
        myEntity.setId(UUID.randomUUID());
        db.setMyEntity(myEntity);
        return myEntity;
    }

    /**
     * Получить текущую сущность из базы данных
     *
     * @return сущность из базы данных
     */
    public MyEntity getMyEntity() {
        return db.getMyEntity();
    }
}

