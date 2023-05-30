CREATE TABLE coin (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    datetime TIMESTAMP,
    price NUMERIC(20,2),
    quantity NUMERIC(20,10)
);