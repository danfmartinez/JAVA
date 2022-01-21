SELECT [Account Status], COUNT ([Account Status]) as [Cantidad Clientes]
FROM AccountStatus
INNER JOIN Client
ON AccountStatus.id = Client.idAccountStatus
GROUP BY [Account Status]
ORDER BY [Account Status] ASC
LIMIT 100;