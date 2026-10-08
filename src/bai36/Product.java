package bai36;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
public class Product {
    int ma;
    String ten;
    double giaGoc;

    public Product(int ma, String ten, double giaGoc) {
        this.ma = ma;
        this.ten = ten;
        this.giaGoc = giaGoc;
    }

    public double getFinalPrice() {
        return giaGoc;
    }
}

class Electronic extends Product {
    double pbh;
    public Electronic(int ma, String ten, double giaGoc, double pbh) {
        super(ma, ten, giaGoc);
        this.pbh = pbh;
    }

    @Override
    public double getFinalPrice() {
        return giaGoc + (giaGoc * 0.1) + pbh;
    }
}
class Food extends Product{
    LocalDate Date;
    public Food(int ma,String ten, double giaGoc,String Date){
        super(ma,ten,giaGoc);
        this.Date=LocalDate.parse(Date);
    }
    @Override
    public double getFinalPrice(){
        LocalDate now=LocalDate.of(2025,3,1);
        long left =ChronoUnit.DAYS.between(now,Date);
        if(left<7)
            return giaGoc*0.8;
        return giaGoc;
    }

}
 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Product> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String loai = sc.next();
            int ma = sc.nextInt();
            String ten = sc.next().replace("\"", "");
            double gia = sc.nextDouble();

            if (loai.equals("E")) {
                double pbh = sc.nextDouble();
                list.add(new Electronic(ma, ten, gia, pbh));
            } else {
                String han = sc.next();
                list.add(new Food(ma, ten, gia, han));
            }
        }

        double total = 0;

        for (Product p : list) {
            System.out.println(p.ten + " - " +
                    (p instanceof Electronic ? "Electronics" : "Food")
                    + " - " + p.getFinalPrice());

            total += p.getFinalPrice();
        }

        System.out.println("Total = " + total);
    }
}