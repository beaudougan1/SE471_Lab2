import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool {
    private final ObjectCreation_IF c;
    private int size;
    private int maxInstances;
    private BlockingQueue<Agent_IF> pool;
    private int instanceCount;

    public ObjectPool(ObjectCreation_IF c, int max) {
        this.c = c;
        this.maxInstances = max;
        this.size = 0;
        this.pool = new LinkedBlockingQueue<>(max);
        this.instanceCount = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapactiy(){
        return maxInstances;
    }

    public void setCapacity(int c) {
        this.maxInstances = c;
    }

    public synchronized <AGENT_IF> Agent_IF waitForObject() throws InterruptedException{
        if(pool.isEmpty() && instanceCount < maxInstances){
            AGENT_IF agent = (AGENT_IF) c.create();
            instanceCount++;
            return (Agent_IF) agent;
        }
        return pool.take();
    }

    public void release(Agent_IF agent) {
        pool.offer(agent);
    }
}
