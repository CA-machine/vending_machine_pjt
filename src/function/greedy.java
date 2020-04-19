//package swing;
//
//import java.util.Scanner;
//
//public class greedy {
//
//    public greedy(){
//        Scanner sc = new Scanner(System.in);
//
//        int hamburger = sc.nextInt();
//        int rice = sc.nextInt();
//        int noodle = sc.nextInt();
//        int charge = hamburger + rice + noodle;
//        int n500=0,n100=0,n50=0,n10=0;
//        while(charge >= 500) {
//            charge = charge - 500;
//            n500++;
//        }
//        while(charge >= 100) {
//            charge = charge - 100;
//            n100++;
//        }
//        while(charge >= 50) {
//            charge = charge - 50;
//            n50++;
//        }
//        while(charge >= 10) {
//            charge = charge - 10;
//            n10++;
//        }
//        System.out.println("500원 : " +n500+ "\n" +"100원 : " + n100 + "\n" + "50원 : " + n50 + "\n" + "10원 : " +n10);
//    }
//
//    public static void main(String[] arg){
//        greedy g = new greedy();
//
//    }
//
//}
package swing;


public class greedy {

    public greedy(int paid ,int hamburger,int rice, int noodle){

        int change = paid - (hamburger*5700 + rice*4500 + noodle*2340); // 음식들 가격
        int total_change = change;

        int  n10000=0,n5000=0,n1000=0,n500=0,n100=0,n50=0,n10=0;

        while(change>=10000)
        {
            change = change - 10000;
            n10000++;
        }
        while(change>=5000)
        {
            change = change - 5000;
            n5000++;
        }
        while(change>=1000)
        {
            change = change - 1000;
            n1000++;
        }
        while(change >= 500) {
            change = change - 500;
            n500++;
        }
        while(change >= 100) {
            change = change - 100;
            n100++;
        }
        while(change >= 50) {
            change = change - 50;
            n50++;
        }
        while(change >= 10) {
            change = change - 10;
            n10++;
        }

        System.out.println( "거스름돈 : :"+ total_change +"\n" +"10000원 : " +n10000+ "\n" +"5000원 : " +n5000+ "\n" +
                "1000원 : " +n1000+ "\n" +"500원 : " +n500+ "\n" +
                "100원 : " + n100 + "\n" + "50원 : " + n50 + "\n" +
                "10원 : " +n10 + "\n" + "1원 : " + change);
    }
}