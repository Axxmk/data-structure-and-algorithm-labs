package theater;

public class Theater {
    public static void main(String[] args) {
        Seat s1 = new Seat();
        System.out.println(s1.getNumber() + ", " + s1.price + ", " + s1.status);

        Seat s2 = new Seat();
        System.out.println(s2.getNumber() + ", " + s2.price + ", " + s2.status);

        System.out.println(s1.getNumber() + ", " + s1.seatNumber + ", " + s2.seatNumber);

        Seat s3 = new Seat(1000, "VIP", "Reserved");
        System.out.println(s3.seatNumber + ", " + s3.status + ", " + s3.price);

        Customer c1 = new Customer("John", "John@gmail.com", "0678905678", (short)20, 'm');
        System.out.println(c1.toString());

        Movie m1 = new Movie("Wonder Woman 1987", "PG13");
        m1.addSeat(s1);
        m1.addSeat(s2);
        System.out.println(m1.getTitle() + ", " + m1.numberOfSeats);
        m1.addSeat(s3);
        Seat s4 = new Seat(300, "Honeymoon", "empty");
        m1.addSeat(s4);
        m1.showEmptySeat();
    }
}
