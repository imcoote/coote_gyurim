select CEIL(AVG(E.Salary) - AVG(
    TO_NUMBER(REPLACE(TO_CHAR(SALARY), '0', ''))
))
from EMPLOYEES E;
