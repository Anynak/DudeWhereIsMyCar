insert
into dude_where_is_my_car.users
(user_id, city, country, email, is_deleted, login, name, password_hash, phone)
values ( 777
       , 'testCity'
       , 'testCountry'
       , 'testMail'
       , false
       , 'testLogin'
       , 'testName'
       , 'testPassword'
       , 'testPhone');

insert into dude_where_is_my_car.user_role
(user_id, role_id)
VALUES (777, 2)