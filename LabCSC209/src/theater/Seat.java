package theater;

public class Seat {
    static int number = 0;
    int seatNumber;
    double price;
    String type;
    String status;

    public Seat() {
        this.seatNumber = ++this.number;
        this.price = 0;
        this.type = "Regular";
        this.status = "Empty";
    }

    public Seat(double price, String type, String status) {
        this.seatNumber = ++this.number;
        this.price = price;
        this.type = type;
        setStatus(status);
    }

    public int getNumber() {
        return this.number;
    }

    public void setStatus(String status) {
        if (status.equalsIgnoreCase("empty") || status.equalsIgnoreCase("reserved") || status.equalsIgnoreCase("paid")) {
            this.status = status.toLowerCase();
        }
        else {
            this.status = "empty";
        }
    }
}
