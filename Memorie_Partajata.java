import java.util.concurrent.atomic.AtomicInteger;

public class Memorie_Partajata {
    private final AtomicInteger value;

    public Memorie_Partajata() {
        this.value = new AtomicInteger(0);
    }

    public int getValue() {
        return value.get();
    }

    public int increment() {
        return value.incrementAndGet();
    }
}

