create database KKK;

create table KKK.Karteien(
	Id int not null auto_increment,
    Name varchar(90) not null,
    primary key(Id));
    
insert into KKK.karteien
	(Name) Values
    ("Test 01");