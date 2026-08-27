# Write your MySQL query statement below
select d.name as Department,
       e.name as Employee,
       e.Salary as Salary
from Employee e
inner join Department d
on e.departmentId=d.id
where(
    select count(DISTINCT e2.Salary)
    from Employee e2
    where e2.departmentId=e.departmentId and e2.Salary>e.Salary
)<3;