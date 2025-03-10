public class CIA_Agent implements Agent_IF, Runnable {
    private boolean workingInProgress = false;
    private String myFootPrint;
    private int taskID;

    public CIA_Agent(String myFootPrint) {
        this.myFootPrint = myFootPrint;
    }

    @Override
    public void startTask() {
        workingInProgress = true;
    }

    @Override
    public void stopTask() {
        workingInProgress = false;
    }

    @Override
    public void setTaskID(int id) {
        this.taskID = id;
    }

    @Override
    public void run() {
       int spTaskID = taskID;
        while (workingInProgress) {
            System.out.println("CIA Agent " + myFootPrint + " is doing task " + spTaskID);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            workingInProgress = false;
            System.out.println("CIA Agent " + myFootPrint + " is done with task " + spTaskID);
        }
    }
}
