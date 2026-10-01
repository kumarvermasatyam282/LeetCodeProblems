# Write your MySQL query statement below
-- select e.name,b.bonus 
-- from  Employee e
-- inner join Bonus b
-- on e.empid=b.empid
-- where b.bonus < 1000 or b.bonus is null;
    

SELECT e.name, b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empId = b.empId
WHERE b.bonus < 1000 OR b.bonus IS NULL;