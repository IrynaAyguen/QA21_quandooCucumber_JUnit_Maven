@regression
Feature: Quandoo Equiry Feature
  In order to send my enquiry directly to the restaurant
  I fill in my booking details

  @invalidDataEnquiry
  Scenario Outline: Make an enquiry with invalid data

    Given I am on the CavallioRossoRestaurant page
    When I click  Make an enquiry Button
    Then I see  Enquiry Page

    When I insert valid PeopleNumber,Date, Time in Enquiry form
    And I insert invalid Email or Name or PhoneNumber or Message in Enquiry form

      | email   | firstName   | lastName   | phoneNumber   | message   | iAgreeCheckbox   |
      | <email> | <firstName> | <lastName> | <phoneNumber> | <message> | <iAgreeCheckbox> |

    And I click on Send enquiry button
    Then I see that wrong enquiry message appeared
    """
<errorMessage>
    """
    Examples:
      | email        | firstName | lastName | phoneNumber | message    | iAgreeCheckbox | errorMessage                                    |
      | ira          | Ir15      | Ira15    | 15745678212 | Geburtstag | 1              | Wrong format. Please enter valid email address. |
      |              | Ir15      | Ira15    | 15745678212 | Geburtstag | 1              | Enter email address                             |
      | ira15@web.de |           | Ira15    | 15745678212 | Geburtstag | 1              | Enter first name                                |
      | ira15@web.de | Ir15      |          | 15745678212 | Geburtstag | 1              | Enter last name                                 |
      | ira15@web.de | Ir15      | Ira15    | 15745dfgfgh | Geburtstag | 1              | This field must contain digits only             |
      | ira15@web.de | Ir15      | Ira15    | 15          | Geburtstag | 1              | Enter valid phone number                        |
      | ira15@web.de | Ir15      | Ira15    |             | Geburtstag | 1              | Enter phone number                              |
      | ira15@web.de | Ir15      | Ira15    | 15745678212 | Geburtstag | 0              | Please agree to Quandoo's Terms & Conditions.   |
      | ira15@web.de | Ir15      | Ira15    | 15745678212 |            | 1              | Enter message                                   |

