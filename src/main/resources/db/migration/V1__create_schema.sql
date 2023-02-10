create table dude_where_is_my_car.users
(
    user_id       serial                not null,
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
    user_id bigint  not null,
    role_id integer not null
);

create table dude_where_is_my_car.announcement
(
    announcement_id    serial                not null,
    comment            text,
    is_deleted         boolean default false not null,
    price              float4                not null,
    user_user_id       bigint,
    vehicle_vehicle_id bigint,
    primary key (announcement_id)
);
create table dude_where_is_my_car.vehicle
(
    vehicle_id                     serial      not null,
    color                          varchar(40) not null,
    mileage                        integer     not null,
    release_year                   integer     not null,
    vehicle_model_vehicle_model_id bigint      not null,
    vehicle_type_vehicle_type_id   bigint      not null,
    primary key (vehicle_id)
);
create table dude_where_is_my_car.vehicle_brand
(
    vehicle_brand_id   serial      not null,
    vehicle_brand_name varchar(40) not null unique,
    primary key (vehicle_brand_id)
);
create table dude_where_is_my_car.vehicle_model
(
    vehicle_model_id               serial       not null,
    vehicle_model_name             varchar(255) not null,
    vehicle_brand_vehicle_brand_id bigint       not null,
    primary key (vehicle_model_id)
);
create table dude_where_is_my_car.vehicle_type
(
    vehicle_type_id serial       not null,
    type_name       varchar(255) not null unique,
    primary key (vehicle_type_id)
);



alter table dude_where_is_my_car.user_role
    add constraint FK_user
        foreign key (user_id)
            references dude_where_is_my_car.users (user_id);

alter table dude_where_is_my_car.user_role
    add constraint FK_role
        foreign key (role_id)
            references dude_where_is_my_car.role (role_id);

alter table dude_where_is_my_car.announcement
    add constraint FK_user
        foreign key (user_user_id)
            references dude_where_is_my_car.users (user_id);

alter table dude_where_is_my_car.announcement
    add constraint FK_vehicle
        foreign key (vehicle_vehicle_id)
            references dude_where_is_my_car.vehicle (vehicle_id);

alter table dude_where_is_my_car.vehicle
    add constraint FK_vehicle_model
        foreign key (vehicle_model_vehicle_model_id)
            references dude_where_is_my_car.vehicle_model (vehicle_model_id);

alter table dude_where_is_my_car.vehicle
    add constraint FK_vehicle_type
        foreign key (vehicle_type_vehicle_type_id)
            references dude_where_is_my_car.vehicle_type (vehicle_type_id);

alter table dude_where_is_my_car.vehicle_model
    add constraint FK_vehicle_brand
        foreign key (vehicle_brand_vehicle_brand_id)
            references dude_where_is_my_car.vehicle_brand (vehicle_brand_id);