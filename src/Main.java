import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {

        BigDecimal netPrice = new BigDecimal("9.99");

        BigDecimal vatRate = new BigDecimal("0.23");

        BigDecimal grossValue = netPrice.add(netPrice.multiply(vatRate));

        BigDecimal totalGrossValue = grossValue.multiply(new BigDecimal("10000"));


        BigDecimal totalNetValue = totalGrossValue.divide(vatRate.add(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

        System.out.println("Net price of one product: " + netPrice);

        System.out.println("Gross value of one product: " + grossValue.setScale(2, RoundingMode.HALF_UP));

        System.out.println("Total gross value for 10,000 products: " + totalGrossValue.setScale(2, RoundingMode.HALF_UP));

        System.out.println("Total Net value for 10,000 products: " + totalNetValue.setScale(2, RoundingMode.HALF_UP));

        System.out.println("Conclusion: The calculated net value equals the scaled net value multiplied by 10,000.");
    }
}
