public class Polynomial {
    private double a;
    private double b;
    private double c;
    // private makes them inaccessible directly to the user of the program
    // this is provides encapsulation an important component of OOP

    public Polynomial(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA(){return this.a;}
    public double getB(){return this.b;}
    public double getC(){return this.c;}

    public Polynomial add(Polynomial p){
        Polynomial temp;
        double tempA;
        double tempB;
        double tempC;

        tempA = this.getA() + p.getA();
        tempB = this.getB() + p.getB();
        tempC = this.getC() + p.getC();

        temp = new Polynomial(tempA,tempB,tempC);

        return temp;
    }

    public String toString(){
        String temp = "";
        temp = " (" + this.getA() + ")x^2 + (" + this.getB() + ")x + (" + this.getC() +")";
        return temp;
    }

    public double evaluate(double x){
        return ( (this.getA()*x*x) + (this.getB()*x) + (this.getC()) );
    }

    public static void main(String[] args){
        double a = 3.0;
        double b = 2.0;
        double c = 1.0;
        Polynomial PolyOne = new Polynomial(a,b,c);
        Polynomial PolyTwo = new Polynomial(c,b,a);
        Polynomial PolyThree;
        System.out.println(PolyOne);
        System.out.println(PolyTwo);

        PolyThree = PolyOne.add(PolyTwo);
        System.out.println(PolyThree);

        System.out.println(PolyTwo.evaluate(2.0));
        System.out.println(PolyThree.evaluate(1.0));
    }

}
