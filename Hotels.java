public class Hotels {
    private String type;


    public Hotels(String aType) {
        this.type = aType;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString()
    {
        return type;
    }
}
