# Write your MySQL query statement below
SELECT e.name as Employee 
from Employee e 
LEFT JOIN Employee f 
ON e.managerID = f.id 
WHERE e.salary>f.salary;