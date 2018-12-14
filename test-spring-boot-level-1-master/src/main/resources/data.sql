INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);


INSERT INTO current_account (currency, balance, creation_timestamp, modification_timestamp, version_number)
VALUES ('PESOS', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
INSERT INTO current_account (currency, balance, creation_timestamp, modification_timestamp, version_number)
VALUES ('DOLARES', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
INSERT INTO current_account (currency, balance, creation_timestamp, modification_timestamp, version_number)
VALUES ('EUROS', 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO movements( date, movement_type, description, amount, creation_timestamp, modification_timestamp, version_number)
VALUES(CURRENT_TIMESTAMP(), 'DEBITO' , 'COMPRA', 80.03, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO movements ( date, movement_type, description, amount, creation_timestamp, modification_timestamp, version_number)
VALUES( CURRENT_TIMESTAMP(), 'DEBITO' , 'COMPRA', 100.03, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO movements ( date, movement_type, description, amount, creation_timestamp, modification_timestamp, version_number)
VALUES( CURRENT_TIMESTAMP(), 'DEBITO' , 'COMPRA', 120.03, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);


INSERT INTO movements ( date, movement_type, description, amount, creation_timestamp, modification_timestamp, version_number, account_id)
VALUES( CURRENT_TIMESTAMP(), 'DEBITO' , 'COMPRA', 120.03, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, 1);

INSERT INTO movements ( date, movement_type, description, amount, creation_timestamp, modification_timestamp, version_number, account_id)
VALUES( CURRENT_TIMESTAMP(), 'DEBITO' , 'COMPRA', 560.03, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, 1);

