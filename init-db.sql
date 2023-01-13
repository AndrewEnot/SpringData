-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_order;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_order.my_order_id_seq;
CREATE SEQUENCE IF NOT EXISTS my_order.my_product_id_seq;


-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_order.product
(
    id   integer NOT NULL DEFAULT nextval('my_order.my_product_id_seq'),
    name text    NOT NULL,
    cost integer,
    primary key (id)
);

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_order.order
(
    id                  integer NOT NULL DEFAULT nextval('my_order.my_order_id_seq'),
    date_time date NOT NULL,
    cost_total  text    NOT NULL,

    primary key (id)
);


-- -- Создание таблицы
-- CREATE TABLE IF NOT EXISTS my_report.basic
-- (
--     id         integer NOT NULL DEFAULT nextval('my_report.my_report_id_seq'),
--     brand_name text,
--     product    text,
--     unit       text,
--     quantity   float,
--     price      float,
--     currency   text,
--     primary key (id),
--     foreign key (brand_name) references my_report.brands (brand_name),
--     foreign key (unit) references my_report.units (unit_name_short),
--     foreign key (currency) references my_report.currencies (currency_name_short)
-- );
