package all_java_concept.serialization_deserialization;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

/**
 * The Difference
 * When you use Serializable, Java uses Reflection under the hood to automatically inspect object fields and serialize them.
 * This is convenient, but reflection introduces CPU overhead and includes extra metadata in the binary output.
 *
 * Externalizable is a sub-interface of Serializable (java.io.Externalizable). It hands 100% of the serialization responsibility to you.
 * The JVM won't save or restore any field automatically—you must write every byte manually.
 */
public class Concept3Externalizable {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        UserAccount userAccount = new UserAccount(1, "John Doe", "john.doe@example.com");
        System.out.println(userAccount);

        // Serialization
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userAccount.ser"))){
            oos.writeObject(userAccount);
        }
        //Deserialization
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userAccount.ser"))){
            UserAccount userAccountDe = (UserAccount) ois.readObject();
            System.out.println("Deserializing UserAccount:");
            System.out.println(userAccountDe);
        }
    }

}

class UserAccount implements Externalizable{
    private static final long serialVersionUID = 1l;

    private int userId;
    private String userName;
    private String email;
    public UserAccount(){
        System.out.println("Public no-arg userAccount constructor called during deserialization.");
    }

    public UserAccount(int userId, String userName, String email){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(userId);
        out.writeUTF(userName);


    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("---Executing read external!");
        this.userId = in.readInt();
        this.userName = in.readUTF();


    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
