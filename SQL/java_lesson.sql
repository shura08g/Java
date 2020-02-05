-- CREATE DATABASE JAVA_LESSON;
-- DROP DATABASE JAVA_LESSON;
-- USE JAVA_LESSON;

-- DROP TABLE IF EXISTS machines;
-- DROP TABLE IF EXISTS details;

CREATE TABLE `machines` (
    `id` INT(11) NOT NULL PRIMARY KEY,
    `name` VARCHAR(64) NOT NULL
);
INSERT INTO machines (id, name) VALUES (1, 'machine-1');
INSERT INTO machines (id, name) VALUES (2, 'machine-2');
INSERT INTO machines (id, name) VALUES (3, 'machine-3');

CREATE TABLE `details` (
    `id` INT(11) NOT NULL PRIMARY KEY,
    `mass` INT(11) NOT NULL
);
                      
INSERT INTO details (id, mass) VALUES (10, 1000);
INSERT INTO details (id, mass) VALUES (20, 2000);
INSERT INTO details (id, mass) VALUES (30, 3000);

CREATE TABLE `md` (
    `m_id` INT(11) NOT NULL,
    `d_id` INT(11) NOT NULL,
    FOREIGN KEY (m_id)
        REFERENCES machines (id),
    FOREIGN KEY (d_id)
        REFERENCES details (id)
);
                   
INSERT INTO md (m_id, d_id) VALUES (1, 20);
INSERT INTO md (m_id, d_id) VALUES (1, 30);
INSERT INTO md (m_id, d_id) VALUES (2, 10);
INSERT INTO md (m_id, d_id) VALUES (2, 30);
INSERT INTO md (m_id, d_id) VALUES (3, 10);
INSERT INTO md (m_id, d_id) VALUES (3, 20);

SELECT id, name FROM machines
WHERE id IN 
	(SELECT m_id FROM md
    WHERE d_id IN
		(SELECT id FROM details
        WHERE mass = 2000));
        
SELECT machines.name, md.d_id
FROM machines INNER JOIN md
ON machines.id = md.m_id;

SELECT machines.name, details.mass
FROM machines INNER JOIN md INNER JOIN details
ON machines.id = md.m_id AND md.d_id = details.id;

SELECT *
FROM machines INNER JOIN md INNER JOIN details
ON machines.id = md.m_id AND md.d_id = details.id;

-- 1. all tables
SELECT * FROM machines;

-- 2. projection
SELECT name FROM machines;

SELECT name AS NAME, id AS ID, id * 3 AS TRIPLE_ID FROM machines;

SELECT name, '000' AS passID FROM machines;

-- 3. slection
SELECT * FROM machines
WHERE id > 1;

SELECT name FROM machines
WHERE id = 1 OR id = 2;

-- 4. union  обьеденит таблици (без дубликатов)
(SELECT * FROM machines
WHERE id = 1)
UNION
(SELECT * FROM machines
WHERE id = 2);

SELECT name FROM machines
WHERE id = 1
UNION
SELECT name FROM machines
WHERE id = 2;

SELECT name FROM machines
WHERE id > 1
UNION
SELECT name FROM machines
WHERE id < 3;

-- 5. IN
SELECT name FROM machines
WHERE id IN  (1, 2);

-- explain
explain select name from machines
WHERE id = 1
union
select name from machines
WHERE id = 3;
