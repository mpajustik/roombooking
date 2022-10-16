package cinema;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {
    public static void createRoomSeats(char[][] roomArray, int numRows, int numSeats){
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for(int i = 0; i< numSeats; i++){
            System.out.print(" "+(i+1));
        }
        System.out.println();

        for(int i = 0;i<numRows; i++ ){
            System.out.print(i+1);
            for(int j = 0; j< numSeats; j++){
                System.out.print(" S");
                roomArray[i][j] = 'S';
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void printSeats(char[][] roomArray, int numRows, int numSeats){
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        //First numbers row
        for(int i = 0; i< numSeats; i++){
            System.out.print(" "+(i+1));
        }
        System.out.println();

        //Printing seats
        for(int i = 0;i<numRows; i++ ){
            System.out.print(i+1);
            for(int j = 0; j< numSeats; j++){
                System.out.print(" "+roomArray[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int buyTicket(char[][] roomArray, int numRows, int numSeats){
        int ticketPrice = 0;
        boolean rightToBuy=true;
        Scanner scanner = new Scanner(System.in);


        while(rightToBuy){
            System.out.println("Enter a row number:");
            int buyRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int buySeatNumber = scanner.nextInt();
            if(buyRow> numRows || buySeatNumber> numSeats){
                System.out.println("Wrong input!");
            } else if (roomArray[buyRow-1][buySeatNumber-1] == 'B' ) {
                System.out.println("That ticket has already been purchased!");
            } else {

                if(numRows * numSeats <= 60) {
                    ticketPrice = 10;
                    roomArray[buyRow-1][buySeatNumber-1] = 'B';
                }

                if(numRows * numSeats >60 ) {
                    if(buyRow <= numRows/2){
                        ticketPrice = 10;
                        roomArray[buyRow-1][buySeatNumber-1] = 'B';
                    } else if (buyRow > numRows/2) {
                        ticketPrice =8;
                        roomArray[buyRow-1][buySeatNumber-1] = 'B';
                    }
                }
                rightToBuy = false;
            }

        }

        System.out.println("Ticket price: $"+ticketPrice);

        return ticketPrice;
    }

    public static void statistics(char[][] roomArray, int numRows, int numSeats){
        DecimalFormat df = new DecimalFormat("0.00");
        int howManyBought = 0;
        double numberOfPurchased = 0;
        int totalSeats = numSeats*numRows;
        int firstHalfOfRows = 0;
        int secondHalfOfRows = 0;
        int totalTicketPrice = 0;
        int currentIncome = 0;
        if(numRows * numSeats >60 ){
            firstHalfOfRows = numRows/2;
            secondHalfOfRows = numRows-firstHalfOfRows;
            totalTicketPrice = firstHalfOfRows*numSeats*10 + secondHalfOfRows*numSeats*8;

            for(int i = 0;i<numRows; i++ ){
                for(int j = 0; j< numSeats; j++){
                    if(roomArray[i][j] == 'B' && i<=firstHalfOfRows-1) {
                        howManyBought++;
                        currentIncome +=10;
                    } else if (roomArray[i][j] == 'B' && i>firstHalfOfRows-1) {
                        currentIncome +=8;
                        howManyBought++;
                    }
                }
            }
        } else {
            totalTicketPrice = numRows*numSeats*10;
            for(int i = 0;i<numRows; i++ ){
                for(int j = 0; j< numSeats; j++){
                    if(roomArray[i][j] == 'B') {
                        currentIncome +=10;
                        howManyBought++;
                    }
                }
            }
        }

        numberOfPurchased = (double)howManyBought*100.00/(double)totalSeats;

        System.out.println("Number of purchased tickets: "+howManyBought);
        System.out.println("Percentage: "+df.format(numberOfPurchased)+"%");
        System.out.println("Current income: $"+currentIncome);
        System.out.println("Total income: $"+totalTicketPrice);


    }

    public static int roomAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsInRow = scanner.nextInt();
        char[][] room = new char[numberOfRows][numberOfSeatsInRow];
        boolean exit = true;
        // Write your code here
        /*
        System.out.println("Cinema:");
        System.out.println("   1 2 3 4 5 6 7 8");
        int rows = 7;
        int seatInRow = 8;
        */


        createRoomSeats(room, numberOfRows, numberOfSeatsInRow);

        while(exit){
            int nextAction = roomAction();
            if(nextAction == 1){
                printSeats(room, numberOfRows,numberOfSeatsInRow);
            }else if (nextAction == 2) {
                buyTicket(room, numberOfRows,numberOfSeatsInRow);
                printSeats(room, numberOfRows,numberOfSeatsInRow);
            } else if (nextAction == 0){
                exit = false;
            } else if (nextAction == 3) {
                statistics(room, numberOfRows, numberOfSeatsInRow);
            }
        }

        /*
        printSeats(room, numberOfRows,numberOfSeatsInRow);
        buyTicket(room, numberOfRows,numberOfSeatsInRow);
        printSeats(room, numberOfRows,numberOfSeatsInRow);
        */



        /*
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsInRow = scanner.nextInt();
        if(numberOfRows * numberOfSeatsInRow <= 60) {
            System.out.println("Total income:");
            System.out.println("$"+numberOfRows * numberOfSeatsInRow*10);
        }
        if(numberOfRows * numberOfSeatsInRow >60) {
            int firstHalfOfRows = numberOfRows/2;
            System.out.println(firstHalfOfRows);
            int secondHalfOfRows = numberOfRows-firstHalfOfRows;
            System.out.println(secondHalfOfRows);
            System.out.println("Total income:");
            System.out.println("$"+ (firstHalfOfRows*numberOfSeatsInRow*10 + secondHalfOfRows*numberOfSeatsInRow*8));
        }

         */
    }
}