create database KKK;
use KKK;

create table Karteien(
	Id int not null auto_increment,
    Name varchar(90) not null,
    primary key(Id));
    
insert into karteien
	(Name) Values
    ("Test 01");
    
create table Karten(
	Id int not null auto_increment,
    Frage varchar(90) not null,
    Antwort varchar(90) not null,
    richtig boolean,
    KarteienFk int not null,
    primary key(Id),
    foreign key(KarteienFk) references Karteien(Id) on delete cascade);
    
insert into Karten(
		Frage,
        Antwort,
        KarteienFk
) Values (
		"1+1",
        "2",
        20
);
    
select k1.Name, k2.frage, k2.Antwort from karteien as k1 inner join karten as k2 on k1.Id = k2.KarteienFk;

select * from Karteien where Name = 'Test 01';

select * from karten;

delete from karteien where id = 19;
