--CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고,
--대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여
--자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문을 작성해주세요.
--이때 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시해주시고 결과는 자동차 ID를 기준으로 내림차순 정렬해주세요.

SELECT CAR_ID,
    MAX(CASE
            WHEN TO_DATE('2022-10-16', 'YYYY-MM-DD') BETWEEN START_DATE AND END_DATE THEN '대여중'
            ELSE '대여 가능'
        END) AS AVAILABILITY -- 사전순으로 더 먼저인 요소('대여중' > '대여 가능')를 리턴
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;
