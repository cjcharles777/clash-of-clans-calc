package objects;

/**
 * Created by cedric on 11/26/14.
 */
public class ProductionAsset
{
    private ResourceProductionStats stats;
    private Integer quantity;
    private Integer level;

    public ProductionAsset(ResourceProductionStats stats, Integer quantity, Integer level) {
        this.stats = stats;
        this.quantity = quantity;
        this.level = level;
    }

    public void initStats(ResourceProductionStats stats)
    {
        this.stats = stats;
    }

    public Integer getAssetTotalCapacity()
    {
        return stats.getCapacityAtLevel(level) * quantity;
    }
    public Integer getAssetTotalProductionRate()
    {
        return stats.getProductionPerHourRateAtLevel(level) * quantity;
    }

    public Resources getAssetType()
    {
        return  stats.getResourceType();
    }
}
