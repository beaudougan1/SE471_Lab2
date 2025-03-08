public class FBI_Agent_Creator implements ObjectCreation_IF{
    private int index = 0;
    private final String[] footPrints = {"@", "#", "$", "*", ".","?"};

    @Override
    public Object create() {
        FBI_Agent agent = new FBI_Agent(footPrints[index++ % footPrints.length]);
        new Thread(agent).start();
        return agent;
    }
}
