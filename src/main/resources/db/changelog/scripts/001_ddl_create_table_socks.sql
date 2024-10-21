CREATE TABLE IF NOT EXISTS socks
(
id bigserial PRIMARY KEY,
color varchar NOT NULL,
cotton_part int NOT NULL CHECK (cotton_part > 0 AND cotton_part <= 100),
UNIQUE (color, cotton_part)
);