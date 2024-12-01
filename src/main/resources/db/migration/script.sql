CREATE TABLE IF NOT EXISTS currency
(
    id        SERIAL PRIMARY KEY,
    code      VARCHAR(3) UNIQUE NOT NULL CHECK ( code ~ '^[A-Z]{3}$' ),
    full_name VARCHAR(128)      NOT NULL,
    sign      VARCHAR(2)        NOT NULL CHECK ( sign ~ '^.{1,2}$' )
);

CREATE TABLE IF NOT EXISTS exchange_rate
(
    id                 SERIAL PRIMARY KEY,
    base_currency_id   INT REFERENCES currency,
    target_currency_id INT REFERENCES currency,
    rate               DECIMAL(6) NOT NULL
);

INSERT INTO currency (code, full_name, sign)
VALUES ('AUD', 'Australian dollar', 'A$'),
       ('UAH', 'Ukrainian hryvnia', '₴'),
       ('USD', 'United States dollar', '$'),
       ('EUR', 'EURO', '€'),
       ('GBP', 'Pound Sterling', '£'),
       ('JPY', 'Yen', '¥'),
       ('CNY', 'Yuan', '¥'),
       ('RUB', 'Russian ruble', '₽');

INSERT INTO exchange_rate (base_currency_id, target_currency_id, rate)
VALUES (3, 4, 0.99),
       (6, 2, 161.37),
       (5, 8, 0.85000);
       
CREATE UNIQUE INDEX unique_currency_pair ON exchange_rate (base_currency_id, target_currency_id);
