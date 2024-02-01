-- The first migration script really sets up the baseline for the
-- database. Create all tables etc. that are needed for the first version.

CREATE TABLE highscore (
    id INT IDENTITY(1,1) PRIMARY KEY,
    score INT NOT NULL,
    name VARCHAR(10)
);
GO
