
TRUNCATE TABLE `transaction`;

TRUNCATE TABLE `friend`;

TRUNCATE TABLE `pmbuser`;

INSERT INTO `pmbuser` VALUES 
	(1,'A@A','Alice','$2a$10$hHjGSpRNixfmfVVyBwLX5e8xNZ29Lajm8u0C97diHhnYTfP/TwJjm',6159),
	(2,'B@B','Bob','$2a$10$EPW6XiZyrSho6dmwz.DXqeWdQz9lBdija2RECGpPVeGwZ89S3PPee',19227),
	(3,'D@D','Delphine','$2a$10$VTW3l5YxnxgYI3F4y9MoqOeGQhFDPj6eh1x4ZjYAiGRHDuq0zXTg2',4967),
	(5,'C@C','Charlie','$2a$10$Zt1SQZXvgOPpDB0.MAvrMePA4LqqBHfceDGklUM/iiUK9o0VpSfou',5492);

INSERT INTO `friend` VALUES 
	(1,2,1),
	(3,1,2),
	(5,5,1),
	(6,5,2),
	(8,5,3),
	(9,2,5),
	(10,2,3),
	(11,1,5),
	(12,1,3),
	(13,3,1),
	(14,3,2),
	(15,3,5);

INSERT INTO `transaction` VALUES 
	(1,1,'2023-12-06 11:30:29',3100,16,''),
	(3,3,'2023-12-06 11:48:22',3900,20,''),
	(5,3,'2023-12-13 10:30:58',400,2,'Pour tacos'),
	(6,5,'2023-12-15 11:58:50',1000,5,'Secret Santa'),
	(7,6,'2023-12-15 11:59:02',1000,5,'Secret Santa'),
	(8,8,'2023-12-15 11:59:17',1000,5,'Secret Santa'),
	(9,5,'2023-12-15 11:59:35',2000,10,'Pizza'),
	(10,10,'2023-12-15 12:01:04',2000,10,'Flowers'),
	(11,13,'2023-12-15 12:56:11',2000,10,'Thanks !'),
	(12,14,'2023-12-15 12:56:38',5000,25,'Alice\'s birthday'),
	(13,15,'2023-12-15 12:56:55',100,1,'Tips'),
	(14,15,'2023-12-15 12:57:38',400,2,'Chocolat'),
	(15,11,'2023-12-15 12:58:15',1000,5,''),
	(16,12,'2023-12-15 12:58:26',1500,8,'Books'),
	(17,8,'2023-12-15 13:05:09',1000,5,'Secret Santa');

commit;
