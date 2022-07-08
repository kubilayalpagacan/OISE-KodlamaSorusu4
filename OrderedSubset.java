import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderedSubset {
    int[] removeFirstElement(int[] sayilar) {
        List<Integer> arrayList = new ArrayList<>(sayilar.length);
        for (int i : sayilar) {
            arrayList.add(Integer.valueOf(i));
        }
        arrayList.remove(0);
        int[] newArray = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            newArray[i] = arrayList.get(i);
        }
        return newArray;
    }

    boolean siraliAltKumeVarMi(int[] sayilar, int ulasilacakToplam) {
        OrderedSubset nsn2 = new OrderedSubset();
        int temp = 0;
        for (int i = 0; i < sayilar.length; i++) {
            temp += sayilar[i];
            if (temp==ulasilacakToplam)
                return true;

            else {
                int[] sayilar2 = nsn2.removeFirstElement(sayilar);
                if (siraliAltKumeVarMi(sayilar2, ulasilacakToplam)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of Array Elements: ");
        int length = scan.nextInt();
        int[] sayilar = new int[length];
        System.out.println("Enter the Elements of Array");
        for (int i = 0; i < length; i++) {
            sayilar[i] = scan.nextInt();
        }
        System.out.println("Your array is: ");
        for (int sayi : sayilar) {
            System.out.print(sayi + " ");
        }
        System.out.println("\nEnter the number you want to reach: ");
        int number = scan.nextInt();
        OrderedSubset nsn = new OrderedSubset();
        System.out.println(nsn.siraliAltKumeVarMi(sayilar, number));
    }

}
