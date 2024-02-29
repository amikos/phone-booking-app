package app;

/**
 * Listener for mobile actions.
 * For notify users about changes (booked, returned, etc.)
 */
public interface PhoneBookingListener {

    void listen(String message);

}
