-- Create employees table
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100),
    department_id INT,
    salary DECIMAL(8, 2),
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- Insert sample data into employees table
INSERT INTO employees VALUES
    (1, 'John Doe', 1, 60000.00),
    (2, 'Jane Smith', 2, 55000.50),
    (3, 'Bob Johnson', 1, 70000.75),
    (4, 'Alice Brown', 3, 50000.25);

-- Create departments table
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50)
);

-- Insert sample data into departments table
INSERT INTO departments VALUES
    (1, 'HR'),
    (2, 'IT'),
    (3, 'Marketing');

-- Sample questions for practicing joins

-- Question 1: Retrieve a list of employees with their department information.
SELECT
    employees.employee_id,
    employees.employee_name,
    employees.department_id,
    departments.department_name
FROM
    employees
JOIN
    departments ON employees.department_id = departments.department_id;

-- Question 2: Retrieve a list of employees along with their department information, including those without a department.
SELECT
    employees.employee_id,
    employees.employee_name,
    employees.department_id,
    departments.department_name
FROM
    employees
LEFT JOIN
    departments ON employees.department_id = departments.department_id;

-- Question 3: Retrieve a list of departments along with the total salary of all employees in each department.
SELECT
    departments.department_id,
    departments.department_name,
    SUM(employees.salary) AS total_salary
FROM
    departments
LEFT JOIN
    employees ON departments.department_id = employees.department_id
GROUP BY
    departments.department_id, departments.department_name;

-- Question 4: Retrieve a list of employees and their departments, including departments with no employees.
SELECT
    employees.employee_id,
    employees.employee_name,
    employees.department_id,
    departments.department_name
FROM
    employees
RIGHT JOIN
    departments ON employees.department_id = departments.department_id;

-- Question 5: Retrieve a list of employees who have a salary greater than $60000 and their corresponding department information.
SELECT
    employees.employee_id,
    employees.employee_name,
    employees.department_id,
    departments.department_name
FROM
    employees
JOIN
    departments ON employees.department_id = departments.department_id
WHERE
    employees.salary > 60000;

-- Question 6: Retrieve a list of employees and their managers, if applicable.
SELECT
    e.employee_id,
    e.employee_name,
    e.manager_id,
    m.employee_name AS manager_name
FROM
    employees e
LEFT JOIN
    employees m ON e.manager_id = m.employee_id;

-- Question 7: Retrieve a list of departments with the number of employees in each department.
SELECT
    departments.department_id,
    departments.department_name,
    COUNT(employees.employee_id) AS num_employees
FROM
    departments
LEFT JOIN
    employees ON departments.department_id = employees.department_id
GROUP BY
    departments.department_id, departments.department_name;

-- Question 8: Retrieve a list of employees who do not belong to any department.
SELECT
    employees.employee_id,
    employees.employee_name
FROM
    employees
LEFT JOIN
    departments ON employees.department_id = departments.department_id
WHERE
    departments.department_id IS NULL;

-- Question 9: Retrieve a list of employees who have the same salary as their managers.
SELECT
    e.employee_id,
    e.employee_name,
    e.salary,
    m.employee_id AS manager_id,
    m.employee_name AS manager_name,
    m.salary AS manager_salary
FROM
    employees e
JOIN
    employees m ON e.manager_id = m.employee_id AND e.salary = m.salary;

-- Question 10: Retrieve a list of employees and their departments, showing "No Department" for employees without a department.
SELECT
    employees.employee_id,
    employees.employee_name,
    COALESCE(departments.department_name, 'No Department') AS department_name
FROM
    employees
LEFT JOIN
    departments ON employees.department_id = departments.department_id;

