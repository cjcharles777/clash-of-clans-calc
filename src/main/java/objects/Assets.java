package objects;

/**
 * Created by cedric on 9/9/14.
 */
public class Assets
{
    protected int quantity;
    protected ResourceCost resourceCost;
    protected int level;
    protected long buildTime;

    public Assets(int quantity, ResourceCost resourceCost, int level, long buildTime)
    {
        this.quantity = quantity;
        this.resourceCost = resourceCost;
        this.level = level;
        this.buildTime = buildTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ResourceCost getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(ResourceCost resourceCost) {
        this.resourceCost = resourceCost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(long buildTime) {
        this.buildTime = buildTime;
    }
}
