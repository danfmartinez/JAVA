SELECT Career, COUNT(Career) As [Cantidad Clientes]
FROM Client
GROUP BY Career
ORDER BY [Cantidad Clientes] DESC, Career ASC
LIMIT 100;