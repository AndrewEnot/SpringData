-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_order;


-- Создание таблицы Order
CREATE TABLE IF NOT EXISTS my_order.order
(
    id            serial,
    date_time     date    NOT NULL,
    cost_total    integer NOT NULL,
    primary key (id)
);
-- Создание таблицы Product
CREATE TABLE IF NOT EXISTS my_order.product
(
    id   serial,
    name text    NOT NULL,
    cost integer NOT NULL,
    fk_order_id integer NOT NULL,
    primary key (id),
    foreign key (fk_order_id) references my_order.order (id)
);


