drop database if exists cardealershipDB;
create database cardealershipDB;
use cardealershipDB;

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
    Transmission VARCHAR(50),
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
    date Date,
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
    Email varchar(50),
    Phone varchar(50),
    Message varchar(255)
);


-- Inserting dummy value

INSERT INTO User (FirstName,LastName,Email,Role,Password)
VALUES
	("Alex", "Manu", "admin@gmail.com", "Admin", "password"),
	("Bob", "Sponge", "sales@gmail.com", "Sales", "password"),
	("Patrick", "Star", "disabled@gmail.com", "disabled", "password");

INSERT INTO Make (Name,DateAdded,AddedByUserId)
VALUES 
	("Audi","2022-07-22", 1),
    ("Ford","2022-07-22", 1),
    ("Toyota","2022-07-22", 1);

INSERT INTO CarModel (MakeId,Name,DateAdded,AddedByUserId)
VALUES 
	(1, "A8","2022-07-22", 1),
    (1, "A4","2022-07-22", 1),
    (2, "F8","2022-07-22", 1),
    (2, "F4","2022-07-22", 1),
    (3, "T8","2022-07-22", 1),
    (3, "T4","2022-07-22", 1);

INSERT INTO Vehicule (CarModelId,Type,BodyStyle,Year,Transmission,ExteriorColor,InteriorColor,Mileage,VINNUMBER,MSRP,SalePrice,Description,Featured,Available)
VALUES 
	(1,"New","Car",2015,"Automatic","Black","Black",0,"4Y1SL65848Z411439",10000,9000,"its a car....",true,true),
	(1,"New","Car",2016,"Automatic","Black","Black",0,"VIN2",10000,9900,"its a car....",true,true),
	(2,"New","Car",2015,"Automatic","Black","Black",0,"VIN3",10000,9000,"its a car....",false,false),
	(2,"New","Car",2016,"Automatic","Black","Black",0,"VIN2",10000,9900,"its a car....",true,true),
	(3,"New","Car",2016,"Automatic","Black","Black",0,"VIN2",10000,9900,"its a car....",true,false),
	(3,"Used","Car",2015,"Automatic","Black","Black",0,"VIN2",10000,9900,"its a car....",false,true),
	(2,"Used","Car",2016,"Manual","Black","Black",0,"VIN2",10000,9900,"its a car....",false,false),
	(2,"Used","Car",2015,"Manual","Black","Black",0,"VIN2",10000,9900,"its a car....",true,true),
	(3,"Used","Car",2016,"Manual","Black","Black",0,"VIN2",10000,9900,"its a car....",false,true),
	(3,"Used","Car",2016,"Automatic","Black","Black",0,"VIN2",10000,9900,"its a car....",false,true),
	(4,"Used","Car",2015,"Manual","Black","Black",0,"VIN2",10000,9900,"its a car....",false,false),
	(1,"Used","Car",2016,"Manual","Black","Black",0,"VIN2",10000,9900,"its a car....",true,true),
	(1,"New","Car",2015,"Automatic","Black","Black",0,"4Y1SL65848Z411439",10000,9000,"its a car....",true,true),
	(1,"New","Car",2015,"Automatic","Black","Black",0,"4Y1SL65848Z411439",10000,9000,"its a car....",true,true);


INSERT INTO Sale (Name,Phone,Email,Street1,Street2,City,State, Zipcode,VehiculeId,PurchasePrice,PurchaseType,date,UserId)
VALUES
	("Bob","1-111-111-1111","bob@gmail.com","123 street","apt 2","Montreal","QC", "12345",3,9000,"Bank Finance","2022-03-22",1),
	("Patrick","1-111-111-1111","patrick@gmail.com","13 street","apt 22","Montreal","QC", "12345",5,9000,"Bank Finance","2022-04-22",2),
	("Ken","1-111-111-1111","ken@gmail.com","163 street","apt 3","Montreal","QC", "12345",7,9000,"Bank Finance","2022-05-22",2),
	("Tara","1-111-111-1111","tara@gmail.com","45 street","apt 1","Montreal","QC", "12345",11,9000,"Bank Finance","2022-07-22",2);




INSERT INTO Special (Title, Description)
VALUES 
	("special1 Title","Special1 description bla bla bla"),
    ("special2 Title","Special2 description bla bla bla"),
    ("special3 Title","Special3 description bla bla bla"),
    ("special4 Title","Special4 description bla bla bla"),
    ("special5 Title","Special5 description bla bla bla");
    

INSERT INTO Contact (Name,Email, Phone, Message)
VALUES ("Patrick", "patrick@gmail.com", "1-111-111-1111","Message from contact bla bla bla");
