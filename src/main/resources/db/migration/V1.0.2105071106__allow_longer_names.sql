-- The name column was far too short for proper names
ALTER TABLE highscore ALTER COLUMN name SET DATA TYPE VARCHAR(100);
