/* *****************************************************************************
 *  Name:              Kang DongHyup
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class test {
    public static void main(String[] args) {
        System.out.print("시작\n");
        PercolationStats test = new PercolationStats(10, 100);
        StringBuilder builder = new StringBuilder();
        builder.append("mean                                    = ")
               .append(test.mean())
               .append('\n');
        builder.append("stddev                                  = ")
               .append(test.stddev())
               .append('\n');
        builder.append("95% confidence interval                 = ")
               .append('[')
               .append(test.confidenceLo())
               .append(", ")
               .append(test.confidenceHi())
               .append(']');
        System.out.print(builder.toString());
        System.out.print("끝");
    }
}
