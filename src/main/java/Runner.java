public class Main {
    Fibonacci sequence = Fibonacci.getInstance();

    public void askUserForInput() {
        System.out.println("Enter the number of terms to generate: ");
        int n = Integer.parseInt(System.console().readLine());
        try {
            sequence.print(n);
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Try again.");
            askUserForInput();
        }
    }

    public static void Main(String[] args) {
        Main main = new Main();
        main.askUserForInput();
    }
}
