use fs_11_sql_class_revise;

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    city VARCHAR(50)
    -- Add other columns as needed
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_amount DECIMAL(10, 2),
    -- Add other columns as needed
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

select *
from customers


select *
from orders


INSERT INTO customers (customer_id, customer_name, city)
VALUES
    (1, 'John Doe', 'New York'),
    (2, 'Jane Smith', 'Los Angeles'),
    (3, 'Bob Johnson', 'Chicago');
-- Add more rows as needed

INSERT INTO customers (customer_id, customer_name, city)
VALUES
    (4, 'Arjun Doe', 'New York'),
    (5, 'Vishal Smith', 'Los Angeles'),
    (6, 'Pulkit Johnson', 'Chicago');


INSERT INTO orders (order_id, customer_id, order_amount)
VALUES
    (101, 1, 50.00),
    (102, 2, 75.50),
    (103, 1, 30.25),
    (104, 3, 100.00);
    
    
INSERT INTO orders (order_id, customer_id, order_amount)
VALUES
    (105, 4, 50.00),
    (106, 6, 75.50),
    (107, 4, 30.25),
    (108, 5, 100.00);
-- Add more rows as needed

##

select *
from customers
where customer_id in (2,3)

select customer_id
from orders
where order_amount> 50


select *
from customers
where customer_id in (

	select customer_id
	from orders
	where order_amount> 50
)

select *
from customers
where customer_id in (
	select customer_id from orders where order_amount = (
		
        select max(order_amount)
		from orders
	)
)



select customer_id,order_amount
from orders
where order_amount > 63.937500
 
 
select avg(order_amount)
from orders

select customer_id,order_amount
from orders
where order_amount > (
	select avg(order_amount)
	from orders
)

select city,count(*) as cnt_customers_per_city
from customers
group by city

select city,count(*) as cnt_customers_per_city
from customers left join orders
on customers.customer_id = orders.customer_id
where order_amount > (select avg(order_amount) 	from orders )
group by city

select *
from customers
order by customer_name desc


select *
from customers 
order by customer_name desc
limit 2


select top 2 *
from customers 
order by customer_name desc

select 'Mainak Ghosh' as name










