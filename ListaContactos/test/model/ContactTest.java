package model;

import exceptions.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    //El objeto es creado correctamente.
    @Test
    public void contactIsCreatedSuccessfullyTest(){
        Contact contact = new Contact("Andres", "156655");
        assertNotNull(contact);
        assertEquals(contact.getName(), "Andres");
        assertEquals(contact.getPhone(), "156655");
    }

    //Teléfono únicamente numérico.
    @Test
    public void contactNumberAsNumericTest(){
        boolean result = true;
        try{
            Contact contact = new Contact("Andres", "AAA", "d@g.com");
        }catch(InvalidNumberException ex){
            ex.printStackTrace();
            result = false;
        }
        assertFalse(result);
    }

    @Test
    public void contactEmailIsValidTest(){
        assertTrue(false);
    }
}
