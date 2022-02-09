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