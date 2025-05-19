import java.util.Scanner;

public class MovieTheatre {
    String[][] seats;

    public MovieTheatre(int numberOfRows, int numberOfColumns) {
        seats = new String[numberOfRows][numberOfColumns];
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                seats[row][col] = "open";
            }
        }
    }

    public void reserveSeat(int row, int col) {
        try {
            if (seats[row][col] == "open") {
                seats[row][col] = "reserved";
                System.out.println("Reserved seat: " + (row + 1) + (col + 1));
            } else {
                System.out.println("Seat taken.");
                suggestSeat();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid entry");
        }
    }

    public void suggestSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j].equals("open")) {
                    System.out.println("try seat " + (i + 1) + (j + 1));
                    return;
                }
            }
        }
    }

    public void chartSeats() {
        System.out.println("Seating Chart: ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + ":");
            for (int j = 0; j< seats[0].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void cancelSeat( int row, int col) {
        try {
            if (seats[row][col].equals("reserved")) {
                seats[row][col] = "open";
                System.out.println("Reservation cancelled for seat " + (row + 1) + (col + 1));
            } else {
                System.out.println("Seat already empty.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not a seat");
        }
    }

    public static void main(String[] args) {
        MovieTheatre theatre = new MovieTheatre(5,6);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theatre.chartSeats();
                    break;
                case 2:
                    System.out.print("Enter row (1-5): ");
                    int r = scanner.nextInt() - 1;
                    System.out.print("Enter col (1-6): ");
                    int c = scanner.nextInt() - 1;
                    theatre.reserveSeat(r, c);
                    break;
                case 3:
                    System.out.print("Enter row (1-5): ");
                    r = scanner.nextInt() - 1;
                    System.out.print("Enter col (1-6): ");
                    c = scanner.nextInt() - 1;
                    theatre.cancelSeat(r, c);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    
    }

}