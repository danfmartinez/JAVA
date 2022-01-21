SELECT ([First Name] ||" " ||[Last Name]) as [Nombre y Apellido]
From Client
INNER JOIN ClientCard
ON Client.id = ClientCard.idClient
WHERE ClientCard.idCard like "%CC%"
GROUP by [Nombre y Apellido]
HAVING count(*) = 1
ORDER by [Nombre y Apellido] ASC
LIMIT 100;



