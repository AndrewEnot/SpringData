-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_order;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_order.my_order_id_seq;
CREATE SEQUENCE IF NOT EXISTS my_order.my_product_id_seq;

-- Создание таблицы Product
CREATE TABLE IF NOT EXISTS my_order.product
(
    id   serial,
    name text    NOT NULL,
    cost integer NOT NULL,
    primary key (id)
);

-- Создание таблицы Order
CREATE TABLE IF NOT EXISTS my_order.order
(
    id            serial,
    date_time     date    NOT NULL,
    cost_total    integer NOT NULL,
    fk_product_id integer NOT NULL,
    foreign key (fk_product_id) references my_order.product (id),
    primary key (id)
);

-- Создание таблицы Order&Product
CREATE TABLE IF NOT EXISTS my_order.order_product
(
    fk_order_id   integer NOT NULL,
    fk_product_id integer NOT NULL,
    primary key (fk_product_id),
    primary key (fk_order_id),
    foreign key (fk_product_id) references my_order.product (id),
    foreign key (fk_order_id) references my_order.order (id)
);
