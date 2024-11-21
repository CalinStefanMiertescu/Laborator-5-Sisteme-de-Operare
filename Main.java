import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Memorie_Partajata memoriePartajata = new Memorie_Partajata();
        Semaphore semaphore = new Semaphore(1);

        Thread process1 = new Thread(new Sarcina_Count(1, memoriePartajata, semaphore));
        Thread process2 = new Thread(new Sarcina_Count(2, memoriePartajata, semaphore));

        process1.start();
        process2.start();

        try {
            process1.join();
            process2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Numărarea s-a terminat!");
    }
}

