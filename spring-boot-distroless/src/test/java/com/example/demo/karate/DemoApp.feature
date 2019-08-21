Feature: Demo Application

  Background:
    * url java.lang.System.getenv('BASEURL')
    * def fName = java.lang.System.getenv('FIRSTNAME')
    * def lName = java.lang.System.getenv('LASTNAME')
    * print 'the value of first name is:', fName
    * print 'the value of last name is:', lName

  Scenario: Create Person
    Given path '/attendance/addName/'+fName+'/'+lName
    And header Content-Type = 'application/json'
    And request ''
    When method POST
    Then status 201

  Scenario: Get Persons
    Given path '/attendance/findNames'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    * print response.length
    And assert response.length == 1
    And match response[0].firstName == '#(fName)'
    And match response[0].lastName == '#(lName)'

  Scenario: Create Person 2
    Given path '/attendance/addName/'+lName+'/'+fName
    And header Content-Type = 'application/json'
    And request ''
    When method POST
    Then status 201

  Scenario: Get Persons 2
    Given path '/attendance/findNames'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    * print response.length
    And assert response.length == 2

  Scenario: Delete Person 1
    Given path '/attendance/deleteName/'+fName
    And header Content-Type = 'application/json'
    When method DELETE
    Then status 204

  Scenario: Get Persons 3
    Given path '/attendance/findNames'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    * print response.length
    And assert response.length == 1
    And match response[0].firstName == '#(lName)'
