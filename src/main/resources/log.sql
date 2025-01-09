CREATE TABLE log (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                     method_name VARCHAR(255),
                     arguments TEXT,
                     result TEXT
);