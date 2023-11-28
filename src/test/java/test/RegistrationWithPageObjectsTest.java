package test;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

public class RegistrationWithPageObjectsTest extends TestBase {
    RegistrationPage registrationTest = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        RegistrationPage registrationPage = registrationTest.openPage()
                .setFirstName("Olga")
                .setLastName("Savina")
                .setEmail("olga@savina.com")
                .setGender("Female")
                .setUserNumber("7777777777")
                .setDateOfBirth("31", "October", "2023")
                .setSubject("Maths")
                .setHobbiesWrapper("Sports")
                .setHobbiesWrapper("Reading")
                .setHobbiesWrapper("Music")
                .setUploadFromClasspath("Little-cat.jpg")
                .setCurrentAddress("Luneburg, shtrasse 111")
                .setSelectState("NCR")
                .setSelectCity("Noida")
                .setSubmit();

        registrationPage.checkResult("Student Name", "Olga Savina")
                .checkResult("Student Email", "olga@savina.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7777777777")
                .checkResult("Date of Birth", "31 October,2023")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "Little-cat.jpg")
                .checkResult("Address", "Luneburg, shtrasse 111")
                .checkResult("State and City", "NCR Noida");

    }

    @Test
    void minimumFieldsRegistrationTest() {
        RegistrationPage registrationPage = registrationTest.openPage()
                .setFirstName("Olga")
                .setLastName("Savina")
                .setEmail("olga@savina.com")
                .setGender("Female")
                .setUserNumber("7777777777")
                .setDateOfBirth("31", "October", "2023")
                .setSubject("Maths")
                .setHobbiesWrapper("Sports")
                .setHobbiesWrapper("Reading")
                .setHobbiesWrapper("Music")
                .setSubmit();

        registrationPage.checkResult("Student Name", "Olga Savina")
                .checkResult("Student Email", "olga@savina.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7777777777")
                .checkResult("Date of Birth", "31 October,2023")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music");

    }

   @Test
   void negativRegistrationTest() {
       RegistrationPage registrationPage = registrationTest.openPage()
               .setSubmit();

       registrationPage.checkSubmitButtonBorderColor("border-color", "rgb(0, 98, 204)");
    }
}

