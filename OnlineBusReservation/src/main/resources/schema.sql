DROP TABLE IF EXISTS bus;

CREATE TABLE bus (
	  bus_id INT AUTO_INCREMENT  PRIMARY KEY,
	  bus_no VARCHAR(250) NOT NULL,
	  source VARCHAR(250) NOT NULL,
	  destination VARCHAR(250) NOT NULL,
	  operator_name VARCHAR(250) DEFAULT NULL,
	  duration INT,
	  price DOUBLE,
	  departure_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);
   