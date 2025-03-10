public class CIA_Agent_App {
    public static void main(String[] args) {
        ObjectPool pool = new ObjectPool(new CIA_Agent_Creator(), 5);

        for (int i = 1; i <= 10; i++){
            new Thread(new TaskRequester(pool, i)).start();
        }
    }
}
