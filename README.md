# A simple Flyway example

This is a super basic example to get started with Flyway without the most
tedious parts of cut'n'paste coding.

## Running

This example uses a H2 database and thus do not need anything to be installed.

To generate the database from the Flyway migration scripts:
`mvn flyway:migrate`

To run the application:
`mvn exec:java`
