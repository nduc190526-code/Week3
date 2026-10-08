package bai37;
import java.util.Scanner;
public class Hotel {
    public double total;
    protected int Nights;
    public Hotel(int Nights){
        this.Nights=Nights;
    }
    public double Tinhtien(){
        return total;
    }
}
class Standard extends Hotel {
    public Standard (int Nights){
       super(Nights);
    }
    @Override
    public double Tinhtien(){
        if(Nights>3)
            return 500000*Nights-500000*Nights*0.05;
        return 500000*Nights;
    }
    }
    class VIP extends Hotel{
    public VIP(int Nights){
        super(Nights);
    }
    @Override
        public double Tinhtien(){
        return 2000000*Nights;
    }
    }
class main {
    public static void main(String[] args) {
        int cs=1;
        System.out.println("Case "+cs+":");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String n = scanner.next();

            if (n.equals("S")) {
                int dem = scanner.nextInt();
                Standard m = new Standard(dem);
                System.out.println((long) m.Tinhtien());
                scanner.nextLine();
                cs++;
                System.out.println("Case "+cs+":");
            } else if (n.equals("V")) {
                int dem = scanner.nextInt();
                VIP m = new VIP(dem);
                System.out.println((long) m.Tinhtien());
                scanner.nextLine();
                cs++;
                System.out.println("Case "+cs+":");
            } else scanner.next();

        }
        scanner.close();
    }
}