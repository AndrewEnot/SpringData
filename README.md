# Spring_Data
ДЗ 25. Spring Data

1.0 Реализовать класс Order. Данный класс будет хранить значения: id, date, cost, products

1.1 Описать данную сущность при помощи JPA-аннотаций.

2.0 Реализовать класс Product. Данный класс будет хранить значения: id, name, cost

2.1 Описать данную сущность при помощи JPA-аннотаций.

3.0 Создать ProductRepository для взаимодействия с сущностью Product

4.0 Заказы будут храниться в специализированном классе-репозиторие OrderRepository

5.0 Сконфигурировать Spring-приложение через application.yml

6.1 Приложение должно быть доступно по URL: http://localhost:8080

6.2 Настроить подключение в БД

6.3 Настроить логирование на уровне INFO для пакетов приложения и для пакета org.springframework.web

Процесс логирования включает вывод в консоль и запись в файл

7.0 Реализовать OrderService который будет взаимодействовать с OrderRepository и реализовывать 
8.0 операции: получение по id, получение всех, добавление, удаление.

ВАЖНО: ProductRepository и OrderRepository возвращает данные из БД, для этого необходимо создать 
БД и соответствующие таблицы