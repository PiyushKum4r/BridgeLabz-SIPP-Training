interface Executable {
    void execute();
}

class DataSyncJob implements Executable {
    public void execute() {
        System.out.println(" Executing data sync job...");
    }
}

class EmailAlertJob implements Executable {
    public void execute() {
        System.out.println(" Sending email alerts...");
    }
}

class CleanupJob implements Executable {
    public void execute() {
        System.out.println(" Performing system cleanup...");
    }
}

class JobQueue {
    private LinkedList<Executable> queue = new LinkedList<>();

    public void add(Executable job) {
        queue.addLast(job);
    }

    public void runAll() {
        while (!queue.isEmpty()) {
            queue.removeFirst().execute();
        }
    }
}

public class JobSystemTest {
    public static void main(String[] args) {
        JobQueue jobQueue = new JobQueue();

        jobQueue.add(new DataSyncJob());
        jobQueue.add(new EmailAlertJob());
        jobQueue.add(new CleanupJob());

        jobQueue.runAll();
    }
}


