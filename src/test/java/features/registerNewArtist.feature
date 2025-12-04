Feature: Artist Registration

  @RegisterNewArtistPage12345678910
  Scenario Outline: Register a New Artist
    Given Artist is on the homepage
    When Artist clicks on the join as artist button and fills the "<WhatsYourTalent>" and "<GigLocation>"
    Then Artist should go to the "<Page2>"
    When Artist fills the personal details such as "<FullName>", "<ProfessionalName>", "<DOB>", "<Password>" and "<ConfirmPassword>"
    Then Artist is directed to the "<Page3>"
    When Artist fills service details such as "<GeneralCategory>" and "<SpecificCategory>"
    Then Artist verfies the "<Page4>"
    When Artist shares where did he "<HearAboutNXTGIG>"
    Then Artist leads to "<Page5>"
    When Artist fills following address details "<Address>", "<City>" and "<ZipCode>"
    Then verfies "<Page6>"
    When Artist uploads "<profilePic>"
    Then Goes to next page "<Page7>"
    When Artist fills his "<ServiceOverview>"
    Then Artist need to verfiy "<Page8>"
    When Artist fills professional details "<PhoneNumber>", "<Email>", "<SSNNumber>", "<DocName>"
    Then Artist to verfiy "<Page9>"
    When Artist enters his social profiles such as "<Youtube>", "<Insta>", "<Twitter>" and "<Fb>"
    Then verfication of "<Page10>" should be done.
    When Artist selects a Plan
    Then artist verfies his "<registeredEmail>"

    Examples: 
      | WhatsYourTalent          | GigLocation | Page2   | FullName       | ProfessionalName | DOB        | Password    | ConfirmPassword | Page3            | GeneralCategory          | SpecificCategory  | Page4                                     | HearAboutNXTGIG | Page5   | Address                                                      | City  | ZipCode | Page6    | profilePic   | Page7            | ServiceOverview | Page8        | PhoneNumber | Email               | SSNNumber | DocName   | Page9        | Youtube | Insta     | Twitter     | Fb     | Page10 | registeredEmail     |
      | Circus & Speciality Acts | Tampa       | Welcome | Shinde Harshad | Smart Joker      | 30-06-1990 | Harshad@123 | Harshad@123     | Nice to meet you | Circus & Speciality Acts | Circus Performers | How did you hear about NXTGIG? (Optional) | Social Media    | Address | Tampa General Hospital, Tampa General Circle, Tampa, FL, USA | Tampa |   33602 | Continue | Group 43.png | Service overview | Lorem Ipsum     | Phone number |  9555555054 | dhJfffgjs@gmail.com | NXTGIG123 | Whats.jpg | Social media | yt.com  | insta.com | twitter.com | fb.com | Pro    | d*******s@gmail.com |
