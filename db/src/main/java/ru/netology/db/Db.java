package ru.netology.db;

import java.util.UUID;

/**
 * Класс для работы с базой данных
 * Управляет настройками подключения и сущностями
 */
public class Db {

    private DbSetting dbSetting;
    private MyEntity myEntity;

    /**
     * Конструктор для создания объекта базы данных
     *
     * @param dbSetting настройки подключения к базе данных
     */
    public Db(DbSetting dbSetting) {
        this.dbSetting = dbSetting;
        myEntity = new MyEntity("first");
        myEntity.setId(UUID.randomUUID());
    }

    /**
     * Получить настройки подключения к базе данных
     *
     * @return настройки подключения
     */
    public DbSetting getDbSetting() {
        return dbSetting;
    }

    /**
     * Получить текущую сущность из базы данных
     *
     * @return сущность из базы данных
     */
    public MyEntity getMyEntity() {
        return myEntity;
    }

    /**
     * Установить новую сущность в базу данных
     *
     * @param myEntity новая сущность для сохранения
     */
    public void setMyEntity(MyEntity myEntity) {
        this.myEntity = myEntity;
    }
}

