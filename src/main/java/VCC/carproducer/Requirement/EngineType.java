package VCC.carproducer.Requirement;

public enum EngineType {
    ICE ("internal combustion engine"),
    BEV ("battery"),
    HYBRID ("hybrid");

    private String name;

    private EngineType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
