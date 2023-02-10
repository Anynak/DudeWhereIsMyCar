insert
into dude_where_is_my_car.users
(user_id, city, country, email, is_deleted, login, name, password_hash, phone)
values ( 1
       , 'Vitebsk'
       , 'Belarus'
       , 'admin@gmail.com'
       , false
       , 'admin'
       , 'Toha'
       , '$2a$10$OxFn/e0lLNpxJEoPFeyAxef.DsHPeTKFVZYYFvl5tg5yE.kTHw7ca'
       , '+375295159508');

insert into dude_where_is_my_car.user_role
    (user_id, role_id)
VALUES (1, 1)