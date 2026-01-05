package ru.netology.db;

/**
 * Класс для хранения настроек базы данных
 * Содержит имя и пароль для подключения к БД
 */
public class DbSetting {

    private String name;
    private String password;

    /**
     * Конструктор для создания настроек базы данных
     *
     * @param name имя пользователя для подключения к БД
     * @param password пароль для подключения к БД
     */
    public DbSetting(String name, String password) {
        this.name = name;
        this.password = password;
    }

}

