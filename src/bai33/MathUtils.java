package bai33;

public class MathUtils {
    public int sum(int a, int b) {
        return a + b;

    }

    public static void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5,5));
        //System.out.println(m.sum(5,5)); lỗi vì compile theo MathUtils có dạng int,int chứ ko p dạng double,double
    }
}
class AdvancedMath extends MathUtils{
    @Override
    public int sum(int a,int b){
        return a+b+10;
    }
    public double sum(double a,double b){
        return a+b;

    }
}