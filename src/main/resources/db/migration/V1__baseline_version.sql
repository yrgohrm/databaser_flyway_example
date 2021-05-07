-- The first migration script really sets up the baseline for the
-- database. Create all tables etc. that are needed for the first version.

CREATE TABLE highscore (
    id IDENTITY PRIMARY KEY,
    score INT NOT NULL,
    name VARCHAR(10)
);
