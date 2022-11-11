-- Agregar datos a la BBDD BRANDS
INSERT INTO brands (id, name) VALUES (1, 'Zara');

-- Agregar datos a la BBDD PRICES
INSERT INTO prices
  (brand_id, product_id, start_date, end_date, priority, price, price_list, curr)
  VALUES
  (1, 35455, TIMESTAMP WITH TIME ZONE'2020-06-14T00:00:00.000Z', TIMESTAMP WITH TIME ZONE'2020-12-31T23:59:59.000Z', 0, 35.50, 1, 'EUR');

INSERT INTO prices
  (brand_id, product_id, start_date, end_date, priority, price, price_list, curr)
  VALUES
  (1, 35455, TIMESTAMP WITH TIME ZONE'2020-06-14T15:00:00.000Z', TIMESTAMP WITH TIME ZONE'2020-06-14T18:30:00.000Z', 1, 25.45, 2, 'EUR');

INSERT INTO prices
  (brand_id, product_id, start_date, end_date, priority, price, price_list, curr)
  VALUES
  (1, 35455, TIMESTAMP WITH TIME ZONE'2020-06-15T00:00:00.000Z', TIMESTAMP WITH TIME ZONE'2020-06-15T11:00:00.000Z', 1, 30.50, 3, 'EUR');

INSERT INTO prices
  (brand_id, product_id, start_date, end_date, priority, price, price_list, curr)
  VALUES
  (1, 35455, TIMESTAMP WITH TIME ZONE'2020-06-15T16:00:00.000Z', TIMESTAMP WITH TIME ZONE'2020-12-31T23:59:59.000Z', 1, 38.95, 4, 'EUR');

