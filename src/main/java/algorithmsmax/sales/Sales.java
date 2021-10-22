package algorithmsmax.sales;

import java.util.List;

public class Sales {

    /**
     * @return kiválasztja a legnagyobb árbevételt elért értékesítőt
     */
    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> sales) {

        Salesperson max = null;
        for (Salesperson sp : sales)
            if (max == null || max.getAmount() < sp.getAmount())
                max = sp;

        return max;

    }

    /**
     * @return kiválasztja azt az értékesítőt, aki a célt a legnagyobb összeggel meghaladta
     */
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> sales) {

        Salesperson max = null;
        for (Salesperson sp : sales)
            if (max == null || max.getDifferenceFromTarget() < sp.getDifferenceFromTarget())
                max = sp;

        return max;

    }

    /**
     * @return kiválasztja azt az értékesítőt, aki a legnagyobb összeggel alulmúlta a célt
     */
    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> sales) {

        Salesperson min = null;
        for (Salesperson sp : sales)
            if (min == null || min.getDifferenceFromTarget() > sp.getDifferenceFromTarget())
                min = sp;

        return min;

    }

}
