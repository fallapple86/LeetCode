import java.util.DoubleSummaryStatistics;

/**
 * Created by qpan on 9/4/2017.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows < 1){
            return "Value Error";
        }


        char[] ch = s.toCharArray();

        int loop = s.length() / (2 * numRows - 2);
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i = 0; i< stringBuilders.length; i++){
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;
        for (int i = 0; i < loop; i++){
            for(int j = 0; j< numRows && index < s.length(); j++){
                stringBuilders[j].append(ch[index]);
                index ++;
            }
            for(int j = numRows - 2; j > 0 && index < s.length(); j--){
                stringBuilders[j].append(ch[index]);
                index ++;
            }
        }

        String result = "";
        for(StringBuilder sb :stringBuilders){
            result += sb.toString();
        }

        return result;
    }


    public static void CalChiSquare(double c1, double c2, double c12, int N){
        double O11 = c12;
        double O12 = c2 - c12;
        double O21 = c1 - c12;
        double O22 = N - O11 - O12 - O21;

        double chi = N * Math.pow((O11 * O22 -O12 * O21), 2)/ ((O11 + O12)*(O11+O21)*(O12 +O22)*(O21+O22));
        System.out.println(chi);
    }

    public static void CalT_Test(double c1, double c2, double c12, int N){

        double x_bar = c12/N;
        double mu = (c1/N) * (c2/N);
        double sigma = x_bar * (1 - x_bar);

        double t = (x_bar - mu) / Math.sqrt(sigma/N);

        System.out.println(t);
    }

    private static double likelihoodratio(double k, double n, double x){
        double likelihood = Math.pow(x, k) * Math.pow(1-x, n -k);
        return likelihood == 0? 0 : Math.log(likelihood);
    }
    public static void CalculateLikelihoodRatio(double c1, double c2, double c12, int N) {
        double p = c2 / N;
        double p1 = c12 / c1;
        double p2 = (c2 - c12) / (N - c1);


        double log_lambda = likelihoodratio(c12, c1, p) + likelihoodratio(c2 - c12, N - c1, p) - likelihoodratio(c12, c1, p1) - likelihoodratio(c2 - c12, N - c1, p2);
        System.out.println(log_lambda);
    }

    public static void main(String[] args) throws Exception
    {
//        ZigZagConversion zigZagConversion = new ZigZagConversion();
//
//        String s = "PAYPALISHIRING";
//        String conversion = zigZagConversion.convert(s, 4);
//        System.out.println(conversion);

        double c1 = 15828;
        double c2 = 4675;
        double c12 = 8;
        int N = 14307668;

//        CalT_Test(c1, c2, c12, N);
//        CalChiSquare(c1, c2, c12, N);
        CalculateLikelihoodRatio(c1, c2, c12, N);
    }
}
