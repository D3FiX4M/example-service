package user_service_root.util;

import lombok.experimental.UtilityClass;
import user_service_root.core.exception.GlobalError;
import user_service_root.core.exception.GlobalException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UtilityClass
public class SHA1Generator {

    private final static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw GlobalException.of(GlobalError.PARSER_ERROR);
        }
    }

    public static String generateSHA1(String input) {
        byte[] digest = messageDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
