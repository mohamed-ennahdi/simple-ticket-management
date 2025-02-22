CREATE TABLE "TICKET_MNGT_DB"."USER_EMPLOYEE" (
	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"LOGIN" VARCHAR2(255 CHAR), 
	"PWD" VARCHAR2(255 CHAR), 
	"ROLE" VARCHAR2(255 CHAR), 
	 UNIQUE ("LOGIN"),
	 CHECK (role in ('EMPLOYEES','IT_SUPPORT')) ENABLE, 
	 PRIMARY KEY ("ID") 
);

CREATE TABLE "TICKET_MNGT_DB"."TICKET" (
	"CREATION_DATE" DATE, 
	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"USER_EMPLOYEE_ID" NUMBER(19,0), 
	"CATEGORY" VARCHAR2(255 CHAR), 
	"DESCRIPTION" VARCHAR2(255 CHAR), 
	"PRIORITY" VARCHAR2(255 CHAR), 
	"TITLE" VARCHAR2(255 CHAR), 
	 CHECK (category in ('NETWORK','HARDWARE','SOFTWARE','OTHER')) ENABLE, 
	 CHECK (priority in ('LOW','MEDIUM','HIGH')) ENABLE,
	 CONSTRAINT "FKFB50GV7NLPYCO2YCCR7UROIS7" FOREIGN KEY ("USER_EMPLOYEE_ID") REFERENCES "TICKET_MNGT_DB"."USER_EMPLOYEE" ("ID") ENABLE,
	 PRIMARY KEY ("ID")
);

CREATE TABLE "TICKET_MNGT_DB"."TICKET_COMMENT" (
	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"TICKET_ID" NUMBER(19,0), 
	"TEXT" VARCHAR2(255 CHAR),
	 CONSTRAINT "FKCF0TWFU7B4ACGTU1AUDFBEM60" FOREIGN KEY ("TICKET_ID") REFERENCES "TICKET_MNGT_DB"."TICKET" ("ID") ENABLE,
	 PRIMARY KEY ("ID")
);

CREATE TABLE "TICKET_MNGT_DB"."TICKET_STATUS" (
	"ASSIGNMENT_DATE" DATE, 
	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"TICKET_ID" NUMBER(19,0), 
	"STATUS" VARCHAR2(255 CHAR), 
	 CHECK (status in ('NEW','IN_PROGRESS','RESOLVED')) ENABLE,
	 CONSTRAINT "FKC5CRR2KJUP6SO4CFOSLPC0A5L" FOREIGN KEY ("TICKET_ID")  REFERENCES "TICKET_MNGT_DB"."TICKET" ("ID") ENABLE,
	 PRIMARY KEY ("ID")
);


INSERT INTO "TICKET_MNGT_DB"."USER_EMPLOYEE" (ID, LOGIN, PWD, ROLE) VALUES ('1', 'user1', 'pass1', 'EMPLOYEES');
INSERT INTO "TICKET_MNGT_DB"."USER_EMPLOYEE" (ID, LOGIN, PWD, ROLE) VALUES ('2', 'user2', 'pass2', 'IT_SUPPORT');

INSERT INTO "TICKET_MNGT_DB"."TICKET" (ID, CATEGORY, CREATION_DATE, DESCRIPTION, PRIORITY, TITLE, USER_EMPLOYEE_ID) VALUES ('1', 'SOFTWARE', TO_DATE('2025-02-20 20:55:39', 'YYYY-MM-DD HH24:MI:SS'), 'Develop a simple ticket management application that allows employees to report and track IT issues.', 'HIGH', 'IT Support Ticket Implementation', '1');

INSERT INTO "TICKET_MNGT_DB"."TICKET_STATUS" (ID, ASSIGNMENT_DATE, STATUS, TICKET_ID) VALUES ('1', TO_DATE('2025-02-21 09:19:47', 'YYYY-MM-DD HH24:MI:SS'), 'NEW', '1');
INSERT INTO "TICKET_MNGT_DB"."TICKET_STATUS" (ID, ASSIGNMENT_DATE, STATUS, TICKET_ID) VALUES ('2', TO_DATE('2025-02-21 09:20:29', 'YYYY-MM-DD HH24:MI:SS'), 'IN_PROGRESS', '1');
INSERT INTO "TICKET_MNGT_DB"."TICKET_STATUS" (ID, ASSIGNMENT_DATE, STATUS, TICKET_ID) VALUES ('3', TO_DATE('2025-02-21 09:21:04', 'YYYY-MM-DD HH24:MI:SS'), 'RESOLVED', '1');
