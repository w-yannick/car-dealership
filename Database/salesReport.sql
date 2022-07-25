use cardealershipDB;


SELECT CONCAT(u.FirstName, ' ', u.LastName) AS Name, sum(s.purchasePrice) As TotalSales, count(s.saleId) as TotalVehicules
FROM Sale s, User u
where s.userId = u.userId
AND u.userId LIKE "%"
AND date between "2000-01-01" AND "2022-07-01"
GROUP By u.FirstName, u.LastName
Order By TotalVehicules DESC