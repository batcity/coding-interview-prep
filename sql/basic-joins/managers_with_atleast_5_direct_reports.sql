--- leetcode problem: https://leetcode.com/problems/managers-with-at-least-5-direct-reports/?envType=study-plan-v2&envId=top-sql-50
--- TODO: Fix this solution
select * from Employee e1, Employee e2 where e1.id=e2.managerId