package secrets;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class APIKeyStore {

    private static HashMap<String, String> apiKeys = new HashMap<>();

    static {
        apiKeys.put("PROPUBLICA_API", "hxY9fxmPmO7Ev1UT6KUlbYaPVKM5v619B2DWRjIY");
// etc.
    }

    public static String getKey(String label) {
        if (apiKeys.containsKey(label)) {
            return apiKeys.get(label);
        } else {
            String excMsg = "No key for label \"" + label + "\"";
            throw new NoSuchElementException(excMsg);
        }
    }

}