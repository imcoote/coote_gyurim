-- REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM (
    SELECT RI.*,
        RANK() OVER (PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC) AS RANKING -- RANKING 외우기
    FROM REST_INFO RI
)
WHERE RANKING = 1
ORDER BY FOOD_TYPE DESC