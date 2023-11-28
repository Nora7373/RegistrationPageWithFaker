package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;
import java.util.Locale;

public class RegistrationPageWithFakerTest extends TestBase {
    RegistrationPage registrationTest = new RegistrationPage();
    Faker faker = new Faker(new Locale("en-GB"));


    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = firstName + " " + lastName;
    String emailAddress = faker.internet().emailAddress();
    String gender = faker.options().option("Male", "Female", "Other");
    String userNumber = String.valueOf(faker.number().digits(10));
    String dayOfBirth = Integer.toString(faker.number().numberBetween(1,28));
    String mounthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May",
            "June", "July", "August", "September",
            "October", "November", "December");
    String yearhOfBirth = Integer.toString(faker.number().numberBetween(2000,2020));

    String birthday = dayOfBirth + " " + mounthOfBirth + "," + yearhOfBirth;
    String subject = faker.options().option("Maths", "Commerce", "Arts");
    String hobbies = faker.options().option( "Sports", "Reading", "Music");
    String pictureName = faker.options().option("Little-cat.jpg", "Dog.jpg");

    String streetAddress = faker.address().streetAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city =  getRandomCityByState(state);
    String stateAndCity = state + " " + city;



    String getRandomCityByState(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipad");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
        }
        return "";
    }
    @Test
    void successfulRegistrationTest() {
        RegistrationPage registrationPage = registrationTest.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, mounthOfBirth, yearhOfBirth)

                .setSubject(subject)
                .setHobbiesWrapper(hobbies)
                .setUploadFromClasspath(pictureName)
                .setCurrentAddress(streetAddress)
                .setSelectState(state)
                .setSelectCity(city)
                .setSubmit();

        registrationPage.checkResult("Student Name", fullName)
                .checkResult("Student Email", emailAddress)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthday)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", pictureName)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", stateAndCity);

    }

   @Test
   void negativRegistrationTest() {
       RegistrationPage registrationPage = registrationTest.openPage()
               .setSubmit();

       registrationPage.checkSubmitButtonBorderColor("border-color", "rgb(0, 98, 204)");
    }
}

