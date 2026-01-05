package ru.netology.db;

import java.util.UUID;

/**
 * Класс сущности для работы с базой данных
 * Представляет объект с уникальным идентификатором и именем
 */
public class MyEntity {

    private UUID id;
    private String name;

    /**
     * Конструктор для создания сущности
     *
     * @param name имя сущности
     */
    public MyEntity(String name) {
        this.name = name;
    }

    /**
     * Получить уникальный идентификатор сущности
     *
     * @return UUID идентификатор
     */
    public UUID getId() {
        return id;
    }

    /**
     * Установить уникальный идентификатор сущности
     *
     * @param id UUID идентификатор
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Получить имя сущности
     *
     * @return имя сущности
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя сущности
     *
     * @param name имя сущности
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Преобразование объекта в строковое представление
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return new StringBuilder().append("MyEntity{").append("id=").append(id).append(", name='").append(name).append('\'').append('}').toString();
    }
}

