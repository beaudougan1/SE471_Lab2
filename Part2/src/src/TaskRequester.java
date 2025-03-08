public class TaskRequester implements Runnable {
    private final ObjectPool pool;
    private final int taskID;

    public TaskRequester(ObjectPool pool, int taskID) {
        this.pool = pool;
        this.taskID = taskID;
    }

    @Override
    public void run() {
        try {
            Agent_IF agent = pool.waitForObject();
            agent.setTaskID(taskID);
            agent.startTask();
            Thread.sleep(2000);
            agent.stopTask();
            pool.release(agent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
