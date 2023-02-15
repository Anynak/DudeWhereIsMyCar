insert
into dude_where_is_my_car.users
(user_id, city, country, email, is_deleted, login, name, password_hash, phone)
values (10000, 'testCity', 'testCountry', 'testMail', false, 'testLogin', 'Cayden', 'testPassword', 'testPhone'),
       (10001, 'testCity1', 'testCountry1', 'testMail1', false, 'testLogin1', 'Pablo', 'testPassword1','testPhone1'),
       (10002, 'testCity2', 'testCountry2', 'testMail2', false, 'testLogin2', 'Brock', 'testPassword2','testPhone2'),
       (10003, 'searchCity3', 'searchCountry3', 'testMail3', false, 'testLogin3', 'Ulric', 'testPassword3','testPhone3'),
       (10004, 'searchCity4', 'searchCountry4', 'testMail4', false, 'testLogin4', 'Harlow', 'testPassword4','testPhone4'),
       (10005, 'searchCity5', 'searchCountry5', 'testMail5', false, 'testLogin5', 'Valli', 'testPassword5','testPhone5'),
       (10006, 'searchCity6', 'searchCountry6', 'testMail6', false, 'testLogin6', 'Chance', 'testPassword6','testPhone6'),
       (10007, 'testCity7', 'testCountry7', 'testMail7', false, 'testLogin7', 'Valli', 'testPassword7','testPhone7'),
       (10008, 'testCity8', 'testCountry8', 'testMail8', false, 'testLogin8', 'Pete', 'testPassword8','testPhone8'),
       (10009, 'testCity9', 'testCountry9', 'testMail9', false, 'testLogin9', 'Austin', 'testPassword9','testPhone9'),
       (10010, 'testCity10', 'testCountry10', 'testMail10', false, 'testLogin10', 'Raphael', 'testPassword10','testPhone10'),
       (10011, 'testCity11', 'testCountry11', 'testMail11', false, 'testLogin11', 'Valli', 'testPassword11','testPhone11'),
       (10012, 'testCity12', 'testCountry12', 'testMail12', false, 'testLogin12', 'Graham', 'testPassword12','testPhone12'),
       (10013, 'testCityDel', 'testCountryDel', 'testMailDel', true, 'testLoginDel', 'Ziya', 'testPasswordDel','testPhoneDel'),
       (10014, 'testCityDel1', 'testCountryDel1', 'testMailDel1', true, 'testLoginDel1', 'Wiley','testPasswordDel1', 'testPhoneDel1');

insert into dude_where_is_my_car.user_role
    (user_id, role_id)
VALUES (10000, 1),
       (10001, 1),
       (10002, 2),
       (10003, 2),
       (10004, 2),
       (10005, 2),
       (10006, 2),
       (10007, 2),
       (10008, 2),
       (10009, 2),
       (10010, 2),
       (10011, 2),
       (10012, 2),
       (10013, 2),
       (10014, 1);