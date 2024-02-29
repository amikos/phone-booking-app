package app;

/**
 * Mobile book action.
 */
public class PhoneBookAction implements PhoneAction {
    private final Phone phone;
    private final String bookedBy;

    public PhoneBookAction(Phone phone, String bookedBy) {
        this.phone = phone;
        this.bookedBy = bookedBy;
    }

    @Override
    public void execute() {
        this.phone.bookPhone(this.bookedBy);
    }
}
