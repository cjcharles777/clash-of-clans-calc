package objects;

/**
 * Created by cedric on 11/26/14.
 */
public class CocStatsData
{
    private static final Integer[] ELIXIR_COLLECTOR_PRODUCTION_RATE = { 200,400,600,800,1000,1300,1600,1900, 2200, 2500, 3000 };
    private static final Integer[] ELIXIR_COLLECTOR_CAPACITY = { 500, 1000,1500,2500,10000, 20000, 30000, 50000, 75000,100000, 150000};
    private static final Resources ELIXIR_COLLECTOR_RESOURCE = Resources.ELIXIR;
    public static final ResourceProductionStats ELIXIR_COLLECTOR = new ResourceProductionStats(ELIXIR_COLLECTOR_CAPACITY, ELIXIR_COLLECTOR_PRODUCTION_RATE, ELIXIR_COLLECTOR_RESOURCE);

    private static final Integer[] GOLD_MINE_PRODUCTION_RATE = { 200,400,600,800,1000,1300,1600,1900, 2200, 2500, 3000 };
    private static final Integer[] GOLD_MINE_CAPACITY = { 500, 1000,1500,2500,10000, 20000, 30000, 50000, 75000,100000, 150000};
    private static final Resources GOLD_MINE_RESOURCE = Resources.GOLD;
    public static final ResourceProductionStats GOLD_MINE = new ResourceProductionStats(GOLD_MINE_CAPACITY, GOLD_MINE_PRODUCTION_RATE, GOLD_MINE_RESOURCE);

    private static final Integer[] DARK_ELIXIR_DRILL_PRODUCTION_RATE = { 20,30,45,60,80,100};
    private static final Integer[] DARK_ELIXIR_DRILL_CAPACITY = { 120, 240, 450, 720, 1120, 1600};
    private static final Resources DARK_ELIXIR_DRILL_RESOURCE = Resources.DARK_ELIXIR;
    public static final ResourceProductionStats DARK_ELIXIR_DRILL = new ResourceProductionStats(DARK_ELIXIR_DRILL_CAPACITY, DARK_ELIXIR_DRILL_PRODUCTION_RATE, DARK_ELIXIR_DRILL_RESOURCE);


    private static final Integer[] DARK_ELIXIR_STORAGE_CAPACITY = { 10000, 20000, 40000, 80000, 150000, 200000};
    private static final Resources DARK_ELIXIR_STORAGE_RESOURCE = Resources.DARK_ELIXIR;
    public static final ResourceCollectionStats DARK_ELIXIR_STORAGE = new ResourceCollectionStats(DARK_ELIXIR_STORAGE_CAPACITY, DARK_ELIXIR_STORAGE_RESOURCE);

    private static final Integer[] ELIXIR_STORAGE_CAPACITY = {1500, 3000, 6000, 12000, 25000, 50000, 100000, 250000, 500000, 1000000, 2000000};
    private static final Resources ELIXIR_STORAGE_RESOURCE = Resources.ELIXIR;
    public static final ResourceCollectionStats ELIXIR_STORAGE = new ResourceCollectionStats(ELIXIR_STORAGE_CAPACITY, ELIXIR_STORAGE_RESOURCE);

    private static final Integer[] GOLD_STORAGE_CAPACITY = {1500, 3000, 6000, 12000, 25000, 50000, 100000, 250000, 500000, 1000000, 2000000};
    private static final Resources GOLD_STORAGE_RESOURCE = Resources.ELIXIR;
    public static final ResourceCollectionStats GOLD_STORAGE = new ResourceCollectionStats(GOLD_STORAGE_CAPACITY, GOLD_STORAGE_RESOURCE);
}
