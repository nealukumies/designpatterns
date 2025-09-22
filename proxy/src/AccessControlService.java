import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService accessControlService;
    private Map<String, Set<Integer>> userAccess;

    private AccessControlService() {
        userAccess = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (accessControlService == null) {
            accessControlService = new AccessControlService();
        }
        return accessControlService;
    }

    public void addUserAccess(String username, int documentId) {
        if (userAccess.containsKey(username)) {
            userAccess.get(username).add(documentId);
        } else {
            userAccess.put(username, Set.of(documentId));
        }
    }

    boolean isAllowed(String username, int documentId){
        return userAccess.containsKey(username) && userAccess.get(username).contains(documentId);
    }
}
