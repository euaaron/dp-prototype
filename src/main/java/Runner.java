public class Runner {

    public static void askUserForInput(int number) throws CloneNotSupportedException {
        Fibonacci sequence = Fibonacci.getInstance();
        System.out.println("Enter the expected final number of the sequence: ");

        String env = System.getenv("env.PROD");

        if (env != null && env.equals("true")) {
            number = Integer.parseInt(System.console().readLine());
        }

        try {
            sequence.print(number);
        } catch(RuntimeException | CloneNotSupportedException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Conseguimos gerar " + sequence.getIterations() + " números da sequencia de Fibonacci.");
            System.out.println("O número máximo esperado era " + number + ".");
            if(!e.getMessage().contains("Atenção!")) {
                System.out.println("Try again.");
                askUserForInput(number);
            } else {
                throw e;
            }
        }
    }

}
