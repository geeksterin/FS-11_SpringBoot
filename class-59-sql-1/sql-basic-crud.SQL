create database fs_11_sql_class_revise;

use fs_11_sql_class_revise;

##create a Salesman table

CREATE TABLE salesmen (
    salesman_id INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50),
    commission DECIMAL(4, 2)
);

##insert data in Salesman table :

INSERT INTO salesmen (salesman_id, name, city, commission)
VALUES
    (5001, 'James Hoog', 'New York', 0.15),
    (5002, 'Nail Knite', 'Paris', 0.13),
    (5005, 'Pit Alex', 'London', 0.11),
    (5006, 'Mc Lyon', 'Paris', 0.14),
    (5007, 'Paul Adam', 'Rome', 0.13),
    (5003, 'Lauson Hen', 'San Jose', 0.12);
	
	
SELECT *
FROM salesmen
WHERE commission < 0.12 OR commission > 0.13

SELECT *, (100 * commission) as commission_percentage
FROM salesmen
WHERE commission < 0.12 OR commission > 0.13

DELETE
FROM salesmen
WHERE commission < 0.12 OR commission > 0.13

UPDATE salesmen
SET commission = 0.15
WHERE commission < 0.12 OR commission > 0.13
	
	
DROP fs_11_sql_class_revise;
