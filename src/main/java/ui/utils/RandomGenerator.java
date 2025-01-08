package ui.utils;

import com.github.javafaker.Faker;

public class RandomGenerator {

   static Faker faker = new Faker();

    public static String firstName(){
        return faker.name().firstName();
    }
    public static String lastName(){
        return faker.name().lastName();
    }
    public static String emailId(){
        return faker.internet().safeEmailAddress();
    }
    public static String password(){
        return faker.internet().password();
    }
    public static String phoneNumber(){
        return faker.phoneNumber().cellPhone();
    }
    public static String country(){
        return faker.country().name();
    }
    public static String address(){
        return faker.address().streetAddress();
    }
    public static String pinCode(){
        return faker.address().zipCode();
    }
    public static String city(){
        return faker.address().city();
    }

}
