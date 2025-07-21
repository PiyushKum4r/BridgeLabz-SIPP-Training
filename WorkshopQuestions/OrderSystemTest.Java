interface Order {
    void process();
}

class OnlineOrder implements Order {
    private String orderId;

    public OnlineOrder(String orderId) {
        this.orderId = orderId;
    }

    public void process() {
        System.out.println(" Processing online order: " + orderId);
    }
}

class OfflineOrder implements Order {
    private String orderId;

    public OfflineOrder(String orderId) {
        this.orderId = orderId;
    }

    public void process() {
        System.out.println(" Processing offline order: " + orderId);
    }
}

class SubscriptionOrder implements Order {
    private String orderId;

    public SubscriptionOrder(String orderId) {
        this.orderId = orderId;
    }

    public void process() {
        System.out.println(" Processing subscription order: " + orderId);
    }
}

class OrderQueue {
    private LinkedList<Order> queue = new LinkedList<>();

    public void add(Order order) {
        queue.addLast(order);
    }

    public void processAll() {
        while (!queue.isEmpty()) {
            queue.removeFirst().process();
        }
    }
}

public class OrderSystemTest {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();

        orderQueue.add(new OnlineOrder("ORD001"));
        orderQueue.add(new OfflineOrder("ORD002"));
        orderQueue.add(new SubscriptionOrder("ORD003"));

        orderQueue.processAll(); // FIFO processing
    }
}


