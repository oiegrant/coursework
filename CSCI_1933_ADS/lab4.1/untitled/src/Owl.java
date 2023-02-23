public class Owl {
    private String name;
    private int age;
    private double weight;


    public Owl(String n, int a, double w){
        name = n;
        age = a;
        weight = w;
    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int a){
        age = a;
    }

    public double getWeight(){
        return weight;
    }
    public void setWeight(double w){
        weight = w;
    }

    public boolean equals(Owl other){
        if ((this.age == other.age) && (this.weight == other.weight) && (this.name.equals(other.name))) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Owl owl1 = new Owl("owl1",5,12.0);
        Owl owl2 = new Owl("owl2",5,12.0);
        Owl owl3 = new Owl("owl1",5,12.0);

        System.out.println(owl1.equals(owl2));
        System.out.println(owl1.equals(owl3));
    }


}
