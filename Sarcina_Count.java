import java.util.concurrent.Semaphore;
import java.util.Random;

public class Sarcina_Count implements Runnable {
    private final int processId;
    private final Memorie_Partajata memoriePartajata;
    private final Semaphore semaphore;
    private final Random random;

    public Sarcina_Count(int processId, Memorie_Partajata memoriePartajata, Semaphore semaphore) {
        this.processId = processId;
        this.memoriePartajata = memoriePartajata;
        this.semaphore = semaphore;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                int currentValue = memoriePartajata.getValue();

                if (currentValue >= 1000) {
                    semaphore.release();
                    break;
                }

                if (random.nextInt(2) == 1) {
                    int newValue = memoriePartajata.increment();
                    System.out.println("Proces " + processId + ": scrie " + newValue);
                }

                semaphore.release();
                Thread.sleep(random.nextInt(100));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Procesul " + processId + " a fost întrerupt: " + e.getMessage());
            }
        }
    }
}

