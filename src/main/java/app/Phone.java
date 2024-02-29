package app;

import java.time.LocalDateTime;

/**
 * Mobile phone.
 */
public class Phone {
    private final PhoneModel model;
    private String bookedBy;
    private LocalDateTime bookedAt;
    private boolean available;

    public Phone(PhoneModel model) {
        this.model = model;
        this.available = true;
    }

    public void bookPhone(String bookedBy) {
        if (!this.available) {
            System.err.println("Phone already booked");
            return;
        }

        this.bookedBy = bookedBy;
        this.bookedAt = LocalDateTime.now();
        this.available = false;
    }

    public void returnPhone() {
        if (this.available) {
            System.err.println("Phone already available");
            return;
        }

        this.bookedBy = null;
        this.bookedAt = null;
        this.available = true;
    }

    public String getInfo() {
        return String.format("%s - Available: %s, Booked by: %s, Booked at: %s",
                this.model, this.available ? "Yes" : "No",
                this.bookedBy, this.bookedAt);
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public boolean isAvailable() {
        return available;
    }

    public PhoneModel getModel() {
        return model;
    }
}
