package course_project.service.coder;

import java.util.Base64;
import java.util.Random;
import java.util.stream.Collectors;

public class Coder {

    //Method to encrypt sensitive user information using Base64 class
    public static String code(String input){

        String encodedString = Base64.getEncoder().encodeToString(input.getBytes());
        String result = addSalt(encodedString);
        return encodedString;

    }

    //Method to decrypt sensitive user information using Base64 class
    public static String decode(String input){

        String deSalt = dellSalt(input);

        byte[] decodedBytes = Base64.getDecoder().decode(deSalt);

        return new String(decodedBytes);

    }

    //A method that enhances the security of encrypted sensitive user information
    private static String addSalt(String input){

        String symbols = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        String salt = new Random().ints(10, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());

        String result = salt + input + salt;
        return result;

    }

    public static String dellSalt(String input){
        return input.substring(10, input.length()-10);
    }

}


