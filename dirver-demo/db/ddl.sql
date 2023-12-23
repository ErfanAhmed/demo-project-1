create table driver
(
    id          INT     NOT NULL,
    name        VARCHAR NOT NULL,
    age         VARCHAR NOT NULL,
    created     TIMESTAMP,
    updated     TIMESTAMP,
    version     INT,
    CONSTRAINT pk_driver_id PRIMARY KEY (id)
);

create sequence driver_seq start with 1 increment by 1;