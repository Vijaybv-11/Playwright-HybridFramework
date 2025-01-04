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

}
