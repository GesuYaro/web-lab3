package shagiev.web3.util;

public class LoginGetter {

    public static String[] getLoginInfo(String envName) {
        String[] words = {};
        String raw = System.getenv(envName);
        if (raw != null) {
            words = raw.split(" ");
        }
        return words.length >= 5 ? words : null;
    }

}
