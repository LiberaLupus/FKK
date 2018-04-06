create database KKK;
use KKK;

create table Karteien(
	Id int not null auto_increment,
    Name varchar(90) not null,
    primary key(Id));
    
create table Karten(
	Id int not null auto_increment,
    Frage varchar(90) not null,
    Antwort varchar(90) not null,
    richtig boolean,
    KarteienFk int not null,
    primary key(Id),
    foreign key(KarteienFk) references Karteien(Id) on delete cascade);
