package test;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));
    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String fullName = firstName + " " + lastName;
    public final String emailAddress = faker.internet().emailAddress();
    public final String gender = faker.options().option("Male", "Female", "Other");
    public final String userNumber = String.valueOf(faker.number().digits(10));
    public final String dayOfBirth = Integer.toString(faker.number().numberBetween(1,28));
    public final String mounthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May",
            "June", "July", "August", "September",
            "October", "November", "December");
    public final String yearhOfBirth = Integer.toString(faker.number().numberBetween(2000,2020));

    public final String birthday = dayOfBirth + " " + mounthOfBirth + "," + yearhOfBirth;
    public final String subject = faker.options().option("Maths", "Commerce", "Arts");
    public final String hobbies = faker.options().option( "Sports", "Reading", "Music");
    public final String pictureName = faker.options().option("Little-cat.jpg", "Dog.jpg");

    public final String streetAddress = faker.address().streetAddress();
    public final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public final String city =  getRandomCityByState(state);
    public final String stateAndCity = state + " " + city;

    public String getRandomCityByState(String state) {
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
}
