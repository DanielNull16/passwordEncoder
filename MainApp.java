import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Encode a message");
            System.out.println("2. Decode a message");
            System.out.println("3. View history (ArrayList)");
            System.out.println("4. View last two actions (2D Array)");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter message to encode: ");
                String encodeInput = scanner.nextLine();
                EncoderTool encoder = new Encoder();
                String encoded = encoder.process(encodeInput);
                System.out.println("Encoded: " + encoded);
                history.add("ENCODE: " + encoded);

            } else if (choice == 2) {
                System.out.print("Enter message to decode: ");
                String decodeInput = scanner.nextLine();
                EncoderTool decoder = new Decoder();
                String decoded = decoder.process(decodeInput);
                System.out.println("Decoded: " + decoded);
                history.add("DECODE: " + decoded);

            } else if (choice == 3) {
                System.out.println("History (ArrayList):");
                for (String entry : history) {
                    System.out.println(entry);
                }

            } else if (choice == 4) {
                System.out.println("Last two actions (2D Array):");
                String[][] lastTwo = new String[2][2];
                int size = history.size();
                for (int i = 0; i < 2; i++) {
                    if (size - 1 - i >= 0) {
                        String[] parts = history.get(size - 1 - i).split(": ", 2);
                        lastTwo[i][0] = parts[0];
                        lastTwo[i][1] = parts[1];
                    } else {
                        lastTwo[i][0] = "---";
                        lastTwo[i][1] = "---";
                    }
                }
                for (int i = 0; i < 2; i++) {
                    System.out.println(lastTwo[i][0] + " → " + lastTwo[i][1]);
                }

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
