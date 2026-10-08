package bai32;

public class Animal {
    public void makeSound(){
        System.out.println("Animal sound");

    }
    public static void main(String[] args){
        Animal[] zoo =new Animal[4];
        zoo[0]=new Dog();
        zoo[1]=new Cat();
        zoo[2]=new Duck();
        zoo[3]=new Dog();
        for (Animal animal : zoo) {
            animal.makeSound();
        }
        //bai34    //1&2: không có lỗi bien dịch nhưng có lỗi Runtime khi chạy java
        Animal a=new Dog();// nếu mà dùng biến Dog thì đoạn ktra sau lỗi ngay
        if(a instanceof Cat){
            Cat c=(Cat) a;// giống ép kiểu trong ltnc
            c.makeSound();
        }else {
            System.out.println("Đây không phải là mèo");
        }
    }
}
class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Meows meows");

    }
}
class Duck extends Animal{

}
