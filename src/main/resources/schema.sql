CREATE TABLE IF NOT EXISTS brands (
  id INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS prices (
  brand_id INT NOT NULL,
  product_id INT NOT NULL,
  start_date TIMESTAMP(3) WITH TIME ZONE NOT NULL,
  end_date TIMESTAMP(3) WITH TIME ZONE NOT NULL,
  priority TINYINT NOT NULL,
  price DOUBLE PRECISION NOT NULL,
  price_list SMALLINT NOT NULL,
  curr CHAR(3) NOT NULL,
  FOREIGN KEY(brand_id) REFERENCES brands(id)
);

CREATE UNIQUE INDEX IF NOT EXISTS Prices_Composite_Key ON prices(brand_id, product_id, start_date, end_date, priority)
