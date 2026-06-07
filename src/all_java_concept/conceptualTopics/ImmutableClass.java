package all_java_concept.conceptualTopics;

import java.util.Date;

/**
 * How to make a class Immutable
 */
public class ImmutableClass {
    public static void main(String[] args) {
        User user = new User("UTTAM1234", "uttam@gmail.com", new Date("12/01/1999"));
        System.err.println(user.toString());
    }
}


final class User{
    private final String username;
    private final String email;
    private final Date dateOfBirth;

    public User(String username, String email, Date dateOfBirth){
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }

    public Date getDateOfBirth(){
        return new Date(dateOfBirth.getTime());
    }

    @Override
    public String toString(){
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

}
