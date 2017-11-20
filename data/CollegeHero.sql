-- Tables

DROP DATABASE IF EXISTS CollegeHero;
CREATE DATABASE CollegeHero;
USE CollegeHero;

DROP TABLE IF EXISTS student;
CREATE TABLE student
(
  sID      INT PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(255)  NOT NULL,
  password VARCHAR(60)   NOT NULL,
  sex      BOOLEAN,
  phone    VARCHAR(10) UNIQUE,
  tuition  INT DEFAULT 0 NOT NULL
);

DROP TABLE IF EXISTS room;
CREATE TABLE room
(
  rID        INT PRIMARY KEY AUTO_INCREMENT,
  roomNumber INT,
  building   VARCHAR(45)
);

DROP TABLE IF EXISTS department;
CREATE TABLE department
(
  dID    INT PRIMARY KEY AUTO_INCREMENT,
  office INT,
  title  VARCHAR(45) NOT NULL,
  FOREIGN KEY (office) REFERENCES room (rID)
);

DROP TABLE IF EXISTS staff;
CREATE TABLE staff
(
  tID         INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(255) NOT NULL,
  password    VARCHAR(60)  NOT NULL,
  department  INT,
  staffTypeID BOOLEAN,
  phone       VARCHAR(10),
  FOREIGN KEY (department) REFERENCES department (dID)
);

DROP TABLE IF EXISTS class;
CREATE TABLE class
(
  cID      INT PRIMARY KEY AUTO_INCREMENT,
  section  INT         NOT NULL,
  subject  VARCHAR(45) NOT NULL,
  tID      INT,
  rID      INT,
  days     VARCHAR(15),
  start_at TIME,
  end_at   TIME,
  capacity INT         NOT NULL,
  cost     INT         NOT NULL,
  FOREIGN KEY (tID) REFERENCES staff (tID),
  FOREIGN KEY (rID) REFERENCES room (rID)
);

DROP TABLE IF EXISTS enrolled;
CREATE TABLE enrolled
(
  sID INT,
  cID INT,
  PRIMARY KEY (sID, cID),
  FOREIGN KEY (sID) REFERENCES student (sID),
  FOREIGN KEY (cID) REFERENCES class (cID)
);

DROP TABLE IF EXISTS attendance;
CREATE TABLE attendance
(
  sID INT,
  cID INT,
  day DATE,
  PRIMARY KEY (sID, cID, day),
  FOREIGN KEY (sID) REFERENCES student (sID),
  FOREIGN KEY (cID) REFERENCES class (cID)
);

-- Procedures

DELIMITER //

DROP PROCEDURE IF EXISTS getStudentByID//
CREATE PROCEDURE getStudentByID(IN ID INT)
  BEGIN
    SELECT *
    FROM student
    WHERE sID = ID;
  END//

DROP PROCEDURE IF EXISTS getStudentPasswordByID//
CREATE PROCEDURE getStudentPasswordByID(IN ID INT, OUT pass VARCHAR(60))
  BEGIN
    SELECT password
    INTO pass
    FROM student
    WHERE sID = ID;
  END//

DROP PROCEDURE IF EXISTS getStaffByID//
CREATE PROCEDURE getStaffByID(IN ID INT)
  BEGIN
    SELECT *
    FROM staff
    WHERE tID = ID;
  END//

DROP PROCEDURE IF EXISTS getStaffPasswordByID//
CREATE PROCEDURE getStaffPasswordByID(IN ID INT, OUT pass VARCHAR(60))
  BEGIN
    SELECT password
    INTO pass
    FROM staff
    WHERE tID = ID;
  END//

DROP PROCEDURE IF EXISTS getStudentIDByPhone//
CREATE PROCEDURE getStudentIDByPhone(IN phone VARCHAR(10))
  BEGIN
    SELECT
      sID,
      student.name,
      student.phone
    FROM student
    WHERE student.phone = phone;
  END//

DROP PROCEDURE IF EXISTS getStaffIDByPhone//
CREATE PROCEDURE getStaffIDByPhone(IN phone VARCHAR(10))
  BEGIN
    SELECT
      tID,
      staff.name,
      staff.phone
    FROM staff
    WHERE staff.phone = phone;
  END//

DROP PROCEDURE IF EXISTS createStudent//
CREATE PROCEDURE createStudent(IN  name VARCHAR(255), IN password VARCHAR(60), IN sex BOOLEAN, IN phone VARCHAR(10),
                               OUT ID   VARCHAR(255))
  BEGIN
    INSERT INTO student VALUES (NULL, name, password, sex, phone, 0);
    SELECT student.sID
    INTO ID
    FROM student
    WHERE phone = student.phone;
  END//

DROP PROCEDURE IF EXISTS createStaff//
CREATE PROCEDURE createStaff
  (IN name VARCHAR(255), IN password VARCHAR(60), IN department INT, IN staffType INT, IN phone VARCHAR(10))
  BEGIN
    INSERT INTO staff VALUES (NULL, name, password, department, staffType, phone);
  END//

