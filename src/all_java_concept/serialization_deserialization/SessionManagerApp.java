package all_java_concept.serialization_deserialization;

import java.io.*;
import java.sql.SQLOutput;
import java.time.Instant;

public class SessionManagerApp {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        File storangeFile = new File("user_session.ser");


        UserSession originalSession = new UserSession("user1", "admin", "auth_token_123");
        System.out.println("Original Session: " + originalSession);
    //Serialization of object
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(storangeFile))) {
            objectOutputStream.writeObject(originalSession);
            System.out.println("\n[+] Session Serialized and written to storage file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    // Deserialization of Object

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(storangeFile))) {
            UserSession deserializedSession = (UserSession) objectInputStream.readObject();
            System.out.println("\n[+] Session Deserialized: " + deserializedSession);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}


class UserSession implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String userRole;
    private Instant loginTime;

    private transient String authToken;

    public UserSession(String userId, String userRole, String authToken){
        this.userId = userId;
        this.userRole = userRole;
        this.authToken = authToken;
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();

        String encriptedToken = encryptToken(this.authToken);
        out.writeObject(encriptedToken);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();

        String encriptedToken = (String) in.readObject();
        this.authToken = decryptToken(encriptedToken);
    }
    private String encryptToken(String token) {
        // Simple placeholder for encryption logic (e.g., AES)
        return "ENC_" + token;
    }

    private String decryptToken(String encrypted) {
        // Simple placeholder for decryption logic
        return encrypted.replace("ENC_", "");
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userId='" + userId + '\'' +
                ", userRole='" + userRole + '\'' +
                ", loginTime=" + loginTime +
                ", authToken='" + authToken + '\'' +
                '}';
    }
}
