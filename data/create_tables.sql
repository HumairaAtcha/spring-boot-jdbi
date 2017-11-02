CREATE DATABASE zoo;

USE zoo;

CREATE TABLE animals (
    -- id primary key - auto-incrementing number?
    name VARCHAR(20),
    hair BOOLEAN DEFAULT 0,
    feathers BOOLEAN DEFAULT 0,
    eggs BOOLEAN DEFAULT 0,
    milk BOOLEAN DEFAULT 0,
    airborne BOOLEAN DEFAULT 0,
    aquatic BOOLEAN DEFAULT 0,
    predator BOOLEAN DEFAULT 0,
    toothed BOOLEAN DEFAULT 0,
    backbone BOOLEAN DEFAULT 0,
    breathes BOOLEAN DEFAULT 0,
    venomous BOOLEAN DEFAULT 0,
    fins BOOLEAN DEFAULT 0,
    num_legs SMALLINT,
    tail BOOLEAN DEFAULT 0,
    domestic BOOLEAN DEFAULT 0,
    catsize BOOLEAN DEFAULT 0,
    type SMALLINT
);
