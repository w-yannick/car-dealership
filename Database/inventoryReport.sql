use cardealershipDB;

-- Select * from vehicule 
SELECT  v.year,ma.name as make,mo.name as model , count(v.vehiculeId) as count,SUM(v.MSRP) as stockValue
FROM Vehicule v, CarModel mo, Make ma
WHERE v.carModelId = mo.carModelId
AND mo.makeId = ma.makeId
AND v.available = true
AND v.type = "Used"
Group by v.year, ma.name, mo.name
Order by make