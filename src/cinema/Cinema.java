package cinema;

import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Write your code here
        Rooms room = createRoom();
        cinema(room);
        scanner.close();
    }

    static void cinema(Rooms room) {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        var answer = scanner.nextInt();

        switch (answer) {
            case 1:
                room.printRoom();
                cinema(room);
                break;
            case 2:
                createPrice(room);
                cinema(room);
                break;
            case 3:
                room.statistics();
                cinema(room);
                break;
            case 0:
                return;
            default:
                cinema(room);
        }
    }
    
    static Rooms createRoom() {
        System.out.println("Enter the number of rows:");
        var height = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        var width = scanner.nextInt();
        Rooms room = new Rooms(height, width);
        room.pushRoom();
        return room;
    }

    static void createPrice(Rooms room) {
        System.out.println("Enter a row number:");
        var row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        var column = scanner.nextInt();
        if (!room.checkPrice(row, column))
            createPrice(room);
        else
            System.out.println("Ticket price: $" + room.price(row, column));
    }
}
