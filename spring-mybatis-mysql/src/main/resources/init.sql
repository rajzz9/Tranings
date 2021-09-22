CREATE TABLE users
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    salary float(10) DEFAULT NULL,
    createDate timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
    lastModified timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
    comment text,
    PRIMARY KEY (id)
);