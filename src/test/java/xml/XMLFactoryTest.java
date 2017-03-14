package xml;

import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class XMLFactoryTest {

    private String login;
    private String password;
    private String xmlUserResult = "<?xml version=\"1.0\" encoding=\"UTF-8\" " +
            "standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";


    public XMLFactoryTest() {
    }


    @Before
    public void setUp() throws Exception {
        login = "kowalski";
        password = "abc123";
    }

    @Test
    public void objectToXML() {
        XMLFactory<User> xmlFactory = new XMLFactory<>(User.class);
        User user = new User(login, password);
        String xmlUser = xmlFactory.objectToXML(user);
        System.out.println(xmlUser);
//        assertTrue(true);
        Assert.assertEquals("Error", getXmlUserResult(), xmlUser);
    }

    @Test
    public void xmlToObject() {
        XMLFactory<User> xmlFactory = new XMLFactory<>(User.class);
        User user = new User(login, password);
        User xmlUser = xmlFactory.xmlToObject(xmlUserResult);
        System.out.println(xmlUser);
//        assertTrue(true);
        Assert.assertTrue(user.equals(xmlUser));
    }


    public String getXmlUserResult() {
        return xmlUserResult;
    }


}
