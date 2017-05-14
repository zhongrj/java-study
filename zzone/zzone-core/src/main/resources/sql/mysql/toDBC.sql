# mysql 全角转半角函数

DROP FUNCTION IF EXISTS toDBC;
DELIMITER $$
CREATE FUNCTION `toDBC`(`string` varchar(255)) RETURNS varchar(255) CHARSET utf8
BEGIN
	DECLARE str VARCHAR(255);
	DECLARE min INT;
	DECLARE max INT;
	DECLARE len INT;
	DECLARE i INT;
	DECLARE c VARCHAR(1);
	DECLARE b INT;

	SET str = string;
	SET min = 65281;
	SET max = 65374;
	SET len = CHAR_LENGTH(str);
	SET i = 1;
	WHILE i <= len DO
		SET c = SUBSTRING(str, i, 1);
		SET b = ORD(CONVERT(c USING ucs2));
		IF b >= min THEN
			IF b <= max THEN
				SET str = REPLACE(str, c, CHAR(b - 65248));
			END IF;
		END IF;
		SET i = i + 1;
	END WHILE;
	RETURN str;
END $$
DELIMITER ;