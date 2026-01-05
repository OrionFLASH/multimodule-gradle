package ru.netology.api;

import ru.netology.service.MyService;
import ru.netology.db.MyEntity;

/**
 * Главный класс приложения
 * Демонстрирует работу многомодульного проекта
 */
public class Main {

    /**
     * Точка входа в приложение
     * Демонстрирует использование модулей db, service и api
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        MyService myService = new MyService();
        System.out.println(myService.getMyEntity());
        System.out.println(myService.setMyEntity(new MyEntity("second")));
        System.out.println(myService.getMyEntity());
    }
}

