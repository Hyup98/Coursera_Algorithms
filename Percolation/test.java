/* *****************************************************************************
 *  Name:              Kang DongHyup
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Percolation test = new Percolation(10);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            test.print();
            System.out.print("\n");
            int a = scanner.nextInt();
            if(a == -1){
                break;
            }
            int b = scanner.nextInt();
            test.open(a,b);
            System.out.print("\n");
        }

    }
}
