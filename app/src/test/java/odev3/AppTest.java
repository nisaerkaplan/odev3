
package odev3;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {


    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void testFound(){
        int array [] = {1,2,3,4,5};
        assertTrue(App.ToplamaIslemi(array,15));
    }

    @Test
    public void testNotFound(){
        int array [] = {1,2,3,4,5};
        assertFalse(App.ToplamaIslemi(array,5));
    }

     @Test
    public void testNull(){
        assertFalse(App.ToplamaIslemi(null,1));

    }
    @Test 
    public void testEmptyArray()
    {
        int array [] = {};
        assertFalse(App.ToplamaIslemi(array, 1));
    }
} 