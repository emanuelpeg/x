-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS X WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create a table
CREATE TABLE IF NOT EXISTS X.xeets (
xid uuid PRIMARY KEY,
username text,
text text,
createDate timestamp
);

-- Insert some data
INSERT INTO X.xeets
(xid, username, text, createDate)
VALUES (77e618c2-8346-4c9a-bd1c-edac32070975, 'Emanuel', 'Un ejemplo', toTimeStamp(now()));
INSERT INTO X.xeets
(xid, username, text, createDate)
VALUES (d2824c65-16df-43e3-8812-8ee2a19b2049, 'Emanuel', 'Otro ejemplo', toTimeStamp(now()));
