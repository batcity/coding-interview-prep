# Fix this

UPDATE Seat AS s1
JOIN Seat AS s2
  ON (s1.id % 2 = 1 AND s2.id = s1.id + 1)
  OR (s1.id % 2 = 0 AND s2.id = s1.id - 1)
SET s1.student = s2.student;

SELECT * FROM Seat;
