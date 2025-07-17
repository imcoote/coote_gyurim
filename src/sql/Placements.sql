select s.name
from Students s
join Friends f on s.id = f.id
join Packages sp on s.id = sp.id
join Packages fp on f.friend_id = fp.id
where sp.Salary < fp.Salary
order by fp.Salary;