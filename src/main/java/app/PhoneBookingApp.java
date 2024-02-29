package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Phone booking application.
 */
public class PhoneBookingApp {

    private final Map<PhoneModel, Phone> phones;
    private final List<PhoneBookingListener> listeners;

    /**
     * Set all mobile phones
     */
    public PhoneBookingApp() {
        this.phones = Arrays.stream(PhoneModel.values())
                .collect(Collectors.toMap(e -> e, Phone::new));
        this.listeners = new ArrayList<>();
    }

    /**
     * Add listener
     */
    public void addListener(PhoneBookingListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Remove listener
     */
    public void removeListener(PhoneBookingListener listener) {
        this.listeners.remove(listener);
    }

    public void bookPhone(PhoneModel phoneModel, String bookedBy) {
        Phone phone = phones.get(phoneModel);
        executeAction(new PhoneBookAction(phone, bookedBy));
        listeners.forEach((l) -> l.listen(phone.getInfo()));
    }

    public void returnPhone(PhoneModel phoneModel) {
        Phone phone = phones.get(phoneModel);
        executeAction(new PhoneReturnAction(phone));
        listeners.forEach((l) -> l.listen(phone.getInfo()));
    }

    public Phone getPhone(PhoneModel phoneModel) {
        return phones.get(phoneModel);
    }

    private void executeAction(PhoneAction phoneAction) {
        phoneAction.execute();
    }

    public void printAllPhoneInfo() {
        this.phones.values().forEach((e) -> System.out.println(e.getInfo()));
    }
}
