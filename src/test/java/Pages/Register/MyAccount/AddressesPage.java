package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import ObjectData.RegisterPageObject;
import Pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='no-data' and contains(text(),'No addresses')]")
    private WebElement noAddressMesage;
    @FindBy(xpath = "//button[contains(@class,'add-address-button') and contains(text(),'Add new')]")
    private WebElement addNewButton;
    @FindBy(id = "Address_FirstName")
    private WebElement firstName;
    @FindBy(id = "Address_LastName")
    private WebElement lastName;
    @FindBy(id = "Address_Email")
    private WebElement email;
    @FindBy(id = "Address_CountryId")
    private WebElement countrySelect;
    @FindBy(id = "Address_City")
    private WebElement city;
    @FindBy(id = "Address_Address1")
    private WebElement addressLine1;
    @FindBy(id = "Address_ZipPostalCode")
    private WebElement zip;
    @FindBy(id = "Address_PhoneNumber")
    private WebElement phoneNumber;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Save')]")
    private WebElement saveButton;
    @FindBy(xpath = "//strong[contains(text(),'Georgian Adetu')]")
    private WebElement titleName;
    @FindBy(xpath = "//li[@class='name'][text()='Georgian Adetu']")
    private WebElement addressesNameOwner;
    @FindBy(xpath = "//li[contains(., 'new_boy919@yahoo.com')]")
    private WebElement newEmailUpdated;
    @FindBy(xpath ="//li[contains(., '0771702457')]")
    private WebElement newPhoneNumberUpdated;
    @FindBy(xpath = "//li[contains(., 'Str. Oborului, Bl. AB4')]")
    private WebElement newAddress1;
    @FindBy(xpath = "//li[contains(., 'Constanta, 810563')]")
    private WebElement newCityAndZip;

    public void validateNoAddress(RegisterPageObject registerPageObject){
        elementMethods.validateMessage(noAddressMesage, registerPageObject.getNoAddressMesage());
        LoggerUtility.info("The no address message has been validated with success.");
    }

    public void addNewInterract(){
        elementMethods.clickElement(addNewButton);
        LoggerUtility.info("The user clicks on Add New button.");
    }

    public void fillNewAddressForm(RegisterPageObject registerPageObject){
        elementMethods.fillElement(firstName,registerPageObject.getNewFirstName());
        LoggerUtility.info("The user fills first name with new value: "+registerPageObject.getNewFirstName());
        elementMethods.fillElement(lastName,registerPageObject.getNewLastName());
        LoggerUtility.info("The user fills last name with new value: "+registerPageObject.getNewLastName());
        elementMethods.fillElement(email,registerPageObject.getNewEmail());
        LoggerUtility.info("The user fills email field with new value: "+registerPageObject.getNewEmail());
        elementMethods.fillElement(countrySelect,"Romania", Keys.ENTER);
        LoggerUtility.info("The user clicks on Country, writes value Romania, then presses ENTER.");
        elementMethods.fillElement(city,registerPageObject.getNewCity());
        LoggerUtility.info("The user fills city field with new value :"+registerPageObject.getNewCity());
        elementMethods.fillElement(addressLine1,registerPageObject.getNewAddress1());
        LoggerUtility.info("The user fills first address line with new value :"+registerPageObject.getNewAddress1());
        elementMethods.fillElement(zip,registerPageObject.getNewZip());
        LoggerUtility.info("The user fills zip filed with new value :"+registerPageObject.getNewZip());
        elementMethods.fillElement(phoneNumber,registerPageObject.getNewPhoneNumber());
        LoggerUtility.info("The user fills phone number field with new value :"+registerPageObject.getNewPhoneNumber());
        elementMethods.clickElement(saveButton);
        LoggerUtility.info("The user clicks on Save button.");
    }

    public void validateUpdatedAddresses(){
        elementMethods.validatePresenceElement(titleName);
        LoggerUtility.info("The title name has been validated with success.");
        elementMethods.validatePresenceElement(addressesNameOwner);
        LoggerUtility.info("The name in addresses has been validated with success.");
        elementMethods.validatePresenceElement(newEmailUpdated);
        LoggerUtility.info("The new email has been validated with success.");
        elementMethods.validatePresenceElement(newPhoneNumberUpdated);
        LoggerUtility.info("The new phone number has been validated with success.");
        elementMethods.validatePresenceElement(newAddress1);
        LoggerUtility.info("The new address has been validated with success.");
        elementMethods.validatePresenceElement(newCityAndZip);
        LoggerUtility.info("The new city and zip have been validated with success.");
    }
}
