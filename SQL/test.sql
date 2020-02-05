use TestBase

select * from Employee
select * from Department

/*return employee record with max salary*/
select * from Employee 
where salary = (select Max(salary) from Employee)

/*select highest salary in employee table*/
select Max(salary) from Employee

/*select 2nd highest salary in employee table*/
select Max(salary) from Employee
where salary Not In (select Max(salary) from Employee)

/*select range of employee based on id*/
select * from Employee
where employee_id between 2003 and 2008

/*return employee name, highest salary and department*/
select e.first_name, e.last_name, e.salary, d.department_name
from Employee e Inner Join Department d ON (e.department_id = d.department_id)

select e.first_name, e.last_name, e.salary, d.department_name
from Employee e Inner Join Department d ON (e.department_id = d.department_id)
where salary IN (select Max(salary) from Employee)

/*return higest salary, employee name, department name for each department*/
select e.first_name, e.last_name, e.salary, d.department_name
from Employee e Inner Join Department d ON (e.department_id = d.department_id)
where salary IN (select Max(salary) from Employee group by department_id)
