package app;

/**
 * Phone return action.
 */
public class PhoneReturnAction implements PhoneAction {
    private final Phone phone;

    public PhoneReturnAction(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void execute() {
        phone.returnPhone();
    }
}
