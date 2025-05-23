SELECT CATEGORY, SUM(S.SALES) AS TOTAL_SALES
FROM BOOK B JOIN (
    SELECT *
    FROM BOOK_SALES
    WHERE TO_CHAR(SALES_DATE, 'yyyy-mm') = '2022-01'
) S ON B.BOOK_ID = S.BOOK_ID
GROUP BY CATEGORY
ORDER BY CATEGORY