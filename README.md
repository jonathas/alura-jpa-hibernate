# Alura - Java and JPA course: Persist your objects with JPA2 and Hibernate

This is the code that I've developed following the course. I've made some changes in the original one.

## Content

### Introduction to JPA and Hibernate

  - Working with the database
  - The object-oriented paradigm
  - Avoiding SQL within Java code
  - JDBC and SQL maintenance issues
  - Persist objects without writing SQL
  - Joining the two worlds through Relational Object Mapping
  - The Java Persistence API (JPA)
  - The first example with JPA
  - abstract


### Configuring and Booting the JPA

  - JPA and Hibernate Libraries
  - Preparing the model
  - The first Entity
  - Bank preparation and schema generation
  - Initialization of JPA and Hibernate
  - Transaction Management
  - Persisting entities in the bank


### State Management by EntityManager

  - Introduction
  - Load entity by primary key
  - Managed Entities, Managed Status
  - Persisting transient objects
  - Update Detached Objects
  - Removing EntityManager Entities
  - Summary of states


### Mapping relationships between entities

  - Relationship between Entities
  - Relating the Move to an Account
  - Dealing with dates
  - Defining the cardinality of the relationship
  - Persisting objects involved in relationships
  - Dealing with TransientPropertyException


### Relationship Many to Many and One to One

  - Cataloging the drives through Categories
  - Saving more information about our customers


### Object-oriented searching with JPQL

  - Queries with the Java Persistence Query Language
  - Object-oriented searches
  - Creating and Running Queries
  - Problems using JPQL
  - Working with parameters in JPQL query in a secure way
  - Using Named Parameters
  - Sorting search results
  - Improving our filter
  - abstract


### Two-way relationships and LAZY behavior

  - Why two-way relationships?
  - Navigating the relationship without Join
  - Setting One-To-Many Relationship
  - The difference in relationships in the OO and relational world
  - Declaring the relationship as bidirectional
  - Update the database schema
  - Testing the bidirectional relationship
  - The problem of N + 1 queries and how to solve
  - LAZY Behavior of Para-Many Relationships
  - Just out of curiosity, the FetchType.EAGER
  - Why were the accounts repeated?
  - But after all we want all accounts!


### A bit more about queries and JPQL

  - Searching with aggregate functions
  - Adding the amounts to the account
  - Improving Search with TypedQuery
  - Searching for the average values


### Organizing Your Queries

  - Organize your queries with the Data Access Object
  - Getting to know the Named Queries
