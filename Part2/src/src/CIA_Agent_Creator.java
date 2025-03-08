public class CIA_Agent_Creator implements ObjectCreation_IF{
    private int index = 0;
    private final String[] footPrints = {"@", "#", "$", "*", ".","?"};

    @Override
    public Object create() {
        CIA_Agent agent = new CIA_Agent(footPrints[index++ % footPrints.length]);
        new Thread(agent).start();
        return agent;
    }
}