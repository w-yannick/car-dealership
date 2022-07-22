use cardealershipDB;

SELECT v.*, mo.name  
FROM Vehicule v, CarModel mo, Make ma 
WHERE v.CarModelId = mo.CarModelId  
AND mo.CarModelId = ma.makeId
AND type = "Used"
AND (
     mo.Name LIKE '%2%'
	 OR ma.name LIKE '%2%'
     OR year LIKE "%2%"
    )
 AND SalePrice BETWEEN 0 AND (SELECT MAX(SalePrice) FROM Vehicule)
 AND Year BETWEEN 0 AND (SELECT MAX(Year) FROM Vehicule);