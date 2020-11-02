package cinema;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static int numRows;
    static int numEachRows;
    static char[][] room ;
    static int ticketPurchased = 0;
    static int currIncome = 0;
    static int totalIncome() {
        if (numEachRows * numRows <= 60){
            return numEachRows * numRows * 10;
        }
        else {
            int frontHaft = numRows / 2;
            int backHaft = numRows - frontHaft;
            return (frontHaft * numEachRows * 10 ) +
                    (backHaft * numEachRows * 8);
        }

    }
    static void makeCinema() {

        room = new char[numRows + 1][numEachRows + 1];
        for (int i = 0; i < numRows + 1; i++){
            for (int j = 0; j < numEachRows + 1; j++) {
                room[i][j] = 'S';
            }
        }
        for (int i = 0; i < numEachRows + 1; i++) {
            room[0][i] = Character.forDigit(i,10);
        }
        for (int i = 0; i < numRows + 1; i++) {
            room[i][0] = Character.forDigit(i,10);
        }
        room[0][0] = ' ';
    }
    static void printCinema() {
        System.out.println("Cinema:");
        for(int i = 0; i < numRows + 1; i++)
        {
            for(int j = 0; j < numEachRows + 1; j++)
            {
                System.out.print(room[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void buyTicket() {
        boolean check = false;
        do {
            System.out.println("Enter a row number:");
            int numRowChoice = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int numSeatRowChoice = sc.nextInt();

            if (numRowChoice > numRows || numRowChoice < 0 ||
                     numSeatRowChoice > numEachRows || numSeatRowChoice < 0) {
                System.out.println("Wrong input!");
            }
            else if (room[numRowChoice][numSeatRowChoice] == 'B') {
                System.out.println("That ticket has already been purchased!");
            }
            else {
                room[numRowChoice][numSeatRowChoice] = 'B';
                if (numEachRows * numRows <= 60) {
                    System.out.println("Ticket price: $10");
                    ticketPurchased += 1;
                    currIncome += 10;
                } else {
                    int frontHaft = numRows / 2;
                    if (numRowChoice <= frontHaft) {
                        System.out.println("Ticket price: $10");
                        ticketPurchased += 1;
                        currIncome += 10;
                    } else {
                        System.out.println("Ticket price: $8");
                        ticketPurchased += 1;
                        currIncome += 8;
                    }
                }
                printCinema();
                check = true;
            }
        } while (!check);


    }
    static void Statistics() {
        System.out.println("Number of purchased tickets:" + ticketPurchased);
        float percent = ticketPurchased / (numRows * numEachRows) * 100;
        System.out.printf("Percentage: %.2f%%\n",percent);
        System.out.printf("Current income: $%d\n",currIncome);
        System.out.printf("Total income: $%d\n", totalIncome());
    }
    static void menu() {
        System.out.println("Enter the number of rows:");
        numRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numEachRows = sc.nextInt();
        makeCinema();
        boolean check = false;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int chooseNum = sc.nextInt();
            switch (chooseNum) {
                case 1:
                    printCinema();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    Statistics();
                    break;
                case 0:
                    check = true;
                    break;
            }
        } while (!check);

    }

    public static void main(String[] args) {
        // Write your code here
        menu();

    }
}