create schema if not exists currencies;
create table currencies.currency
(
    currency_id   serial     not null,
    currency_name varchar(3) not null unique,
    primary key (currency_id)
);
create table currencies.currency_rate
(
    rate_id bigserial not null,
    date                 date not null,
    rate float4 not null,
    currency_currency_id integer,
    primary key (rate_id)
);
alter table if exists currencies.currency_rate
    add constraint FK_currency_rate_currency
    foreign key (currency_currency_id)
    references currencies.currency