DROP PROCEDURE IF EXISTS getAllSectionInfoByClassID;
CREATE PROCEDURE getAllSectionInfoByID(IN ID VARCHAR(45))
  BEGIN
    SELECT *
    FROM class
    WHERE class.cID = ID;
  END//

DROP PROCEDURE IF EXISTS getAllSectionInfoBySubject//
CREATE PROCEDURE getAllSectionInfoBySubject(IN subject VARCHAR(45))
  BEGIN
    SELECT *
    FROM class
    WHERE class.subject = subject;
  END//

DROP PROCEDURE IF EXISTS getStudentSchedule//
CREATE PROCEDURE getStudentSchedule(IN sID INT)
  BEGIN
    SELECT *
    FROM class
    WHERE class.cID IN (SELECT enrolled.cID
                        FROM enrolled
                        WHERE enrolled.sID = sID);
  END//

DROP PROCEDURE IF EXISTS getStaffSchedule//
CREATE PROCEDURE getStaffSchedule(IN tID INT)
  BEGIN
    SELECT *
    FROM class
    WHERE class.tID = tID;
  END //

DROP PROCEDURE IF EXISTS logAttendance//
CREATE PROCEDURE logAttendance(IN sID INT, IN cID INT, IN classDay DATE)
  BEGIN
    INSERT INTO attendance
    VALUES (sID, cID, classDay);
  END//

DROP PROCEDURE IF EXISTS enrollInClass//
CREATE PROCEDURE enrollInClass(IN sID INT, IN cID INT)
  BEGIN
    INSERT INTO enrolled
    VALUES (sID, cID);
  END//

DROP PROCEDURE IF EXISTS unEnrollInClass//
CREATE PROCEDURE unEnrollInClass(IN sID INT, IN cID INT)
  BEGIN
    DELETE FROM enrolled
    WHERE enrolled.sID=sID
    AND enrolled.cID=cID;
  END//

DROP PROCEDURE IF EXISTS payTuition//
CREATE PROCEDURE payTuition(IN sID INT, IN amount INT)
  BEGIN
    UPDATE student
    SET tuition=tuition-amount
    WHERE student.sID=sID;
  END//

DROP PROCEDURE IF EXISTS getStaffByName//
CREATE PROCEDURE getStaffByName(IN staffName VARCHAR(255))
  BEGIN
    SELECT staff.tID, staff.name, staff.department, staff.phone, staff.staffTypeID
    FROM staff
    WHERE staff.name=staffName;
  END//

DROP PROCEDURE IF EXISTS getStaffByDepartment//
CREATE PROCEDURE getStaffByDepartment(IN department VARCHAR(255))
  BEGIN
    SELECT staff.tID, staff.name, staff.department, staff.phone, staff.staffTypeID
    FROM staff
    WHERE staff.department=department;
  END//

DROP PROCEDURE IF EXISTS getStaffByType//
CREATE PROCEDURE getStaffByType(IN type BOOLEAN)
  BEGIN
    SELECT staff.tID, staff.name, staff.department, staff.phone, staff.staffTypeID
    FROM staff
    WHERE staff.staffTypeID=type;
  END//

DROP PROCEDURE IF EXISTS changeStudentPhone//
CREATE PROCEDURE changeStudentPhone(IN sID INT, IN phone VARCHAR(10))
  BEGIN
    UPDATE student
    SET student.phone=phone
    WHERE student.sID=sID;
  END //

DROP PROCEDURE IF EXISTS changeStudentPassword//
CREATE PROCEDURE changeStudentPassword(IN sID INT, IN pwd VARCHAR(60))
  BEGIN
    UPDATE student
    SET student.password=pwd
    WHERE student.sID=sID;
  END //

-- Triggers

DROP TRIGGER IF EXISTS increaseTuition//
CREATE TRIGGER increaseTuition
BEFORE INSERT ON enrolled
FOR EACH ROW
  BEGIN
    UPDATE student
    SET tuition = tuition + (SELECT cost
                             FROM class
                             WHERE cID = new.cID)
    WHERE student.sID = new.sID;
  END//

DROP TRIGGER IF EXISTS lowerTuition//
CREATE TRIGGER lowerTuition
BEFORE DELETE ON enrolled
FOR EACH ROW
  BEGIN
    UPDATE student
    SET tuition = tuition - (SELECT cost
                             FROM class
                             WHERE cID = old.cID)
    WHERE student.sID = old.sID;
  END//

DROP TRIGGER IF EXISTS checkCapacity//
CREATE TRIGGER checkCapacity
BEFORE INSERT ON enrolled
FOR EACH ROW
  BEGIN
    IF (SELECT COUNT(enrolled.cID)
        FROM enrolled
        WHERE enrolled.cID = new.cID
        GROUP BY cID)
       =
       (SELECT capacity
        FROM class
        WHERE class.cID = new.cID)
    THEN SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = "That class is at full capacity";
    END IF;
  END//

DELIMITER ;

-- Data sources

LOAD DATA LOCAL INFILE 'students.csv'
INTO TABLE student
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'room.csv'
INTO TABLE room
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'department.csv'
INTO TABLE department
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'staff.csv'
INTO TABLE staff
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

LOAD DATA LOCAL INFILE 'class.csv'
INTO TABLE class
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;
