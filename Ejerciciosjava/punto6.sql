SELECT 
SUBSTR(Client.mail,1,INSTR(Client.mail,"@")-1) as Direccion,
UPPER(SUBSTR(Client.mail,INSTR(Client.mail,"@")+1,INSTR(Client.mail,".com")-INSTR(Client.mail,"@")-1)) as Dominio,
Hometown
FROM Client
INNER JOIN Hometown
ON Hometown.idHometown = Client.idHometown
ORDER By Direccion ASC
LIMIT 100;
