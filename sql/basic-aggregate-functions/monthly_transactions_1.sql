--- TODO: fix this script ---
select 
    Date_format(trans_date, '%Y-%m') as month,
    country,
    --- Total metrics ---
    count(*) as trans_count,
    sum(amount) as trans_total_amount,
    --- Approved metrics ---
    count(case when state='approved' then 1 end) as approved_count
from Transactions 
group by month, country