DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS orders_products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS operations;
DROP TABLE IF EXISTS accounts;

CREATE TABLE users (
  id          SERIAL PRIMARY KEY,
  email       TEXT NOT NULL UNIQUE,
  password    TEXT NOT NULL,
  name        TEXT NOT NULL,
  role        INTEGER NOT NULL
);

CREATE TABLE accounts (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL,
  user_id     INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE operations (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL,
  value       NUMERIC(10,2),
  datetime    TIMESTAMP WITH TIME ZONE NOT NULL,
  account_id       INTEGER,
  FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE SET NULL
);

CREATE TABLE orders (
  id            SERIAL PRIMARY KEY,
  total_amount  NUMERIC(10,2) NOT NULL,
  datetime      TIMESTAMP WITH TIME ZONE NOT NULL,
  name          TEXT NOT NULL,
  email         TEXT NOT NULL,
  phone         TEXT,
  address       TEXT NOT NULL,
  user_id       INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE users_operations (
  user_id    INTEGER NOT NULL,
  operation_id  INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (operation_id) REFERENCES operations (id) ON DELETE CASCADE
);

CREATE TABLE comments (
  id          SERIAL PRIMARY KEY,
  product_id  INTEGER NOT NULL,
  author      TEXT NOT NULL,
  datetime    TIMESTAMP WITH TIME ZONE NOT NULL,
  text        TEXT,
  rating      INTEGER,
  FOREIGN KEY (product_id) REFERENCES operations (id) ON DELETE CASCADE
);
