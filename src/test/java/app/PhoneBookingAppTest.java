package app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookingAppTest {

    /**
     * Test phone booking application
     */
    @Test
    public void testPhoneBooking() {
        PhoneBookingApp app = new PhoneBookingApp();

        //IPHONE_X is available
        assertTrue(app.getPhone(PhoneModel.IPHONE_X).isAvailable());

        //book IPHONE_X by User1
        app.bookPhone(PhoneModel.IPHONE_X, "User1");

        //IPHONE_X is not available
        assertFalse(app.getPhone(PhoneModel.IPHONE_X).isAvailable());
        //IPHONE_X is booked by User1
        assertEquals(app.getPhone(PhoneModel.IPHONE_X).getBookedBy(), "User1");

        //book IPHONE_X
        app.returnPhone(PhoneModel.IPHONE_X);

        //IPHONE_X is available again
        assertTrue(app.getPhone(PhoneModel.IPHONE_X).isAvailable());
    }

    /**
     * Test that phone already booked
     */
    @Test
    public void testAlreadyBookedError() {
        PhoneBookingApp app = new PhoneBookingApp();

        app.bookPhone(PhoneModel.NOKIA_3310, "User1");

        //booked by User1
        assertEquals(app.getPhone(PhoneModel.NOKIA_3310).getBookedBy(), "User1");

        app.bookPhone(PhoneModel.NOKIA_3310, "User2");

        //still booked by User1
        assertEquals(app.getPhone(PhoneModel.NOKIA_3310).getBookedBy(), "User1");
    }

    /**
     * Test phone getting
     */
    @Test
    public void testGetPhone() {
        PhoneBookingApp app = new PhoneBookingApp();

        Arrays.stream(PhoneModel.values()).forEach(
                (phoneModel) -> assertEquals(app.getPhone(phoneModel).getModel(),
                        phoneModel));
    }

}
