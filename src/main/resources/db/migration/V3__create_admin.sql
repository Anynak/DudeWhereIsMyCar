insert
into dude_where_is_my_car.users
(user_id, city, country, email, is_deleted, login, name, password_hash, phone)
values ( 666
       , 'Vitebsk'
       , 'Belarus'
       , 'admin@gmail.com'
       , false
       , 'admin'
       , 'Toha'
       , '$2a$10$Na2W/u7IMKlHd.PlXcFy7uyBKJvXI7mSP/kmMn34sTcAmYqNRdDI6'
       , '+375295159508');

insert into dude_where_is_my_car.user_role
    (user_id, role_id)
VALUES (666, 1)