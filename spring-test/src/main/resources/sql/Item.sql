create schema Test0;
create schema Audit;

create table Test0.Item (
id int identity(1,1) not null primary key,
code varchar(10) not null,
description varchar(50) null,
version int not null default 0,
modified datetime not null default CURRENT_TIMESTAMP,
modifiedby varchar(10) not null default user()
);

create table Audit.Item_Aud (
aud_id int identity(1,1) not null primary key,
id int not null,
code varchar(10),
description varchar(50) null,
version int null,
modified datetime null,
modifiedby varchar(10) null,
rev integer not null,
revtype smallint
);


CREATE TABLE Audit.Revinfo
(
	rev integer identity (1, 1) not null primary key,
	revtstmp bigint
);

/*
SCRIPT NODATA DROP TO 'schema-dev.sql'
SCRIPT COLUMNS TO 'data-dev.sql'
*/