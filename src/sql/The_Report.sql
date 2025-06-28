SELECT
    CASE WHEN G.Grade <= 7 THEN 'NULL' ELSE S.Name END as Name, G.Grade, S.Marks
FROM Students S LEFT JOIN Grades G
ON S.Marks BETWEEN G.Min_Mark AND G.Max_Mark
ORDER BY G.Grade Desc, Name, S.Marks;