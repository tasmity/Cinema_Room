package cinema;

import java.util.Arrays;

public class Rooms {
    private final int height;
    private final int width;
    char[][] room;
    static int count = 0;
    static int current = 0;

    public Rooms(int height, int width) {
        this.height = height;
        this.width = width;
        room = new char[height + 1][width + 1];
    }

    public void pushRoom() {
        for (char[] in : room)
            Arrays.fill(in, 'S');
        for (var i = 0; i < room[0].length; i++)
            room[0][i] = (char)(i + '0');
        for (var i = 0; i < room.length; i++)
            room[i][0] = (char)(i + '0');
        room[0][0] = ' ';
    }

    public void printRoom() {
        System.out.println("Cinema:");
        for (char[] y : room) {
            for (char x : y) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public int totalIncome() {
        int income;
        if (height * width <= 60) {
            income = height * width * 10;
        } else {
            int rows = height / 2;
            income = rows * width * 10 + (height - rows) * width * 8;
        }
        return income;
    }

    public int price(int row, int colum) {
        int price;
        if (height * width <= 60) {
            price = 10;
            current +=10;
        }
        else {
            if ((height / 2) >= row) {
                price = 10;
                current += 10;
            } else {
                price = 8;
                current += 8;
            }
        }
        room[row][colum] = 'B';
        count++;
        return price;
    }

    public boolean checkPrice(int row, int colum) {
        if (row > height || colum > width) {
            System.out.println("Wrong input!");
            return false;
        } else if (room[row][colum] != 'S') {
            System.out.println("That ticket has already been purchased!");
            return false;
        }
        return true;
    }

    public void statistics() {
        System.out.println("Number of purchased tickets: " + count);
        System.out.printf("Percentage: %.2f%%%n", (double) 100 / (height * width ) * count);
        System.out.println("Current income: $" + current);
        System.out.println("Total income: $" + totalIncome());
    }
}
