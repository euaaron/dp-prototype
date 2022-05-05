import java.util.ArrayList;

public class Fibonacci {
    private static Fibonacci instance;
    private final ArrayList<Integer> fiboList;
    private int iterations;

    private Fibonacci() {
        iterations = 0;
        fiboList = new ArrayList<>();
    }

    public int getIterations() {
        return iterations;
    }

    private ArrayList<Integer> getFiboList() {
        return fiboList;
    }

    private void generateFiboList(int n) {
        iterations = 0;
        fiboList.clear();
        if (n > 0) {
            fiboList.add(0);
            fiboList.add(1);
            for (int i = 2; i < n; i++) {
                fiboList.add(fiboList.get(i-1) + fiboList.get(i-2));
                iterations++;
            }
        }
        checkInput(n);
    }

    private void checkInput(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be greater than 0.");
        } else {
            if (fiboList.contains(n)) {
                System.err.print(n + " is not in the Fibonacci sequence, we will generate until the closest minor value.");
            }
        }
    }

    private void printFiboList() throws CloneNotSupportedException {
        iterations = 0;
        for (Integer integer : fiboList) {
            System.out.println(integer);
            generateRandomBugs();
        }
        System.out.println();
    }

    public static Fibonacci getInstance() {
        if (instance == null) {
            instance = new Fibonacci();
        }
        return instance;
    }

    public void print(int n) throws CloneNotSupportedException {
        generateFiboList(n);
        printFiboList();
    }

    public static void generateRandomBugs() throws CloneNotSupportedException {
        ArrayList<Bug> bugList = new ArrayList<>();
        Bug spider = new Bug("O sistema parou de responder pois seu processador está muito quente!");
        Bug beetle = spider.clone();
        beetle.setMessage("O sistema está parou de responder pois está te ignorando!");
        Bug fly = beetle.clone();
        fly.setMessage("O sistema não está se sentindo bem! Procure auxílio de um técnico!");
        Bug cockroach = fly.clone();
        cockroach.setMessage("O sistema está parando de funcionar! Procure um técnico!");
        Bug pitty = cockroach.clone();
        pitty.setMessage("Pane no sistema, alguém me desconfigurou!");

        bugList.add(cockroach);
        bugList.add(spider);
        bugList.add(beetle);
        bugList.add(pitty);
        bugList.add(fly);

        for (Bug item : bugList) {
            int luckyNumber = (int) (Math.random() * 10);
            if(item.getId() == luckyNumber) {
                item.throwException();
            }
        }
    }

}
