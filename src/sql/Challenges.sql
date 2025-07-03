select count(*)
from Hackers H join Challenges C
on H.hacker_id = C.hacker_id
group by H.hacker_id;

-- ✅ 가장 많은 챌린지를 만든 학생을 제외한 나머지 중, 총 개수가 같은 학생은 결과에서 제외
-- 이 조건 어떻게 걸지??