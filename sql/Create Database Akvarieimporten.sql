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
    serial_number int unique not null,

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
    city_name varchar(50) not null,
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
	price_pr_kilo float not null,
    date date not null,
    supplier_id int not null,
    serial_number int unique not null,
    constraint fk_supplier_id foreign key(supplier_id) references supplier(id),
);

create table feeding_plan(
	id int primary key identity(1,1),
    name varchar(50) unique not null,
	interval int not null, 
    amount int not null,
    food_id int not null,
    constraint fk_food_id foreign key(food_id) references food(id),
);

create table price_category(
    id int primary key identity(1,1),
    min_size float not null,
    price int not null,
    date datetime not null,
    unique(min_size, date),
);

create table fish_species(
	id int primary key identity(1,1),
	name varchar(100) not null,
	average_eggs int not null,
    birth_size float not null,
    grow_rate float not null,
	minimum_sale_size int not null,
    price_category_id int not null,

    constraint fk_price_category_id foreign key(price_category_id) references price_category(id),
);

create table fish_purchase(
	id int primary key identity(1,1),
	date date not null,
	price int not null,
    amount int not null,
    fish_specie_id int not null,
    supplier_id int not null,

	unique(date, fish_specie_id, supplier_id),
    constraint fk_fish_specie_id foreign key(fish_specie_id) references fish_species(id),
    constraint fk_supplier_fish_purchase foreign key(supplier_id) references supplier(id),
);

create table fish_pack(
    id int primary key identity(1,1),
    birthday date not null,
    pack_number int unique not null,
    status varchar(25) not null,
    fish_specie_id int not null,
    feeding_plan_id int not null,

    constraint fk_fish_specie_fish_pack foreign key(fish_specie_id) references fish_species(id),
    constraint fk_feeding_plan_id foreign key(feeding_plan_id) references feeding_plan(id),
);

create table aquarium(
    id int primary key identity(1,1),
    location_id int not null,
    expense_id int not null,
    number varchar(50) not null,
    size int not null,
    unique(location_id, number),
);

create table [period](
    id int primary key identity(1,1),
    start_date date not null,
    end_date date,
    equipment_id int,
    aquarium_id int,
    type varchar(25) not null,
    unique(start_date, equipment_id, aquarium_id, type),

    constraint fk_equipment_id foreign key(equipment_id) references equipment(id),
    constraint fk_aquarium_id foreign key(aquarium_id) references aquarium(id),
);

create table fish_pack_period(
    fish_specie_id int not null,
    period_id int not null,
    unique(fish_specie_id, period_id),
    constraint fk_fish_specie_fishPack_period_id foreign key(fish_specie_id) references fish_species(id),
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
    person_id int primary key not null,
    role varchar(25) not null,
    location_id int not null,
    constraint fk_location_id foreign key(location_id) references [location](id),

);

