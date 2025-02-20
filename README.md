# simple-ticket-management


## database configuration

```
create user ticket_mngt_db identified by 1234;

grant create session to ticket_mngt_db;

select tablespace_name from dba_tablespaces;

create tablespace ticket_mngt_tablespace datafile 'ticket_mngt_tablespace.data'  size 10M autoextend on;

create temporary tablespace ticket_mngt_tablespace_temp tempfile 'ticket_mngt_tablespace_temp.data' size 5M autoextend on;

drop user ticket_mngt_db;

create user ticket_mngt_db identified by 1234  default tablespace ticket_mngt_tablespace  temporary tablespace ticket_mngt_tablespace_temp;

grant create session to ticket_mngt_db;
grant create table to ticket_mngt_db;
grant unlimited tablespace to ticket_mngt_db;
grant create sequence to ticket_mngt_db;
```


```
docker run -d --name MY_ORACLE_DB -p 15211:1521 -p 9999:8080 -e ORACLE_SID=xe -e ORACLE_PWD=oracle -e ORACLE_CHARACTERSET=UTF8 -e ORACLE_HOME=/u01/app/oracle/product/12.2.0/SE/ --memory="2g" quay.io/maksymbilenko/oracle-12c
```

