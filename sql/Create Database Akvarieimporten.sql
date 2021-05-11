use dmab0920_1086225;

--repeat until no more errors
declare @count int;
set @count = 1;
while @count <= 6
begin
	print @count;
	exec sp_MSforeachtable @command1 = "DROP TABLE ?";
	set @count = @count + 1;
end;
go


create table equipment(
    id int primary key identity(1,1),
    name varchar(50) not null,
    description varchar(300) not null,
    watt int,
    serialNumber int unique not null,

);

create table person(
    id int primary key identity(1,1),
    name varchar(50) not null,
    birthday date not null,
    person_type varchar(50) not null,
    unique(name, birthday),
);

create table city(
    zipcode int primary key,
    cityName varchar(50) not null,
);

create table supplier(
	id int primary key identity(1,1),
	name varchar(50) not null,
	phone varchar(25) not null,
    cvr varchar(25) unique not null,
    address varchar(25) not null,
    zipcode int,
    constraint fk_zipcode foreign key(zipcode) references city(zipcode),
);

create table food(
	id int primary key identity(1,1),
	name varchar(50) not null,
	pricePrGram float not null,
    date date not null,
    supplier_id int not null,
    serialNumber int unique not null,
    constraint fk_supplier_id foreign key(supplier_id) references supplier(id),
);

create table feedingPlan(
	id int primary key identity(1,1),
    name varchar(50) unique not null,
	interval int not null, 
    amount int not null,
    food_id int not null,
    constraint fk_food_id foreign key(food_id) references food(id),
);

create table priceCategory(
    id int primary key identity(1,1),
    minSize float not null,
    price int not null,
    date datetime not null,
    unique(minSize, date),
);

create table fishSpecies(
	id int primary key identity(1,1),
	name varchar(100) not null,
	average_eggs int not null,
    birthSize float not null,
    growRate float not null,
    priceCategory_id int not null,

    constraint fk_priceCategory_id foreign key(priceCategory_id) references priceCategory(id),
);

create table fishPurchase(
	id int primary key identity(1,1),
	date date unique not null,
	price int not null,
    amount int not null,
    fishSpecie_id int not null,
    supplier_id int not null,

    constraint fk_fishSpecie_id foreign key(fishSpecie_id) references fishSpecies(id),
    constraint fk_supplier_fishPurchase foreign key(supplier_id) references supplier(id),
);

create table fishPack(
    id int primary key identity(1,1),
    birthday date not null,
    packNumber int unique not null,
    status varchar(25) not null,
    fishSpecie_id int not null,
    feedingPlan_id int not null,

    constraint fk_fishSpecie_fishPack foreign key(fishSpecie_id) references fishSpecies(id),
    constraint fk_feedingPlan_id foreign key(feedingPlan_id) references feedingPlan(id),
);

create table aquarium(
    id int primary key identity(1,1),
    location_id int not null,
    expense_id int not null,
    number int not null,
    size int not null,
    unique(location_id, number),
);

create table [period](
    id int primary key identity(1,1),
    startDate date not null,
    endDate date not null,
    equipment_id int,
    aquarium_id int,
    type varchar(25) not null,
    unique(startDate, equipment_id, aquarium_id, type),

    constraint fk_equipment_id foreign key(equipment_id) references equipment(id),
    constraint fk_aquarium_id foreign key(aquarium_id) references aquarium(id),
);

create table fishPack_period(
    fishSpecie_id int not null,
    period_id int not null,
    unique(fishSpecie_id, period_id),
    constraint fk_fishSpecie_fishPack_period_id foreign key(fishSpecie_id) references fishSpecies(id),
    constraint fk_period_fishPack_period_id foreign key(period_id) references [period](id),
);

create table aquarium_period(
    aquarium_id int not null,
    period_id int not null,
    unique(aquarium_id, period_id),
    constraint fk_aquarium_aquarium_period_id foreign key(aquarium_id) references aquarium(id),
    constraint fk_period_aquarium_period_id foreign key(period_id) references period(id),
);

create table expense(
    id int primary key identity(1,1),
    unit varchar(4) not null,
    price int not null,
    date date not null,
    unique(unit, date),
);



create table [location](
    id int primary key identity(1,1),
    address varchar(50) not null,
    zipcode int not null,
    unique(address, zipcode),
        constraint fk_zipcode_location foreign key(zipcode) references city(zipcode),

);

create table employee(
    person_id int primary key identity(1,1),
    role varchar(25) not null,
    location_id int not null,
    constraint fk_location_id foreign key(location_id) references [location](id),

);

