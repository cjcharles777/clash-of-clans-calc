package objects;

/**
 * Created by cedric on 11/26/14.
 */
public class ResourceProductionStats
{
    Integer[] capacity;//per Level
    Integer[] productionPerHourRate; //per Level
    Resources resourceType;

    public ResourceProductionStats(Integer[] capacity, Integer[] productionPerHourRate, Resources resourceType) {
        this.capacity = capacity;
        this.productionPerHourRate = productionPerHourRate;
        this.resourceType = resourceType;
    }

    public Integer[] getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer[] capacity)
    {
        this.capacity = capacity;
    }

    public Integer[] getProductionPerHourRate()
    {
        return productionPerHourRate;
    }

    public void setProductionPerHourRate(Integer[] productionPerHourRate)
    {
        this.productionPerHourRate = productionPerHourRate;
    }

    public Resources getResourceType()
    {
        return resourceType;
    }

    public void setResourceType(Resources resourceType)
    {
        this.resourceType = resourceType;
    }

    public Integer getProductionPerHourRateAtLevel(Integer level)
    {
        return productionPerHourRate[level-1];
    }
    public Integer getCapacityAtLevel(Integer level)
    {
        return capacity[level-1];
    }
}
