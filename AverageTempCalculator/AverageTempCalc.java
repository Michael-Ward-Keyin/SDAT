
import java.util.Scanner;

public class AverageTempCalc {
    int arr[] = null;

    public AverageTempCalc(int sizeOfArray){
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int valueToInsert){
        try {
            if (arr[location] == Integer.MIN_VALUE){
                arr[location] = valueToInsert;

                System.out.println("Successfully Inserted");
            } else {
                System.out.println("The location is already occupied");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array"+ e);
        }
    }

    public double calcAverage() {
        int totalTemp = 0;
        int amount = 0;
        for (int value : arr) {
            if (value != Integer.MIN_VALUE) {
                totalTemp += value;
                amount++;
            }
        }
        return ( amount > 0 ) ? (double) totalTemp / amount : 0;
    } 

    public int aboveAverage(double average) {
        int amount = 0;
        for (int value : arr) {
            if (value > average) {
                amount++;
            }
        }
        return amount;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int numDays = 5;

        AverageTempCalc temps = new AverageTempCalc(numDays);
        for (int i = 0; i < numDays; i++) {
            System.out.print("Enter temperature for day " + (i + 1) + ": ");
            int temp = scanner.nextInt();
            temps.insert(i, temp);
        }
        

        double average = temps.calcAverage();
        System.out.println("Average temperature: " + average);

        int aboveAverage = temps.aboveAverage(average);
        System.out.println("Days above average: " + aboveAverage);

        scanner.close();

    }

}