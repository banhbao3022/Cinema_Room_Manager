import java.util.*;

class FixingNullPointerException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string == "null") {
            System.out.println("NPE!");
        }
        else {
            System.out.println(string.toLowerCase());

        }
        /* Do not change code above */


    }
}