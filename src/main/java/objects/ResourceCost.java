package objects;

/**
 * Created by cedric on 9/9/14.
 */
public class ResourceCost
{
    private ResourceType type;
    private long amount;

    public ResourceCost(ResourceType type, long amount) {
        this.type = type;
        this.amount = amount;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
