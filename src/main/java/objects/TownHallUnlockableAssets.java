package objects;

import interfaces.Unlockable;

/**
 * Created by cedric on 9/9/14.
 */
public class TownHallUnlockableAssets extends Assets implements Unlockable
{
    protected int townHallLevelRequired;
    protected int maxNumofAsset;

    public TownHallUnlockableAssets(int quantity, ResourceCost resourceCost, int level, long buildTime, int townHallLevelRequired, int maxNumofAsset)
    {
        super(quantity, resourceCost, level, buildTime);
        this.townHallLevelRequired = townHallLevelRequired;
        this.maxNumofAsset = maxNumofAsset;

    }


    @Override
    public boolean isUnlocked(Assets assets)
    {
        if (assets instanceof  TownHall)
        {
            int townHallLevel = ((TownHall)assets).getLevel();
            return townHallLevel > townHallLevelRequired;
        }
        return false;

    }
}
