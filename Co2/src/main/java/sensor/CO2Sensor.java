package sensor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    public class CO2Sensor implements Runnable {
        private Integer co2_value = 0;
        private String id;
        private final Object lock = new Object();
        ExecutorService executor = Executors.newFixedThreadPool(1);

        public CO2Sensor(String id) {
            this.id = id;
        }

        public void start() {
            this.executor.submit(this);
        }

        public void run() {
            new Random();

            while(true) {
                synchronized(this.lock) {
                    this.co2_value = (int)(300.0D + Math.random() * 2000.0D);
                }

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException var4) {
                    return;
                }
            }
        }

        public void stop() {
            this.executor.shutdownNow();
        }

        public Integer getValue() {
            synchronized(this.lock) {
                int v = this.co2_value;
                return v;
            }
        }

        public String getId() {
            return this.id;
        }
    }
