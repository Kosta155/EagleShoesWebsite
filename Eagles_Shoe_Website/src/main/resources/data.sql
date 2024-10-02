INSERT INTO members (email,username, encryptedPassword, "ENABLED")
VALUES ('kostika@example.com','kostika', '$2a$10$d8r8Z4P6A6jCTnmiYge.TecGJxZYcd6zkjCfXCDWBbGbDL8EHG7Ay', true);

INSERT INTO members (email,username, encryptedPassword, "ENABLED")
VALUES ('kostikanini@example.com','kostikas', '$2a$10$d8r8Z4P6A6jCTnmiYge.TecGJxZYcd6zkjCfXCDWBbGbDL8EHG7Ay', true);

INSERT INTO address (street, city, province,country,postalCode , email)
VALUES ('234 Wildgrass Rd','Mississauga','On','Canada','L5B4H8','kostika@example.com');


INSERT INTO address (street, city, province,country,postalCode , email)
VALUES ('234 Riel Drive','Oakville','On','Canada','L5B4K1','kostika@example.com');

INSERT INTO orders (orderTime, email, addressId, street, city, province, country, postalCode)
VALUES ('2024-09-02 10:30:00', 'kostika@example.com', 1001, '123 Main St', 'Vancouver', 'British Columbia', 'Canada', 'V5K0A1');

INSERT INTO orders (orderTime, email, addressId, street, city, province, country, postalCode)
VALUES ('2024-09-03 14:15:00', 'kostika@example.com', 1002, '456 Maple Rd', 'Toronto', 'Ontario', 'Canada', 'M5J2N1');

INSERT INTO orders (orderTime, email, addressId, street, city, province, country, postalCode)
VALUES ('2024-09-04 09:00:00', 'kostika@example.com', 1003, '789 Oak Ave', 'Calgary', 'Alberta', 'Canada', 'T2P3N4');

INSERT INTO orders (orderTime, email, addressId, street, city, province, country, postalCode)
VALUES ('2024-09-05 17:45:00', 'kostika@example.com', 1004, '321 Pine Dr', 'Montreal', 'Quebec', 'Canada', 'H3A2G3');



INSERT INTO sec_role (roleId, roleName)
VALUES (1, 'ROLE_MEMBER');

INSERT INTO sec_role (roleId, roleName)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role ( email, roleId)
VALUES ( 'kostika@example.com', 1);

INSERT INTO user_role ( email, roleId)
VALUES ( 'kostikanini@example.com', 2);


INSERT INTO Shoes (shoeName, shoeBrand, shoeType, gender, price, shoeDate, discount,shoeStatus)
VALUES 
('Nike City Sneakers', 'Nike', 'Casual', 'Male', 150, CURDATE(), 0, 'Okay'),
('Addidas Hoop Shoes', 'Addidas', 'Sport', 'Male', 130, CURDATE(), 0, 'Okay'),
('Nike Revolution 6 Sneakers', 'Nike', 'Sport', 'Male', 200, CURDATE(), 0, 'Okay'),
('Timberland Premium', 'Timberland', 'Winter Boot', 'Male', 400, CURDATE(), 0, 'Okay'),
('Puma Sneakers', 'Puma', 'Sport', 'Male', 300, CURDATE(), 0, 'Okay');


INSERT INTO Color (colorName)
VALUES 
('Black'),
('Blue'),
('White');

INSERT INTO Size (size)
VALUES 
(10),
(9),
(9.5),
(8.5),
(8);


INSERT INTO Quantity (colorName, size, shoeId)
VALUES 
('Black', 10, 1),
('Black', 9, 1),
('Blue', 10, 2),
('Blue', 9.5, 2),
('Blue', 8.5, 3),
('White', 10, 4),
('White', 9, 4),
('White', 8, 5);


INSERT INTO Picture (colorName, shoeId, pictureURL, picture2URL, picture3URL, picture4URL)
VALUES 
('Black', 1, 'https://theline.cl/img/products/DQ5601-001-1_1024.png', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg'),
('Blue', 2, 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1687895423-adidas-hoops-3-0-mid-classic-gold-metallic-shoes-649b3d786ac33.jpg?crop=1xw:1xh;center,top&resize=980:*', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg'),
('Blue', 3, 'https://i8.amplience.net/s/scvl/119208_271610_SET/1?fmt=auto', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg'),
('White', 4, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fd5cf11b9cff43b79244011ed13f0d58_9366/Samba_OG_Shoes_Kids_White_IE8848_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg'),
('White', 5, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/44940bb1ca7d456881bcc27d54a63574_9366/ADVANTAGE_K_White_ID8408_01_standard.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg', 'NikeRunning.jpg');


INSERT INTO favorites (email, shoeId) VALUES
('kostika@example.com', 1),
('kostika@example.com', 2);