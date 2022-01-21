SELECT Card
FROM Card 
lEFT JOIN ClientCard
ON Card.id = ClientCard.idCard
WHERE ClientCard.idCard IS NULL
ORDER by Card
LIMIT 100;