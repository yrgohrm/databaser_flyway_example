# A simple Flyway example

This is a super basic example to get started with Flyway without the most
tedious parts of cut'n'paste coding.

## Running

This example uses a Microsoft SQL Server so you need to have an instance of 
that running. You also need to create the database and set environment
variables with the database user and password.

Create the database using the following SQL:
```SQL
CREATE DATABASE Highscore;
GO
```

Set the environment variables using the following (of course substitute for
whatever your install needs):

PowerShell:
```PowerShell
$env:MSSQL_USER="sa"
$env:MSSQL_PASSWORD="someP4ssword"
```

or for Bash:
```SH
export MSSQL_USER="sa"
export MSSQL_PASSWORD="someP4ssword"
```

To compile and package the project:
`mvn package`

To generate the database from the Flyway migration scripts:
`mvn flyway:migrate`

To run the application:
`mvn exec:java`
