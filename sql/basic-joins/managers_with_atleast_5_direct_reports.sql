--- leetcode problem: https://leetcode.com/problems/managers-with-at-least-5-direct-reports/?envType=study-plan-v2&envId=top-sql-50
select e1.name from Employee e1
join Employee e2 ON e1.id = e2 .managerId 
group by e1.id having count(*)>4