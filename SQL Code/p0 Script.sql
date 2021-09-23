CREATE TABLE sector (
	sector_id serial,
	ai_codename TEXT,
	serv_location TEXT,
	PRIMARY KEY(sector_id)
);

CREATE TABLE industry (
	industry_type TEXT UNIQUE,
	industry_requirement int
);

CREATE TABLE production (
	sector_id_fk int,
	industry_type_fk TEXT,
	grid_id serial UNIQUE,
	h_assigned int DEFAULT 0,
	FOREIGN KEY (sector_id_fk) REFERENCES sector(sector_id),
	FOREIGN KEY (industry_type_fk) REFERENCES industry(industry_type),
	UNIQUE (sector_id_fk, industry_type_fk)
);

CREATE TABLE pod (
	pod_id serial,
	pod_count int,
	grid_id_fk int,
	FOREIGN KEY (grid_id_fk) REFERENCES production(grid_id)
);

INSERT INTO sector (ai_codename, serv_location)
VALUES ('Redwing', 'Turkey'), 
	   ('Dahlia', 'Mexico'),
	   ('Bluebell', 'Sweden'),
	   ('Edelweiss', 'Austria'),
	   ('Fireweed', 'Greenland'),
	   ('Taimen', 'Mongolia');
	  
INSERT INTO industry (industry_type, industry_requirement)
VALUES ('Manufacturing', 13400),
	   ('Mineral Extraction', 8430),
	   ('Lo-Tech', 6450),
	   ('Hi-Tech', 2500),
	   ('Agriculture', 4300),
	   ('General Services', 2300),
	   ('Labor Enforcement', 4800),
	   ('Human Entertainment', 1540),
	   ('Infrastructure', 16700),
	   ('"Research"', 34000),
	   ('F.U.N.', 6);

INSERT INTO production (industry_type_fk, sector_id_fk )
SELECT industry_type, sector_id FROM industry, sector;



DROP TABLE sector, industry, pod;
DROP TABLE industry;
DROP TABLE pod;
DROP TABLE production ;
SELECT * FROM sector;
SELECT * FROM industry;
SELECT * FROM production;
SELECT * FROM pod;
SELECT sector_id_fk, industry_type_fk, grid_id , h_assigned, industry.industry_requirement 
FROM production
JOIN industry ON industry_type_fk = industry.industry_type
ORDER BY sector_id_fk;
UPDATE pod SET pod_count = pod_count - 15
WHERE pod_id = (
	SELECT pod_id
	FROM pod
	WHERE grid_id_fk = 2
	LIMIT 1);
TRUNCATE TABLE sector CASCADE;
TRUNCATE TABLE industry CASCADE;
TRUNCATE TABLE production CASCADE;
SELECT sector_id_fk, industry_type_fk, grid_id , h_assigned, industry.industry_requirement,
 (industry.industry_requirement - production.h_assigned) AS Difference
FROM production
JOIN industry ON industry_type_fk = industry.industry_type
WHERE sector_id_fk = 3
ORDER BY sector_id_fk;
SELECT production.sector_id_fk, 
	   (industry.industry_requirement - production.h_assigned)
	   AS Difference FROM industry, production;