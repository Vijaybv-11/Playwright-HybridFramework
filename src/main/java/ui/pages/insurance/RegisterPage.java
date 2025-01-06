package ui.pages.insurance;

import com.microsoft.playwright.Page;

public class RegisterPage {

    Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }


    private static final String TITLE_DROPDOWN = "#user_title";
    private static final String SIGNUP_HEADER = "Sign up as a new user";
    private static final String FIRSTNAME_TEXTFIELD = "#user_firstname";
    private static final String SURNAME_TEXTFIELD = "#user_surname";
    private static final String PHONE_TEXTFIELD = "#user_phone";
    private static final String YEAR_DROPDOWN = "#user_dateofbirth_1i";
    private static final String MONTH_DROPDOWN = "#user_dateofbirth_2i";
    private static final String DAY_DROPDOWN = "#user_dateofbirth_3i";
    private static final String LICENCEPERIOD_DROPDOWN = "#user_licenceperiod";
    private static final String OCCUPATION_DROPDOWN = "#user_occupation_id";
    private static final String STREET_TEXTFIELD = "#user_address_attributes_street";
    private static final String CITY_TEXTFIELD = "#user_address_attributes_city";
    private static final String COUNTRY_TEXTFIELD = "#user_address_attributes_county";
    private static final String POSTCODE_TEXTFIELD = "#user_address_attributes_postcode";
    private static final String EMAIL_TEXTFIELD = "#user_user_detail_attributes_email";
    private static final String PASSWORD_TEXTFIELD = "#user_user_detail_attributes_password";
    private static final String CONFIRMPASSWORD_TEXTFIELD = "#user_user_detail_attributes_password_confirmation";
    private static final String CREATE_BUTTON="//input[@value='Create']";

    public boolean isSignUpHeaderDisplayed() {
        return page.getByText(SIGNUP_HEADER).isVisible();
    }

    public void selectTitle(String title) {
        page.locator(TITLE_DROPDOWN).selectOption(title);
    }

    public void selectYear(String year) {
        page.locator(YEAR_DROPDOWN).selectOption(year);
    }

    public void selectMonth(String month) {
        page.locator(MONTH_DROPDOWN).selectOption(month);
    }

    public void selectDay(String day) {
        page.locator(DAY_DROPDOWN).selectOption(day);
    }

    public void enterFirstName(String firstName) {
        page.locator(FIRSTNAME_TEXTFIELD).fill(firstName);
    }

    public void enterSurName(String surName) {
        page.locator(SURNAME_TEXTFIELD).fill(surName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        page.locator(PHONE_TEXTFIELD).fill(phoneNumber);
    }

    public void selectLicencePeriod(String period) {
        page.locator(LICENCEPERIOD_DROPDOWN).selectOption(period);
    }

    public void selectOccupation(String occupation) {
        page.locator(OCCUPATION_DROPDOWN).selectOption(occupation);
    }

    public void enterPassword(String password) {
        page.locator(PASSWORD_TEXTFIELD).fill(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        page.locator(CONFIRMPASSWORD_TEXTFIELD).fill(confirmPassword);
    }


    public void enterAddress(String address) {
        page.locator(STREET_TEXTFIELD).fill(address);
    }

    public void enterCity(String city) {
        page.locator(CITY_TEXTFIELD).fill(city);
    }

    public void enterEmail(String email) {
        page.locator(EMAIL_TEXTFIELD).fill(email);
    }

    public void enterCountry(String country) {
        page.locator(COUNTRY_TEXTFIELD).fill(country);
    }

    public void enterPostCode(String postcode) {
        page.locator(POSTCODE_TEXTFIELD).fill(postcode);
    }

    public void clickOnCreate(){
        page.locator(CREATE_BUTTON).click();
    }
}
