Select 
    CASE
        WHEN id%2=1 AND id<(select max(id) from seat) then id+1
        when id%2=0 then id-1
        else id
    END AS id,
    student from Seat
    order by id