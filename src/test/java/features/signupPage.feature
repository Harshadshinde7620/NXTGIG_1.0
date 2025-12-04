Feature: User Signup Page

  @SignupSucessfullRegistration
  Scenario Outline: User should be able to signup sucessfully with valid credentials
    Given User is on the signup page
    When User fills the "<firstName>", "<lastName>", "<emailId>", "<phoneNumber>", "<password>", and "<confirmPassword>"
    Then User sees following "<message>"

    Examples: 
      | firstName | lastName | emailId                  | phoneNumber | password    | confirmPassword | message                                     |
      | HarshShinde    | HarshShinde   | HarshShinde.123@gmail.com |  0987654432 | Harshad@123 | Harshad@123     | Verify your email to start booking artists! |

  @Re-Registration
  Scenario Outline: User should not be able to signup sucessfully with already registered credentials
    Given User is on the signup page
    When User fills the "<firstName>", "<lastName>", "<emailId>", "<phoneNumber>", "<password>", and "<confirmPassword>"
    Then User sees "<message>"

    Examples: 
      | firstName | lastName | emailId                 | phoneNumber | password    | confirmPassword | message                             |
      | HarshShinde    | HarshShinde   | HarshShinde.123@gmail.com |  0987654432 | Harshad@123 | Harshad@123     | Entered email is already registered |

  @signUpErrorMessages
  Scenario Outline: User should see error messages in signup fileds
    Given User is on the signup page
    When User fills the "<firstName>", "<lastName>", "<emailId>", "<phoneNumber>", "<password>", and "<confirmPassword>"
		Then User gets "<errorMessage>"

    Examples: 
      | firstName | lastName | emailId                 | phoneNumber | password    | confirmPassword | errorMessage                                                                           |
      |           | Shinde   | shindeshindee@gmail.com |  1212565432 | Harshad@123 | Harshad@123     | Please enter your first name.                                                          |
      | Shinde    |          | shindeshindee@gmail.com |  1212565432 | Harshad@123 | Harshad@123     | Please enter your last name.                                                           |
      | Shinde    | Shinde   |                         |  1212565432 | Harshad@123 | Harshad@123     | Please enter a valid email address.                                                    |
      | Shinde    | Shinde   | shindeshindee@gmail.com |             | Harshad@123 | Harshad@123     | Please enter a valid mobile number.                                                    |
      | Shinde    | Shinde   | shindeshindee@gmail.com |  1212565432 |             | Harshad@123     | Password must be 8-15 characters with a symbol, upper/lowercase letters, and a number. |
      | Shinde    | Shinde   | shindeshindee@gmail.com |  1212565432 | Harshad@123 |                 | Confirm password does not match.                                                       |
