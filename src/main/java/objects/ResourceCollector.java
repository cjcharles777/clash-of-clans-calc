package objects;

/**
 * Created by cedric on 9/9/14.
 */
public class ResourceCollector extends TownHallUnlockableAssets
{
    private int resourcePerHour;
    private ResourceType type;

    public ResourceCollector(int quantity, ResourceCost resourceCost, int level, long buildTime, int townHallLevelRequired,
                             int maxNumofAsset, int resourcePerHour, ResourceType type)
    {
        super(quantity, resourceCost, level, buildTime, townHallLevelRequired, maxNumofAsset);
        this.resourcePerHour = resourcePerHour;
        this.type = type;
    }

    public int getResourcePerHour() {
        return resourcePerHour;
    }

    public void setResourcePerHour(int resourcePerHour) {
        this.resourcePerHour = resourcePerHour;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }
}
