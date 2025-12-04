Feature: User login page

  @Loginvalidcreds123
  Scenario Outline: User should login sucessfully with Valid credentials
    Given user is on Login Page
    When user should be able to login with valid "<username>" and "<password>"
    Then user shoule be directed to "<expectedDashboard>" pages

    Examples: 
      | username                        | password      | expectedDashboard |
      | controllengine007@jamesbond.com | Rimjhim##1234 | ADMIN             |
      | 9911624321@gmail.com            | Rimjhim##1234 | ARTIST            |
      | rakesh501@gmail.com             | Rimjhim##1234 | USER ADMIN        |

  @Logininvalidcreds
  Scenario Outline: user should see error message for invalid login credentials
    Given user is on Login Page
    When user should not be login into with "<username>" and "<password>"
    Then user must be shown "<expectedError>"

    Examples: 
      | username                     | password     | expectedError              |
      | controllengine@jamesbond.com | Rimjhi#1234  | Invalid login or password. |
      | 9911621001@gmail.com         | Rimjhim#1234 | Invalid login or password. |
      | rakesh50134@gmail.com        | Rimjhi#234   | Invalid login or password. |

  @Logininvalidcrederrors
  Scenario Outline: User should see error entering invalid login details
    Given user is on Login Page
    When user enters wrong details of "<username>" and "<password>"
    Then user should be shown "<expectedError>"

    Examples: 
      | username                                   | password                                  | expectedError                                                                                                                                |
      |                                            | Rimjhim##1234                             | Username is required                                                                                                                         |
      | rakesh50134@gmail.com                      |                                           | Password is required                                                                                                                         |
      |                                            |                                           | Username is required                                                                                                                         |
      | rakesh                                     | Rimjhim##1234                             | Please enter a valid username                                                                                                                |
      | rakesh50134@gmail.comrakesh50134@gmail.com | Rimjhim##1234                             | Please enter a valid username                                                                                                                |
      | rakesh50134@gmail.com                      | Rim                                       | Password must be 8–15 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character |
      | rakesh50134@gmail.com                      | Rimjhim##1234Rimjhim##1234456747868768689 | Password must be 8–15 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character |
