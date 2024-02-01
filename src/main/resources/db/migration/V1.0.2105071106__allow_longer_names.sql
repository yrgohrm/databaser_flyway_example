-- The name column was far too short for proper names
ALTER TABLE highscore ALTER COLUMN name VARCHAR(100);
GO
