import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CashRegister {
  public static final String RECEIPTS_PATH = "./outstandingReceipts.txt";
  //When I launch the cash register, it asks me how much money I have

  public static void main(String[] args) throws IOException {
    double startingAmount = getMoneyValue("Hello, what is the starting balance in your drawer?");
    System.out.println(startingAmount);
//    System.out.println("How much money do you have in the register?");
//    Scanner scanner = new Scanner(System.in);
//    String userInput = scanner.nextLine();
////    if (userInput.isEmpty()) {
////      System.out.println("Please enter an amount");
////      System.exit(0);
////    }
//    while (userInput.isEmpty()) {
//      System.out.println("Please enter and amount. Please enter a valid amount");
//      userInput = scanner.nextLine();
//    }
//
//    double startingAmount = Double.parseDouble(userInput);
//    System.out.println(userInput);


    File receiptFile = new File(RECEIPTS_PATH);
    Scanner scanFromFile = new Scanner(receiptFile);
    while (scanFromFile.hasNextLine()) {
      String currentLine = scanFromFile.nextLine();
      double currentAmount = Double.parseDouble(currentLine);
      startingAmount += currentAmount;
    }
    System.out.println(startingAmount);
    //getMoneyValue("Hello");

    double customerOrder = getMoneyValue("How much is the customer's order?");
    double cashReceived = getMoneyValue("Amount of cash received:");
    System.out.println(cashReceived);

    while (customerOrder > cashReceived) {
      cashReceived = getMoneyValue("Not enough. Please pay more!");
    }

    double change = cashReceived - customerOrder;

    while (change > startingAmount || change < 0) {
      if (change > 0) {
        cashReceived = getMoneyValue("Please provide money closer to amount due.");
      } else{
        cashReceived = getMoneyValue("Not enough dinero");
      }
      change = cashReceived - customerOrder;
    }
    System.out.println(change);
    if (change > 0) {
      System.out.println("here's your change");
    } else {
      System.out.println("gold star status for having the correct change");
    }

  }

  public static double getMoneyValue(String prompt) {
    System.out.println(prompt);
    Scanner moneyScanner = new Scanner(System.in);
    String userInput = moneyScanner.nextLine();
    while (userInput.isEmpty()) {
      System.out.println("Invalid input" + prompt);
      userInput = moneyScanner.nextLine();
    }

    double moneyValue = Double.parseDouble(userInput);
    return moneyValue;

  }

}


















