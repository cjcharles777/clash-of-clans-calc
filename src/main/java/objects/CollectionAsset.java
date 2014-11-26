package objects;

/**
 * Created by cedric on 11/26/14.
 */
public class CollectionAsset
{
    private ResourceCollectionStats stats;
    private Integer quantity;
    private Integer level;



    public CollectionAsset(ResourceCollectionStats stats, Integer quantity, Integer level)
    {
        this.stats = stats;
        this.quantity = quantity;
        this.level = level;
    }

    public Integer getAssetTotalCapacity()

    {
       return stats.getCapacityAtLevel(level) * quantity;
    }

    public Resources getAssetType()
    {
        return  stats.getResourceType();
    }
}
