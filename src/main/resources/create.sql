# SELECT GROUP_CONCAT(SCHEMA_NAME SEPARATOR ' ') as DBs FROM information_schema.SCHEMATA WHERE SCHEMA_NAME NOT IN ('mysql','information_schema','performance_schema','sys');

-- activitytracker
drop database if exists activitytracker;
create schema activitytracker;

drop user if exists 'activitytracker'@'%';
CREATE USER 'activitytracker'@'%' IDENTIFIED BY 'activitytracker';
GRANT ALL PRIVILEGES ON activitytracker.* TO 'activitytracker'@'%';


-- employees
drop database if exists employees;
create schema employees;

drop user if exists 'employees'@'%';
CREATE USER 'employees'@'%' IDENTIFIED BY 'employees';
GRANT ALL PRIVILEGES ON employees.* TO 'employees'@'%';


-- exam
drop database if exists exam;
create schema exam;

drop user if exists 'exam'@'%';
CREATE USER 'exam'@'%' IDENTIFIED BY 'exam';
GRANT ALL PRIVILEGES ON exam.* TO 'exam'@'%';


-- dictionary
drop database if exists dictionary;
create schema dictionary;

drop user if exists 'dictionary'@'%';
CREATE USER 'dictionary'@'%' IDENTIFIED BY 'dictionary';
GRANT ALL PRIVILEGES ON dictionary.* TO 'dictionary'@'%';


-- dogtypes
drop database if exists dogtypes;
create schema dogtypes;

drop user if exists 'dogtypes'@'%';
CREATE USER 'dogtypes'@'%' IDENTIFIED BY 'dogtypes';
GRANT ALL PRIVILEGES ON dogtypes.* TO 'dogtypes'@'%';


-- dogtypes
drop database if exists exam;
create schema exam;

drop user if exists 'exam'@'%';
CREATE USER 'exam'@'%' IDENTIFIED BY 'exam';
GRANT ALL PRIVILEGES ON exam.* TO 'exam'@'%';