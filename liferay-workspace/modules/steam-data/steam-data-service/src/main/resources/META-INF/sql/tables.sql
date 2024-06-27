create table Liferay_Game (
	appId LONG not null primary key,
	publisherId VARCHAR(75) null,
	title VARCHAR(75) null,
	releaseDate DATE null,
	price DOUBLE,
	aboutDescription VARCHAR(75) null
);

create table Liferay_Publisher (
	uuid_ VARCHAR(75) null,
	publisherId VARCHAR(75) not null primary key,
	publisherName VARCHAR(75) null,
	linkWebsite VARCHAR(75) null,
	publisherInfo VARCHAR(75) null
);