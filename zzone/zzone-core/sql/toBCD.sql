# mysql 全角转半角函数

DELIMITER $$
CREATE FUNCTION `toDBC`(`string` varchar(255)) RETURNS varchar(255) CHARSET utf8
BEGIN
	DECLARE str VARCHAR(255);
	DECLARE min INT;
	DECLARE max INT;
	DECLARE len INT;
	DECLARE i INT;
	DECLARE c VARCHAR(1);
	
	SET str = string; 
	SET min = 15711361;
	SET max = 15711646;
	SET len = CHAR_LENGTH(str);
	SET i = 1;
	WHILE i <= len DO
		SET c = SUBSTRING(str, i, 1);
		IF ORD(c) >= min THEN
			IF ORD(c) <= max THEN
				SET str = REPLACE(str, c, CHAR(ORD(c) - 15711328));
			END IF;
		END IF;
		SET i = i + 1;
	END WHILE;
	RETURN str;
END $$
DELIMITER ;