INSERT INTO members (email,username, encryptedPassword, "ENABLED")
VALUES ('kostika@example.com','kostika', '$2a$10$d8r8Z4P6A6jCTnmiYge.TecGJxZYcd6zkjCfXCDWBbGbDL8EHG7Ay', true);

INSERT INTO members (email,username, encryptedPassword, "ENABLED")
VALUES ('kostikanini@example.com','kostikas', '$2a$10$d8r8Z4P6A6jCTnmiYge.TecGJxZYcd6zkjCfXCDWBbGbDL8EHG7Ay', true);

INSERT INTO address (street, city, province,country,postalCode , email)
VALUES ('234 Wildgrass Rd','Mississauga','Ontario','Canada','L5B4H8','kostikanini@example.com');

INSERT INTO orders ( orderTime, email, addressId)
VALUES ( '2024-01-06 12:30:00', 'kostikanini@example.com', 1);

INSERT INTO sec_role (roleId, roleName)
VALUES (1, 'ROLE_MEMBER');

INSERT INTO sec_role (roleId, roleName)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role ( email, roleId)
VALUES ( 'kostika@example.com', 1);

INSERT INTO user_role ( email, roleId)
VALUES ( 'kostikanini@example.com', 2);


INSERT INTO Shoes (shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Nike City Sneakers', 'Nike', 'Casual', 'Male', 150, CURDATE(), 0, 'Black', 10, 1, 'https://theline.cl/img/products/DQ5601-001-1_1024.png', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Addidas Hoop Shoes', 'Addidas', 'Sport', 'Male', 130, CURDATE(), 0, 'Blue', 10, 1, 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1687895423-adidas-hoops-3-0-mid-classic-gold-metallic-shoes-649b3d786ac33.jpg?crop=1xw:1xh;center,top&resize=980:*', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Nike Revolution 6 Sneakers', 'Nike', 'Sport', 'Male',  200, CURDATE(), 0, 'Blue', 10, 1, 'https://i8.amplience.net/s/scvl/119208_271610_SET/1?fmt=auto', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Timberland Premium', 'Timberland', 'Winter Boot', 'Male', 400, CURDATE(), 0, 'White', 10, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fd5cf11b9cff43b79244011ed13f0d58_9366/Samba_OG_Shoes_Kids_White_IE8848_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Puma Sneakers', 'Puma', 'Sport', 'Male', 300, CURDATE(), 0, 'White', 9, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/44940bb1ca7d456881bcc27d54a63574_9366/ADVANTAGE_K_White_ID8408_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes (shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Nike City Sneakers', 'Nike', 'Casual', 'Male', 150, CURDATE(), 0, 'Black', 10, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/6979280bc898426490162883b0726ee9_9366/VL_Court_3.0_Shoes_Kids_Turquoise_IH2406_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Addidas Hoop Shoes', 'Addidas', 'Sport', 'Male', 130, CURDATE(), 0, 'Blue', 10, 1, 'https://assets.adidas.com/images/w_600,f_auto,q_auto/016bf1019b6349edb0455c9546c69081_9366/Gazelle_Bold_Shoes_Blue_IG4367_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Nike Revolution 6 Sneakers', 'Nike', 'Sport', 'Male',  200, CURDATE(), 0, 'Blue', 10, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/44940bb1ca7d456881bcc27d54a63574_9366/ADVANTAGE_K_White_ID8408_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Timberland Premium', 'Timberland', 'Winter Boot', 'Male', 400, CURDATE(), 0, 'White', 10, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/3a25178dda694b8d9badc3c631d85aa2_9366/Star_Wars_Runner_Shoes_Kids_Black_ID5229_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Addidas Court Team Bounce', 'Puma', 'Sport', 'Male', 300, CURDATE(), 0, 'White', 9, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/c7c25b8f51da4d2299afaf3500b71695_9366/Court_Team_Bounce_2.0_Shoes_Black_HR0609_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Puma Speakers', 'Puma', 'Sport', 'Male', 300, CURDATE(), 0, 'White', 9, 1, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/58830d68ad404344887beeb23582e1ce_9366/Forum_XLG_Shoes_Black_IG2576_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');

INSERT INTO Shoes ( shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount, color, size, orderId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES ( 'Puma Skeakers', 'Puma', 'Sport', 'Male', 300, CURDATE(), 0, 'White', 9, 1, 'https://images.footlocker.com/is/image/EBFL2/4206708_a1?wid=581&hei=581&fmt=png-alpha', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');