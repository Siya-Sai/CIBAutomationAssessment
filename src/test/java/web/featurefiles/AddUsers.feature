Feature: Add Users to User List Table

  Scenario Outline: Add a user to the list
    Given I am on the User List Table page
    When I click Add User
    And I enter user details:
      | First Name | Last Name | User Name | Password | Company | Role      | Email                | CellPhone |
      | <firstName>| <lastName>| <userName>| <password>| <company>| <role>    | <email>              | <cellPhone>|
    Then the user should be added to the list

    Examples:
      | firstName | lastName | userName | password | company | role      | email                  | cellPhone |
      | FName1    | LName1   | User1    | Pass1    | AAA     | Admin     | admin@mail.com        | 082555    |
      | FName2    | LName2   | User2    | Pass2    | BBB     | Customer | customer@mail.com     | 082555    |