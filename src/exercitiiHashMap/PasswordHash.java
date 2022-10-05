package exercitiiHashMap;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
    public static void main(String[] args)
    {
        String passwordToHash = "mama";
        String generatedPassword = null;

        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
    }

//    static public String getHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
//            SecureRandom random = new SecureRandom();
//            byte[] salt = new byte[16];
//            random.nextBytes(salt);
//            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
//            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//            byte[] hash = f.generateSecret(spec).getEncoded();
//            Base64.Encoder enc = Base64.getEncoder();
//            System.out.printf("salt: %s%n", enc.encodeToString(salt));
//            System.out.printf("hash: %s%n", enc.encodeToString(hash));
//            password = enc.encodeToString(hash);
//        return password;
//    }
}
