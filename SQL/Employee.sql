-- Create a new database called 'TestBase'
-- Connect to the 'master' database to run this snippet
USE master
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
    SELECT name
        FROM sys.databases
        WHERE name = N'TestBase'
)
CREATE DATABASE TestBase
GO

use TestBase
-- Create a new table called 'Employee' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('Employee', 'U') IS NOT NULL
DROP TABLE TestBase.Employee
GO
-- Create the table in the specified schema
CREATE TABLE Employee
(
    employee_id INT NOT NULL PRIMARY KEY, -- primary key column
    first_name NVARCHAR(50) NOT NULL,
    last_name NVARCHAR(50) NOT NULL,
    gender NVARCHAR(1) NOT NULL,
    position NVARCHAR(50) NOT NULL,
    department_id INT NOT NULL,
    salary INT NOT NULL
    -- specify more columns here
);
GO
-- Create a new table called 'Department' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('Department', 'U') IS NOT NULL
DROP TABLE TestBase.Department
GO
-- Create the table in the specified schema
CREATE TABLE Department
(
    department_id INT NOT NULL PRIMARY KEY, -- primary key column
    department_name NVARCHAR(50) NOT NULL
    -- specify more columns here
);
GO
-- Insert rows into table 'Employee'
INSERT INTO Employee
( -- columns to insert data into
 employee_id, first_name, last_name, gender, position, department_id, salary
)
VALUES
( -- first row: values for the columns in the list above
 2002, 'Super', 'Man', 'M', 'Tester', 1, 75000
),
( -- second row: values for the columns in the list above
 2003, 'Jessica', 'Liyers', 'F', 'Architect', 1, 60000),
-- add more rows here
(2004, 'Bonnie', 'Adams', 'F', 'Project Manager', 1, 80000),
(2005, 'James', 'Madson', 'M', 'Software Developer', 1, 55000),
(2006, 'Michael', 'Greenback', 'M', 'Sales Assistant', 2, 85000),
(2007, 'Laslie', 'Peters', 'F', 'SalesEngineer', 2, 76000),
(2008, 'Max', 'Powers', 'M', 'Sales Representative', 2, 59000),
(2009, 'Stacy', 'Jacobs', 'F', 'Sales Manager', 2, 73000),
(2010, 'John', 'Henery', 'M', 'Sales Director', 2, 90000)
GO
-- Insert rows into table 'Department'
INSERT INTO Department
( -- columns to insert data into
 department_id, department_name
)
VALUES
( -- first row: values for the columns in the list above
 1, 'IT'),
( -- second row: values for the columns in the list above
 2, 'Sales')
 GO