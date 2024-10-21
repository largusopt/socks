CREATE TABLE IF NOT EXISTS warehouses
(
id bigserial PRIMARY KEY,
quantity int NOT NULL CHECK (quantity >= 0),
socks_id BIGINT REFERENCES socks (id) NOT NULL
);