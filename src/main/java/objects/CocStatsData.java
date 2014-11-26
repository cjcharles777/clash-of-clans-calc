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

    private static final Integer[] DARK_ELIXIR_DRILL_PRODUCTION_RATE = { 200,400,600,800,1000,1300,1600,1900, 2200, 2500, 3000 }; //TODO : Add correct values
    private static final Integer[] DARK_ELIXIR_DRILL_CAPACITY = { 500, 1000,1500,2500,10000, 20000, 30000, 50000, 75000,100000, 150000}; //TODO : Add correct values
    private static final Resources DARK_ELIXIR_DRILL_RESOURCE = Resources.DARK_ELIXIR;
    public static final ResourceProductionStats DARK_ELIXIR_DRILL = new ResourceProductionStats(DARK_ELIXIR_DRILL_CAPACITY, DARK_ELIXIR_DRILL_PRODUCTION_RATE, DARK_ELIXIR_DRILL_RESOURCE);



}
