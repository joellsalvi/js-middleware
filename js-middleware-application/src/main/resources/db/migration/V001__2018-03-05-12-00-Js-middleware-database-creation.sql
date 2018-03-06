create table if not exists Country (
  id serial primary key,
  name varchar(60) default null unique,
  short_name varchar(10) default null unique,
  phone_code varchar(10) default null unique
);


create table if not exists State (
  id serial primary key,
  name varchar(75) default null unique,
  uf varchar(5) default null unique,
  country bigint default null,
  CONSTRAINT fk_State_country FOREIGN KEY (country) REFERENCES country (id) MATCH FULL
);


create table if not exists City (
  id serial primary key,
  name varchar(120) default null,
  state bigint default null,
  CONSTRAINT city_unique_index UNIQUE (name, state),
  CONSTRAINT fk_City_state FOREIGN KEY (state) REFERENCES state (id) MATCH FULL
);


create table if not exists Customer (
id varchar(255) not null PRIMARY KEY,
name varchar(15) not null,
second_name varchar(100) not null,
email varchar(100) UNIQUE not null,
birthday TIMESTAMP not null,
identification varchar(100) not null UNIQUE,
identification_type varchar(15) not null,
register_date TIMESTAMP not null,
update_date timestamp,
active BOOLEAN not null DEFAULT TRUE);


create table if not exists Phone
(
	id serial not null primary key,
	country_code varchar(5) not null,
	state_code varchar(10) not null,
	number varchar(15) not null unique,
	owner_id varchar(255) not null,
	owner_type varchar(1) not null
);


create table if not exists Bank
(
	id serial not null primary key,
	code varchar(5) not null,
	name varchar(100) not null,
	type varchar(100) not null,
  CONSTRAINT bank_unique UNIQUE (name, type)
);


create table Company
(
	id varchar(255) not null primary key,
	identification varchar(100) not null unique,
	identification_type varchar(15) not null,
	fantasy_name varchar(100) not null,
	comercial_name varchar(100) not null unique,
	business_size varchar(100) not null,
	birth_date timestamp not null,
	register_date timestamp not null,
	update_date timestamp,
	company_sector varchar(100) not null,
	customer_id varchar(255) not null,
	nominal_capital decimal,
	email varchar(45) not null unique,
	website varchar(255) not null,
	is_private BOOLEAN not null,
	active BOOLEAN not null,
  CONSTRAINT fk_Company_customer FOREIGN KEY (customer_id) REFERENCES customer (id) MATCH FULL
);


create table if not exists Card
(
	id serial not null primary key,
	number varchar(45) not null,
	validity timestamp not null,
	name varchar(45) not null,
	brand varchar(45) not null,
	agency varchar(20) not null,
	agency_digit varchar(1),
	account varchar(20) not null,
	account_digit varchar(1),
	bank_id bigint not null,
	cvv bigint,
	function varchar(1) not null,
	status varchar(1) not null,
	register_date timestamp not null,
	update_date timestamp,
	owner_id varchar(255) not null,
	owner_type varchar(1) not null,
  CONSTRAINT fk_Card_bank FOREIGN KEY (bank_id) REFERENCES bank (id) MATCH FULL,
  CONSTRAINT unique_card UNIQUE (number, agency, account, bank_id, brand)
);


create table if not exists Login
(
	id serial not null primary key,
	owner_id varchar(255) not null,
	owner_type varchar(1) not null,
	username varchar(100) not null unique,
	old_username varchar(100),
	password varchar(255) not null,
	old_password varchar(255),
	register_date timestamp not null,
	update_date timestamp
);


create table if not exists login_control (
  id_login integer not null primary key,
  username varchar(100) not null,
  attempts smallint default 0,
  last_try_date timestamp
);


create table if not exists Payment
(
	id serial not null primary key,
	token varchar(255) not null unique,
	qr_code bytea,
	price decimal not null,
	currency_iso_code varchar(5) not null,
	description varchar(45),
	payment_date timestamp not null,
	status bigint not null,
	register_date timestamp not null,
	update_date timestamp,
	expiration_date timestamp,
	owner_id varchar(255) not null,
	owner_type varchar(1) not null,
  payer_id varchar(255),
	payer_type varchar(1)
);


create table if not exists Payment_Status (
  id serial not null primary key,
  payment bigint not null,
  status varchar(1) not null,
  register_date timestamp not null,
  CONSTRAINT fk_payment FOREIGN KEY (payment) REFERENCES Payment (id)
);


create table if not exists Address
(
  id serial not null primary key,
  street varchar(100) not null,
  number bigint not null,
  complement varchar(100) NULL,
  neighborhood varchar(100) not null,
  area_code varchar(20) not null,
  city bigint not null,
  owner_id varchar(255) not null,
  owner_type varchar(1) not null,
  CONSTRAINT fk_Address_city FOREIGN KEY (city) REFERENCES city (id) MATCH FULL
);


create table if not exists Document
(
	id serial not null primary key,
	type varchar(45) not null,
	value varchar(100) not null,
	owner_id bigint not null,
	owner_type varchar(1) not null
);
create unique index document_unique on Document (type, value);



