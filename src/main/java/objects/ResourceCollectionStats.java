package objects;

/**
 * Created by cedric on 11/26/14.
 */
public class ResourceCollectionStats
{
    Integer[] capacity;//per Level
    Resources resourceType;

    public ResourceCollectionStats(Integer[] capacity, Resources resourceType) {
        this.capacity = capacity;
        this.resourceType = resourceType;
    }

    public Integer[] getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer[] capacity)
    {
        this.capacity = capacity;
    }


    public Resources getResourceType()
    {
        return resourceType;
    }

    public void setResourceType(Resources resourceType)
    {
        this.resourceType = resourceType;
    }

    public Integer getCapacityAtLevel(Integer level)
    {
        return capacity[level-1];
    }
}
