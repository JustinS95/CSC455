drop table if exists rentals;
drop table if exists sales;
drop table if exists movies;
drop table if exists employees;
drop table if exists members;
drop table if exists store;
drop table if exists vendors;

create table store
(store_num	INT NOT NULL,
address		varchar(100) NOT NULL,
primary key(store_num) 	
) ENGINE = INNODB;

create table employees
(e_id		INT NOT NULL,
name		varchar(20) NOT NULL,
store_num	INT NOT NULL,
commission_rate	decimal(4, 2) NOT NULL,
primary key (e_id),
foreign key (store_num) references store(store_num)
) ENGINE = INNODB;

create table vendors
(vendor_name	varchar(50) NOT NULL,
address			varchar(100) NOT NULL,
phone			varchar(15) NOT NULL,
primary key(vendor_name)	
) ENGINE = INNODB;

create table movies
(v_id		INT NOT NULL,
stock_num	INT NOT NULL,
title		varchar(100) NOT NULL,
cost		decimal(4, 2) NOT NULL,
category	varchar(20) NOT NULL,
rent_price	decimal(4, 2) NOT NULL,
sale_price	decimal(4, 2) NOT NULL,
purchase_date	DATE NOT NULL,
vendor_name	varchar(50) NOT NULL,
qoh			INT NOT NULL,
primary key (stock_num, v_id),
foreign key (vendor_name) references vendors(vendor_name)
) ENGINE = INNODB;

create table members
(m_id		INT NOT NULL,
lname		varchar(20) NOT NULL,
fname		varchar(20) NOT NULL,
address		varchar(100) NOT NULL,
bonus_points	varchar(20),
primary key (m_id)
) ENGINE = INNODB;

create table rentals
(rental_num	INT NOT NULL,
m_id		INT NOT NULL,
stock_num	INT NOT NULL,
v_id		INT NOT NULL,
e_id		INT NOT NULL,
date_out	date NOT NULL,
frequency	varchar(10) NOT NULL,
date_in		date NOT NULL,
primary key (rental_num),
foreign key (m_id) references members (m_id),
CONSTRAINT FK_R foreign key (stock_num, v_id) references movies (stock_num, v_id),
foreign key (e_id) references employees (e_id)
) ENGINE = INNODB;

create table sales
(sale_num	INT NOT NULL,
m_id		INT NOT NULL,
stock_num	INT NOT NULL,
v_id		INT NOT NULL,
e_id		INT NOT NULL,
sale_date	date NOT NULL,
primary key (sale_num),
foreign key (m_id) references members (m_id),
CONSTRAINT FK_S foreign key (stock_num, v_id) references movies (stock_num, v_id),
foreign key (e_id) references employees (e_id)
) ENGINE = INNODB;

CREATE FUNCTION RentalTime(r_date_out DATE) RETURN DATE
	DETERMINISTIC
BEGIN
	DECLARE returnDate DATE;
	SET returnDate = DATEADD(DAY, 3, r_date_out);
	RETURN (returnDate);
END

CREATE FUNCTION getDate() RETURN DATE
	DETERMINISTIC
BEGIN
	DECLARE this_Date DATE;
	SET this_Date = CURRENT_DATE();
	RETURN (this_Date);
END

CREATE PROCEDURE pointLookup(member_id INT)
BEGIN
	SELECT lname, fname, bonus_points FROM members WHERE m_id = member_id;
END

CREATE PROCEDURE checkPrice(video_id INT)
BEGIN
	SELECT title, rent_price, sale_price FROM movies WHERE v_id = video_id;
END


CREATE TRIGGER 



