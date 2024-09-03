CREATE TABLE members (
  email varchar(50) NOT NULL,
  username varchar(50) NOT NULL,
  encryptedPassword varchar(128) NOT NULL,
  "ENABLED" boolean NOT NULL,  -- Corrected data type to boolean
  PRIMARY KEY (email)
);

CREATE TABLE address(
  addressId bigint NOT NULL AUTO_INCREMENT,
  street varchar(50) NOT NULL,
  city varchar(50) NOT NULL,
  province varchar(40) NOT NULL,
  country varchar(50) NOT NULL,
  postalCode varchar(10) NOT NULL,
  email varchar (50) NOT NULL,
  PRIMARY KEY (addressId),
  CONSTRAINT mambers_FK1 FOREIGN KEY (email) REFERENCES members (email)
);

CREATE TABLE orders (
  orderId bigint NOT NULL AUTO_INCREMENT,
  orderTime datetime NOT NULL,
  email varchar(80) NOT NULL,
  addressId bigint NOT NULL,
  street varchar(50) NOT NULL,
  city varchar(50) NOT NULL,
  province varchar(40) NOT NULL,
  country varchar(50) NOT NULL,
  postalCode varchar(10) NOT NULL,
  PRIMARY KEY (orderId),
  CONSTRAINT oder_FK1 FOREIGN KEY (email) REFERENCES members (email)
   
);

CREATE TABLE sec_role (
  roleId bigint NOT NULL AUTO_INCREMENT,
  roleName varchar(30) NOT NULL,
  PRIMARY KEY (roleId)
);



CREATE TABLE Shoes (
  shoeId int NOT NULL AUTO_INCREMENT,
  shoeName varchar(50) NOT NULL,
  shoeBrand varchar(50) NOT NULL,
  shoeType varchar(50) NOT NULL,
  gender varchar(50) NOT NULL,
  price bigint NOT NULL,
  shoeDate date NOT NULL,
  discount bigint DEFAULT NULL,
  color varchar(15) NOT NULL,
  size bigint NOT NULL,
  orderId bigint NOT NULL,
  pictureURL varchar(300),
  picture2URL varchar(300),
  picture3URL varchar(300),
  picture4URL varchar(300),
  PRIMARY KEY (shoeId),
  CONSTRAINT shoes_FK1 FOREIGN KEY (orderId) REFERENCES orders (orderId)
);

CREATE TABLE user_role (
  ID bigint NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  roleId bigint NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT USER_ROLE_FK1 FOREIGN KEY (email) REFERENCES members (email),
  CONSTRAINT USER_ROLE_FK2 FOREIGN KEY (roleId) REFERENCES sec_role (roleId)
);

CREATE TABLE favorites (
  favoriteId int NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  shoeId int NOT NULL,
  PRIMARY KEY (favoriteId),
  CONSTRAINT fav_FK1 FOREIGN KEY (shoeId) REFERENCES shoes (shoeId),
  CONSTRAINT fav_FK2 FOREIGN KEY (email) REFERENCES members (email)
);

