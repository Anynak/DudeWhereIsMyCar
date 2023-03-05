create schema if not exists dude_where_is_my_car;

create table dude_where_is_my_car.users
(
    user_id       bigserial             not null,
    city          varchar(40)           not null,
    country       varchar(40)           not null,
    email         varchar(40)           not null unique,
    is_deleted    boolean default false not null,
    login         varchar(20)           not null unique,
    name          varchar(20)           not null,
    password_hash varchar(255)          not null,
    phone         varchar(20)           not null unique,
    primary key (user_id)
);
create table dude_where_is_my_car.role
(
    role_id   serial       not null,
    role_name varchar(255) not null unique,
    primary key (role_id)
);
create table dude_where_is_my_car.user_role
(
    user_id bigint not null,
    role_id int    not null
);

create table dude_where_is_my_car.announcement
(
    announcement_id    bigserial             not null,
    comment            text,
    is_deleted         boolean default false not null,
    price              float4                not null,
    user_user_id       bigint,
    vehicle_vehicle_id bigint,
    primary key (announcement_id)
);
create table dude_where_is_my_car.vehicle
(
    vehicle_id                     bigserial   not null,
    color                          varchar(40) not null,
    mileage                        integer     not null,
    release_year                   integer     not null,
    vehicle_model_vehicle_model_id bigint      not null,
    primary key (vehicle_id)
);
create table dude_where_is_my_car.vehicle_brand
(
    vehicle_brand_id   bigserial   not null,
    vehicle_brand_name varchar(40) not null unique,
    primary key (vehicle_brand_id)
);
create table dude_where_is_my_car.vehicle_model
(
    vehicle_model_id               bigserial    not null,
    vehicle_model_name             varchar(255) not null,
    vehicle_brand_vehicle_brand_id bigint       not null,
    primary key (vehicle_model_id)
);



alter table dude_where_is_my_car.user_role
    add constraint FK_user_role_user
        foreign key (user_id)
            references dude_where_is_my_car.users (user_id);

alter table dude_where_is_my_car.user_role
    add constraint FK_role
        foreign key (role_id)
            references dude_where_is_my_car.role (role_id);

alter table dude_where_is_my_car.announcement
    add constraint FK_announcement_user
        foreign key (user_user_id)
            references dude_where_is_my_car.users (user_id);

alter table dude_where_is_my_car.announcement
    add constraint FK_announcement_vehicle
        foreign key (vehicle_vehicle_id)
            references dude_where_is_my_car.vehicle (vehicle_id);

alter table dude_where_is_my_car.vehicle
    add constraint FK_vehicle_model
        foreign key (vehicle_model_vehicle_model_id)
            references dude_where_is_my_car.vehicle_model (vehicle_model_id);

alter table dude_where_is_my_car.vehicle_model
    add constraint FK_vehicle_brand
        foreign key (vehicle_brand_vehicle_brand_id)
            references dude_where_is_my_car.vehicle_brand (vehicle_brand_id);