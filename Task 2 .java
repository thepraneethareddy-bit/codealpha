import java.util.ArrayList;
import java.util.Scanner;
class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}
class Reservation {
    String customerName;
    Room room;

    Reservation(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initializeRooms();

        while (true) {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    viewReservations();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Create sample rooms
    static void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    // View available rooms
    static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.category + ")");
            }
        }
    }

    // Book a room
    static void bookRoom() {
        System.out.print("Enter your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter room number to book: ");
        int number = scanner.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == number && !r.isBooked) {
                r.isBooked = true;
                reservations.add(new Reservation(name, r));
                System.out.println("Room booked successfully!");
                return;
            }
        }

        System.out.println("Room not available.");
    }

    // Cancel reservation
    static void cancelReservation() {
        System.out.print("Enter room number to cancel: ");
        int number = scanner.nextInt();

        for (Reservation res : reservations) {
            if (res.room.roomNumber == number) {
                res.room.isBooked = false;
                reservations.remove(res);
                System.out.println("Reservation cancelled.");
                return;
            }
        }

        System.out.println("Reservation not found.");
    }

    // View all reservations
    static void viewReservations() {
        System.out.println("\nCurrent Reservations:");
        for (Reservation r : reservations) {
            System.out.println("Customer: " + r.customerName +
                    " | Room: " + r.room.roomNumber +
                    " | Type: " + r.room.category);
        }
    }
}