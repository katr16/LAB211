package common;

public class Library {
    public boolean checkOddEven(int a){
        return a%2 == 0;
    }
    
    public boolean perfectSquare(int a){
        return (int)Math.sqrt(a) * (int)Math.sqrt(a) == a;
    }
}