package app;

import objects.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cedric on 9/9/14.
 */
public class CocCalc
{
    static List<CollectionAsset> banks;
    static List<ProductionAsset> workers;



    public static void main( String[] args )
    {
        System.out.println("Welcome chief!");
        boolean isDone = false;
        banks = new LinkedList<CollectionAsset>();
        workers = new LinkedList<ProductionAsset>();
        while(!isDone)
        {
            addAsset();
            System.out.println("Are you done, my chief? (y or n)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String verifier = br.readLine();
                verifier = verifier.toUpperCase().trim();
                if (verifier.charAt(0) == 'Y')
                {
                    isDone = true;
                }
            }
            catch (Exception e)
            {
                isDone = true;
            }
        }

        System.out.println("Your workers can produce " + getTotalProductionRate(Resources.ELIXIR) + " elixir an hour");
        System.out.println("Your workers can hold up to " +
                getTotalProductionStorage(Resources.ELIXIR) + " elixir (max) at one time");
        System.out.println("Your workers can work up to " +
                getTotalProductionStorage(Resources.ELIXIR)/getTotalProductionRate(Resources.ELIXIR) + " hours without collection of elixir") ;//TODO : Handle divide by 0 also use BigDecimal for result

        System.out.println("Your workers can produce " + getTotalProductionRate(Resources.GOLD) + " gold an hour");
        System.out.println("Your workers can hold up to " + getTotalProductionStorage(Resources.GOLD) + " gold (max) at one time");
        System.out.println("Your workers can work up to " +
                getTotalProductionStorage(Resources.GOLD)/getTotalProductionRate(Resources.GOLD) + " hours without collection of gold"); //TODO : Handle divide by 0 also use BigDecimal for result

        System.out.println("Your workers can produce " + getTotalProductionRate(Resources.DARK_ELIXIR) + " dark elixir an hour");
        System.out.println("Your workers can hold up to " +
                getTotalProductionStorage(Resources.DARK_ELIXIR) + " dark elixir (max) at one time");
        System.out.println("Your workers can work up to " +
                getTotalProductionStorage(Resources.DARK_ELIXIR)/getTotalProductionRate(Resources.DARK_ELIXIR) + " hours without collection of dark elixir");//TODO : Handle divide by 0 also use BigDecimal for result
        System.out.println("Good Bye Sir!");
    }

    private static Integer getTotalProductionStorage(Resources resources)
    {
        Integer result = 0;
        for(ProductionAsset worker : workers)
        {
            if(worker.getAssetType().equals(resources))
                result += worker.getAssetTotalCapacity();
        }
        return result;
    }


    private Integer getTotalBankStorage(Resources resources)
    {
        Integer result = 0;
        for(CollectionAsset bank : banks)
        {
            if(bank.getAssetType().equals(resources))
            result += bank.getAssetTotalCapacity();
        }
        return result;
    }

    private static Integer getTotalProductionRate(Resources resources)
    {
        Integer result = 0;
        for(ProductionAsset worker : workers)
        {
            if(worker.getAssetType().equals(resources))
                result += worker.getAssetTotalProductionRate();
        }
        return result;
    }

    private static void addAsset()
    {
        System.out.println("Which type of asset would you like to add ?");
        System.out.println("Producing Assets = P");
        System.out.println("Storage Assets = S");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String verifier = br.readLine();
            verifier = verifier.toUpperCase();
            switch (verifier.charAt(0))
            {
                case 'P': addProducingAsset();
                          break;
                case 'S': System.out.println("No Storage Assets At this Moment");
                          break;
            }
        } catch (IOException e) {
            System.out.println("Issue with that choice.");
        }

    }

    private static void addProducingAsset()
    {
        System.out.println("Which producing asset would you like to add ?");
        System.out.println("Gold Mine = G");
        System.out.println("Dark Elixir Drill = D");
        System.out.println("Elixir Collector = E");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String verifier = br.readLine();
            verifier = verifier.toUpperCase();
            switch (verifier.charAt(0))
            {
                case 'D': createProducingAsset(Resources.DARK_ELIXIR);
                    break;
                case 'E': createProducingAsset(Resources.ELIXIR);
                    break;
                case 'G': createProducingAsset(Resources.GOLD);
                    break;
            }
        } catch (IOException e)
        {
            System.out.println("Issue with that choice.");
        }
    }

    private static void createProducingAsset(Resources resources)
    {
        ProductionAsset asset = null;
        System.out.println("What Level ?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String verifier = null;
        try {
                 verifier = br.readLine();
            Integer level = Integer.parseInt(verifier);
            System.out.println("How many ?");
            verifier = br.readLine();
            Integer quantity = Integer.parseInt(verifier);
            switch (resources)
            {
                case DARK_ELIXIR: asset = new ProductionAsset(CocStatsData.DARK_ELIXIR_DRILL, quantity, level);
                                  break;
                case ELIXIR: asset = new ProductionAsset(CocStatsData.ELIXIR_COLLECTOR, quantity, level);
                    break;
                case GOLD: asset = new ProductionAsset(CocStatsData.GOLD_MINE, quantity, level);
                    break;
            }
            if(asset != null)
            {
                workers.add(asset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
