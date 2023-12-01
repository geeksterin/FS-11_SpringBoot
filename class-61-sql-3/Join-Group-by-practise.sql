use fs_11_sql_class_revise;

SELECT *
FROM salesmen
where commission = 0.13 
OR commission = 0.12 
OR commission = 0.17
OR commission = 0.18
OR commission = 0.19
OR commission = 0.11

SELECT *
FROM salesmen
where commission not IN (0.13,0.12,0.17,0.18,0.11)

SELECT *
FROM salesmen
where commission != 0.13 or commission != 0.12

update salesmen
set city  = 'New York'
where city = 'San Jose'


select city,count(*) as num_salesmen_in_city
from Salesmen
group by city 

select city,salesman_id
from Salesmen
group by city ## this is wrong

select city,salesman_id
from Salesmen
group by city,salesman_id


select count(*)
from salesmen


select city,count(*) as num_salesmen_in_city
from Salesmen
group by city 
having count(*) > 3

select city,max(commission) as max_commission_in_city
from Salesmen
group by city 

select city,avg(commission) as min_commission_in_city
from Salesmen
group by city 
having avg(commission) > 0.14

## join ###


CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100),
    department_id INT,
    salary DECIMAL(8, 2)
);

-- Insert sample data into employees table
INSERT INTO employee VALUES
    (1, 'Pulkit', 1, 60000.00),
    (2, 'Deepak', 2, 55000.50),
    (3, 'Vishal', 1, 70000.75),
    (4, 'Masum', 3, 50000.25);
    
    
INSERT INTO employee VALUES
(5, 'Sujit', 9, 65000.00)
    


-- Create departments table
CREATE TABLE department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50)
);

-- Insert sample data into departments table
INSERT INTO department VALUES
    (1, 'HR'),
    (2, 'IT'),
    (3, 'Marketing');
    
INSERT INTO department VALUES
(4, 'Sales')

INSERT INTO department VALUES
(5, 'Devops')
    
    
   ## data ready for employees and departments table "4
   
select *
from employee

select *
from department


select *
from employee join department
on employee.department_id = department.department_id
where salary > 60000


select employee_name,department.*
from employee join department
on employee.department_id = department.department_id


select department.department_id,department.department_name,sum(salary)
from employee join department
on employee.department_id = department.department_id
group by department.department_id,department.department_name


select *
from employee left join department
on employee.department_id = department.department_id

select *
from department  left join employee
on employee.department_id = department.department_id


select department.department_id,department.department_name,sum(salary)
from department left join employee
on employee.department_id = department.department_id
group by department.department_id,department.department_name


select *
from employee join department on employee.department_id = department.department_id
where salary > 60000

select department.department_id,department.department_name,count(employee_id) as count_emp
from department left join employee
on employee.department_id = department.department_id
group by department.department_id,department.department_name


select employee.*
from employee left join department
on employee.department_id = department.department_id
where department.department_id is null

select employee_id, 
employee_name, 
case
	when (department_name is null) then 'Ghatiya'
    else department_name
end as custom_dept_col
from employee left join department
on employee.department_id = department.department_id


select *
from employee
where employee_name like '%ee'









