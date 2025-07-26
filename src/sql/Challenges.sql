-- 문제 조건:
-- 1) 동일한 챌린지 수를 가진 학생이 2명 이상 존재하고
-- 2) 해당 챌린지 수가 최대 챌린지 수보다 작다면
-- 결과에서 제외 !!
SELECT h.hacker_id, h.name, COUNT(c.challenge_id) AS total_challenges
FROM Hackers h
JOIN Challenges c ON h.hacker_id = c.hacker_id
GROUP BY h.hacker_id, h.name
HAVING COUNT(c.challenge_id) = ( -- 챌린지를 가장 많이 만든 학생인 경우
    SELECT MAX(cnt)
    FROM (
        SELECT COUNT(*) AS cnt
        FROM Challenges
        GROUP BY hacker_id
    )
)
OR COUNT(c.challenge_id) IN ( -- 같은 수를 만든 사람이 1명인 경우
    SELECT challenge_count
    FROM (
        SELECT COUNT(*) AS challenge_count, hacker_id
        FROM Challenges
        GROUP BY hacker_id
    )
    GROUP BY challenge_count
    HAVING COUNT(*) = 1
)
ORDER BY total_challenges DESC, h.hacker_id;