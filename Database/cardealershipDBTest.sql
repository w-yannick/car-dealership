drop database if exists cardealershipDBTest;
create database cardealershipDBTest;
use cardealershipDBTest;

-- Superpower
create table cars(
	Id int primary key auto_increment,
    Brand varchar(50) not null,
    Price DECIMAL(10,2) not null,
    isNew boolean default false
);

INSERT INTO `cars` (`Id`,`Brand`,`Price`,`isNew`)
VALUES
	(1,"Toyota",1000.12,true);

-- User
create table User(
	UserId int primary key auto_increment,
    FirstName varchar(50),
    LastName varchar(50),
    Email varchar(50),
    Role varchar(50),
    Password varchar(50)
);

-- Make
create table Make(
	MakeId int primary key auto_increment,
    Name varchar(50),
    DateAdded Date,
    Email varchar(50),
    AddedByUserId int,
    foreign key (AddedByUserId)
		references User(UserId)
);

-- CarModel
create table CarModel(
	CarModelId int primary key auto_increment,
    MakeId int,
    Name VARCHAR(50),
    DateAdded Date,
    AddedByUserId int,
    foreign key(MakeId)
		references Make(MakeId), 
        foreign key(AddedByUserId)
		references User(UserId)
		
);

-- Vehicule
create table Vehicule(
	VehiculeId int primary key auto_increment,
    CarModelId INT,
    Type varchar(50),
    BodyStyle varchar(50),
    YEAR INT,
    AUTOMATIC boolean,
    ExteriorColor VARCHAR(50),
    InteriorColor VARCHAR(50),
    Mileage int,
    VINNumber VARCHAR(50),
    MSRP DECIMAL(10,2),
    SalePrice DECIMAL(10,2),
    Description VARCHAR(50),
    Featured boolean,
    Available boolean,
    foreign key (CarModelId)
		references CarModel(CarModelId)
);

-- Sale
create table Sale(
	SaleId int primary key auto_increment,
    Name VARCHAR(50),
    Phone VARCHAR(50),
    Email VARCHAR(50),
    Street1 VARCHAR(50),
    Street2 VARCHAR(50),
    City VARCHAR(50),
    State VARCHAR(50),
    Zipcode CHAR(5),
    VehiculeId INT,
    PurchasePrice DECIMAL(10,2),
    PurchaseType VARCHAR(50),
    UserId int,
    foreign key(VehiculeId)
		references Vehicule(VehiculeId),
	foreign key(UserId)
		references User(UserId)
);

-- Special
create table Special(
	SpecialId int primary key auto_increment,
    Title varchar(50),
    Description varchar(255)
);

-- Contact
create table Contact(
	ContactId int primary key auto_increment,
    Name varchar(50),
    LastName varchar(50),
    Email varchar(50),
    Phone varchar(50),
    Message varchar(255)
);


-- Inserting dummy value

INSERT INTO User (FirstName,LastName,Email,Role,Password)
VALUES ("Alex", "manu", "alex@gmail.com", "Admin", "password");


INSERT INTO Make (Name,DateAdded,AddedByUserId)
VALUES ("Audi","2022-07-22", 1);

INSERT INTO CarModel (MakeId,Name,DateAdded,AddedByUserId)
VALUES (1, "A8","2022-07-22", 1);

INSERT INTO Vehicule (CarModelId,Type,BodyStyle,Year,Automatic,ExteriorColor,InteriorColor,Mileage,VINNUMBER,MSRP,SalePrice,Description,Featured,Available)
VALUES (1,"New","Car",2015,true,"Black","Black",0,"4Y1SL65848Z411439",10000,9000,"its a car....",true,true);

INSERT INTO Vehicule (CarModelId,Type,BodyStyle,Year,Automatic,ExteriorColor,InteriorColor,Mileage,VINNUMBER,MSRP,SalePrice,Description,Featured,Available)
VALUES (1,"New","Car",2016,true,"Black","Black",0,"VIN2",10000,9900,"its a car....",true,true);

INSERT INTO Vehicule (CarModelId,Type,BodyStyle,Year,Automatic,ExteriorColor,InteriorColor,Mileage,VINNUMBER,MSRP,SalePrice,Description,Featured,Available)
VALUES (1,"New","Car",2015,true,"Black","Black",0,"VIN3",10000,9000,"its a car....",false,true);

INSERT INTO Sale (Name,Phone,Email,Street1,Street2,City,State, Zipcode,VehiculeId,PurchasePrice,PurchaseType,UserId)
VALUES ("Bob","1-111-111-1111","bob@gmail.com","123 street","apt 2","Montreal","QC", "12345",1,9000,"Bank Finance",1);

INSERT INTO Special (Description)
VALUES ("Special1 description bla bla bla");

INSERT INTO Contact (Name,Email, Phone, Message)
VALUES ("Patrick", "patrick@gmail.com", "1-111-111-1111","Message from contact bla bla bla");
