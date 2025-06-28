SELECT MAX(salary * months) as earnings, count(*)
FROM Employee
WHERE salary * months = (
    SELECT MAX(months * salary)
    FROM employee
);