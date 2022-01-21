SELECT Hometown, round(AVG (Age),2) as [Promedio Edad]
FROM Hometown
INNER JOIN Client
ON Hometown.idHometown = Client.idHometown
GROUP BY Hometown
HAVING [Promedio Edad] > 40
ORDER BY [Promedio Edad] DESC, Hometown ASC
LIMIT 100;