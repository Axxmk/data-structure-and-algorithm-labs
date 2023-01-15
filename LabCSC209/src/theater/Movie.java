package theater;

public class Movie {
    String title;
    String rating;
    Seat[] seats;
    String[] showTimes;
    int numberOfSeats;

    public Movie(String title, String rating) {
        this.title = title;
        this.rating = rating;
        seats = new Seat[100];
        showTimes = new String[7];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void addSeat (Seat seat) {
        seats[numberOfSeats++] = seat;
    }

    public void showEmptySeat() {
        for(int i = 0; i < numberOfSeats; i++) {
            if (seats[i].status.equalsIgnoreCase("empty")) {
                System.out.println(seats[i].seatNumber + " " + seats[i].price);
            }
        }
    }
}
