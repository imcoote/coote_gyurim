SELECT DISTINCT CITY
FROM STATION
WHERE MOD(ID, 2) = 0; -- 오라클은 % 대신 MOD !