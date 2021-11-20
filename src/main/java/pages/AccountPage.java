package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private final static By email = By.id("email_create");
    private final static By createAccountButton = By.id("SubmitCreate");
    private final static By formTitles = By.xpath("//div[@class = 'account_creation']//h3");
    private final static By mrsGender = By.id("id_gender2");
    private final static By mrGender = By.id("id_gender1");
    private final static By nameArea = By.id("customer_firstname");
    private final static By surnameArea = By.id("customer_lastname");
    private final static By emailAreaOnForm  = By.xpath("//input[@id = 'email']");
    private final static By passwordArea = By.xpath("//input[@type = 'password']");
    private final static By daysArea = By.id("uniform-days");
    private final static By monthArea = By.id("uniform-months");
    private final static By yearsArea = By.id("uniform-years");
    private final static By daysOfBirth = By.id("days");
    private final static By monthsOfBirth = By.id("months");
    private final static By yearsOfBirth = By.id("years");
    private final static By firsNameOnAddressArea = By.id("firstname");
    private final static By lastNameOnAddressArea = By.id("lastname");
    private final static By addressArea = By.id("address1");
    private final static By cityArea = By.id("city");
    private final static By stateArea = By.id("uniform-id_state");
    private final static By selectState = By.id("id_state");
    private final static By zipCodeArea = By.id("postcode");
    private final static By countryArea = By.id("uniform-id_country");
    private final static By selectCountry = By.id("id_country");
    private final static By mobilePhoneArea = By.id("phone_mobile");
    private final static By aliasArea = By.id("alias");
    private final static By accountSubmitButton = By.id("submitAccount");
    private final static By accountCategories = By.xpath("//ul[@class ='myaccount-link-list']/li");



    public void checkUrl() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("accountUrl"));
    }

    public void enterEmail(String emailText) {
        waitUntilVisible(email);
        waitUntilClickable(email);
        sendKey(email,emailText);
        waitForLoad();
    }

    public void clickSubmitButton() {

        waitUntilVisible(createAccountButton);
        waitUntilClickable(createAccountButton);
        waitForLoad();
    }

    public void checkAccountPageFormTitles() {
        waitUntilVisible(formTitles);
        Assert.assertEquals("YOUR PERSONAL INFORMATION", getWebElements(formTitles).get(0).getText());
        Assert.assertEquals("YOUR ADDRESS", getWebElements(formTitles).get(1).getText());
    }

    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("Mrs.")) {
            waitUntilVisible(mrsGender);
            waitUntilClickable(mrsGender);
        }
        else {
            waitUntilVisible(mrGender);
            waitUntilClickable(mrGender);
        }

    }

    public void enterName(String name) {

        waitUntilClickable(nameArea);
        sendKey(nameArea,name);
        waitForLoad();
    }

    public void enterSurname(String surname) {

        waitUntilClickable(surnameArea);
        sendKey(surnameArea,surname);
        waitForLoad();
    }

    public void checkEmailAlreadyEntered(String email) {
       waitUntilClickable(emailAreaOnForm);
       Assert.assertEquals(email,  getAttribute(emailAreaOnForm,"value"));
    }

    public void enterPassword(int password) {
        waitUntilVisible(passwordArea);
        waitUntilClickable(passwordArea);
        sendKey(passwordArea,String.valueOf(password));
        waitForLoad();
    }

    public void entersBirthday(String birthday) {

        String[] respList = birthday.split("\\.");
        String day = respList[0].trim();
        String month = respList[1].trim();
        String year = respList[2].trim();

        if(day.startsWith("0"))
            day = day.substring(1,2);
        if(month.startsWith("0"))
            month =month.substring(1,2);

        enterDay(day);
        enterMonth(month);
        enterYear(year);
    }

    private void enterDay(String day) {

        waitUntilVisible(daysArea);
        actionClick(daysArea);
        selectElementBySelectValue(daysOfBirth,day);
    }

    private void enterMonth(String month) {
        waitUntilVisible(monthArea);
        actionClick(monthArea);
        selectElementBySelectValue(monthsOfBirth,month);
    }

    private void enterYear(String year) {
        waitUntilVisible(yearsArea);
        actionClick(yearsArea);
        selectElementBySelectValue(yearsOfBirth,year);

    }

    public void checkNameAlreadyEntered(String name) {
        findAndScrollElement(firsNameOnAddressArea,10);
        waitUntilVisible(firsNameOnAddressArea);
        waitUntilClickable(firsNameOnAddressArea);
        Assert.assertEquals(name,  getAttribute(firsNameOnAddressArea,"value"));
    }

    public void checkSurnameAlreadyEntered(String surname) {
        findAndScrollElement(lastNameOnAddressArea,10);
        waitUntilVisible(lastNameOnAddressArea);
        waitUntilClickable(lastNameOnAddressArea);
        Assert.assertEquals(surname,  getAttribute(lastNameOnAddressArea,"value"));
    }

    public void enterAddress(String address) {
        waitUntilVisible(addressArea);
        waitUntilClickable(addressArea);
        sendKey(addressArea,address);
        waitForLoad();
    }

    public void enterCity(String cityName) {
        waitUntilVisible(cityArea);
        findAndScrollElement(lastNameOnAddressArea,10);
        waitUntilClickable(cityArea);
        sendKey(cityArea,cityName);
        waitForLoad();
    }

    public void selectState(int stateNumber) {
        waitUntilVisible(stateArea);
        findAndScrollElement(stateArea,10);
        actionClick(stateArea);
        selectElementBySelectValue(selectState,String.valueOf(stateNumber));
    }

    public void enterZipCode(String zip) {

        waitUntilVisible(zipCodeArea);
        findAndScrollElement(zipCodeArea,10);
        waitUntilClickable(zipCodeArea);
        sendKey(zipCodeArea,zip);
        waitForLoad();
    }

    public void selectCountry() {
        waitUntilVisible(countryArea);
        findAndScrollElement(countryArea,10);
        actionClick(countryArea);
        selectElementBySelectValue(selectCountry,String.valueOf(21));
    }

    public void enterPhoneNumber(String mobilePhone) {
        waitUntilVisible(mobilePhoneArea);
        findAndScrollElement(mobilePhoneArea,10);
        waitUntilClickable(mobilePhoneArea);
        sendKey(mobilePhoneArea,mobilePhone);
        waitForLoad();
    }

    public void enterAliasAddress(String aliasAdress) {
        waitUntilVisible(aliasArea);
        findAndScrollElement(aliasArea,10);
        waitUntilClickable(aliasArea);
        sendKey(aliasArea,aliasAdress);
        waitForLoad();
    }

    public void clickAccountFormSubmitButton() {
        waitUntilVisible(accountSubmitButton);
        waitUntilClickable(accountSubmitButton);
        waitForLoad();
    }

    public void checkAccountCategories() {
        waitForLoad();
        waitUntilUrlContains(properties.getProperty("loginAccountUrl"));
        for(WebElement element: getWebElements(accountCategories))
               isElementPresent(element);

    }
}
