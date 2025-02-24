# simple-ticket-management


## Introduction

## Versions

- Java 17
- Maven 3.9.9
- Spring Boot 3.4.2
- JUnit 5

## ERD

![image info](./img/simple_ticket_management_ERD.svg)

## database configuration

The script is avalaible from [this location](./simple-ticket-management-database/script.sql).

Create a Docker container to run an Oracle 12c instance:

```
docker run -d --name TICKET_MANAGEMENT_DB -p 1521:1521  -e ORACLE_SID=xe -e ORACLE_PWD=oracle -e ORACLE_CHARACTERSET=UTF8 -e ORACLE_HOME=/u01/app/oracle/product/12.2.0/SE/ --memory="2g" quay.io/maksymbilenko/oracle-12c
```

Once created, use an Oracle database client like SQL developer and connect with following credentials:

- Login: sys as dba
- Password: oracle

Once connected, execute the following instructions:

```

create tablespace ticket_mngt_tablespace datafile 'ticket_mngt_tablespace.data'  size 10M autoextend on;

create user ticket_mngt_db identified by 1234  default tablespace ticket_mngt_tablespace;

grant create session to ticket_mngt_db;

grant create session to ticket_mngt_db;
grant create table to ticket_mngt_db;
grant unlimited tablespace to ticket_mngt_db;
grant create sequence to ticket_mngt_db;
```

Connect to ticket_mngt_db user.

## Backend Configuration

Before launching the backend module, make sure to execute mvn install against because MapStruct needs to generate mapper objects.

## Observations

As a software engineering observation, H2 database was used for testing purposes, for simplicity reasons. It is not a recommended practice since the test database should be identical to main database.

