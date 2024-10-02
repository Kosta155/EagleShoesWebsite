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

CREATE TABLE Shoes (
  shoeId int NOT NULL AUTO_INCREMENT,
  shoeName varchar(50) NOT NULL,
  shoeBrand varchar(50) NOT NULL,
  shoeType varchar(50) NOT NULL,
  gender varchar(50) NOT NULL,
  shoeStatus varchar(255) NOT NULL,
  price bigint NOT NULL,
  shoeDate date NOT NULL,
  discount bigint DEFAULT NULL,
  PRIMARY KEY (shoeId)
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
  PRIMARY KEY (orderId)
);

Create Table orderShoe(
    orderId bigint NOT NULL,
    shoeId int NOT NULL,
    PRIMARY KEY (orderId, shoeId),
    CONSTRAINT quantity_OS1 FOREIGN KEY (orderId) REFERENCES Orders (orderId),
    CONSTRAINT quantity_OS2 FOREIGN KEY (shoeId) REFERENCES Shoes (shoeId)
);

CREATE TABLE sec_role (
  roleId bigint NOT NULL AUTO_INCREMENT,
  roleName varchar(30) NOT NULL,
  PRIMARY KEY (roleId)
);


CREATE TABLE Color(
colorName varchar(50) NOT NULL,
PRIMARY KEY (colorName)
);

CREATE TABLE Size(
size double NOT NULL,
PRIMARY KEY (size)
);

CREATE TABLE Quantity(
    colorName varchar(50) NOT NULL,
    size double NOT NULL,
    shoeId int NOT NULL,
    PRIMARY KEY (colorName, size, shoeId),
    CONSTRAINT quantity_FK1 FOREIGN KEY (colorName) REFERENCES Color (colorName),
    CONSTRAINT quantity_FK2 FOREIGN KEY (size) REFERENCES Size (size),
    CONSTRAINT quantity_FK3 FOREIGN KEY (shoeId) REFERENCES Shoes (shoeId)
);


CREATE TABLE Picture(
    pictureURL varchar(300),
  	picture2URL varchar(300),
  	picture3URL varchar(300),
 	picture4URL varchar(300),
    colorName varchar(50) NOT NULL,
    shoeId int NOT NULL,
    PRIMARY KEY (colorName, shoeId),
    CONSTRAINT picture_FK1 FOREIGN KEY (colorName) REFERENCES Color (colorName),
    CONSTRAINT picture_FK2 FOREIGN KEY (shoeId) REFERENCES Shoes (shoeId)
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

