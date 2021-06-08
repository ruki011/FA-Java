import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest extends TestCase {

    @Test
    public void GetAllUsers(){
       User user = new User("Евгений",35, Sex.MALE);
       User user1 = new User("Мария",41, Sex.FAMALE);
       User user2 = new User("Петр",12, Sex.MALE);
        List<User> actual = User.getAllUsers();

        List<User> expected = new ArrayList<>();
        expected.add(user);
        expected.add(user1);
        expected.add(user2);

        Assert.assertArrayEquals(expected, actual);
    }

    public void testGetAllUsers() {
    }

    public void testTestGetAllUsers() {
    }

    public void testGetHowManyUsers() {
    }

    public void testTestGetHowManyUsers() {
    }
}