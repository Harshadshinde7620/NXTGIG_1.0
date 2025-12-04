Feature: User should search registered artist

  @singleDayEventSerach
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then list of registered user should be shown "<VerificationText>"

    Examples: 
      | upcomingEvent                            | City           | eventDate  | VerificationText                                         |
      | Characters, Impersonators & Entertainers | Bonita Springs | 09/25/2025 | Your search for Characters, Impersonators & Entertainers |

  @verfiyNumberofRegisteredArtist
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then verfiy no of registered artists with thier "<results>"

    Examples: 
      | upcomingEvent                            | City           | eventDate  | results   |
      | Music                                    | Bonita Springs | 24/11/2025 | 2 results |
      | Characters, Impersonators & Entertainers | Tampa          | 24/11/2025 | 9 results |

	@verifyArtistProfilePic
  Scenario Outline: User should see artist profile picture after searching by city
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then the artist's profile picture should be displayed

    Examples: 
      | upcomingEvent | City           | eventDate  |
      | Music         | Bonita Springs | 11/24/2025 |

  @getListofRegisteredArtist
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then get the registered artists with "<list>" and "<artistName>"

    Examples: 
      | upcomingEvent                            | City           | eventDate  | list      | artistName        |
      | Music                                    | Bonita Springs | 11/29/2025 | 2 results | RAKESH 8811624003 |
      | Characters, Impersonators & Entertainers | Tampa          | 11/29/2025 | 9 results | Harsh Harsh      |

  @extractSearchEventandEventDate
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then get the "<searchEvent>" and "<searchEventDate>" from the search page

    Examples: 
      | upcomingEvent                            | City           | eventDate  | searchEvent                              | searchEventDate |
      | Music                                    | Bonita Springs | 11/29/2025 | Music                                    | 11/29/2025     |
      | Characters, Impersonators & Entertainers | Tampa          | 11/29/2025 | Characters, Impersonators & Entertainers | 11/29/2025     |

  
  @updatetheFieldsinSearchPage
  Scenario Outline: User should be able to search artist and then update fields on the search page
    Given user is on the website
    When user fills "<upcomingEvent>", "<City>", and "<eventDate>"
    Then user updates fields with "<updatedEvent>", "<updatedCity>", and "<updatedEventDate>" on the search page
    And verifies "<updatedSearchEvent>" and "<updatedSearchEventDate>"

    Examples: 
      | upcomingEvent | City           | eventDate  | updatedEvent                             | updatedCity | updatedEventDate | updatedSearchEvent                       | updatedSearchEventDate |
      | Music         | Bonita Springs | 11/25/2025 | Characters, Impersonators & Entertainers | Tampa       | 11/25/2025       | Characters, Impersonators & Entertainers | 11/29/2025             |

  @errorMessagesforsingleDayEventSerach
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user submits the "<upcomingEvent>", "<City>" and "<eventDate>" data
    Then user must verfies "<ExpectedMessage>"

    Examples: 
      | upcomingEvent            | City      | eventDate  | ExpectedMessage                 |
      |                          | Bradenton | 17/09/2025 | Please select what do you need. |
      | Circus & Speciality Acts |           | 17/09/2025 | Please select city.             |

  @multipleDayEventSerach
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user submits the "<upcomingEvent>", "<City>" and "<eventDate>" data
    Then user verfies "<VerificationText>"

    Examples: 
      | upcomingEvent            | City      | eventDate  | VerificationText                         |
      | Circus & Speciality Acts | Bradenton | 17/09/2025 | Your search for Circus & Speciality Acts |

  @verfiyNumberofRegisteredArtistforMultiDayEvent
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then get registered artists number using"<result>"

    Examples: 
      | upcomingEvent                            | City           | eventDate               | result    |
      | Music                                    | Bonita Springs | 19/09/2025 - 22/09/2025 | 2 results |
      | Characters, Impersonators & Entertainers | Tampa          | 19/09/2025 - 22/09/2025 | 8 results |

  @getListofRegisteredArtistMultipleDayEvents
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user fills the "<upcomingEvent>", "<City>" and "<eventDate>"
    Then verfiy the registered artists with the help of "<list>" and "<artistName>"

    Examples: 
      | upcomingEvent                            | City           | eventDate               | list      | artistName        |
      | Music                                    | Bonita Springs | 19/09/2025 - 22/09/2025 | 2 results | RAKESH 8811624003 |
      | Characters, Impersonators & Entertainers | Tampa          | 19/09/2025 - 22/09/2025 | 8 results | Rakesh Kumar      |

  @errorMessagesformultipleDayEventSerach
  Scenario Outline: User should be able to search artist as per there city preference
    Given user is on the website
    When user submits the "<upcomingEvent>", "<City>" and "<eventDate>" data
    Then user should verfies "<ExpectedMessage>"

    Examples: 
      | upcomingEvent            | City      | eventDate  | ExpectedMessage                 |
      |                          | Bradenton | 17/09/2025 | Please select what do you need. |
      | Circus & Speciality Acts |           | 17/09/2025 | Please select city.             |
