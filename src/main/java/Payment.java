import java.text.NumberFormat;
import java.util.Locale;

public class Payment {

    public static void main(String[] args) {
        NumberFormat nfUSA = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nfIndia = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat nfChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nfFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat nfPoland = NumberFormat.getCurrencyInstance(new Locale("pl", "PL"));

        double amount = 12324.13415;
        System.out.println(nfUSA.format(amount));
        System.out.println(nfIndia.format(amount));
        System.out.println(nfChina.format(amount));
        System.out.println(nfFrance.format(amount));
        System.out.println(nfPoland.format(amount));
    }
}
