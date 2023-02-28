import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.io.FileWriter;
import java.util.Collection;


public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

        int owli = 0;

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] line = s.split(",");
            String tempName = line[0];
            int tempAge = Integer.parseInt(line[1]);
            double tempWeight = Double.parseDouble((line[2]));
            Owl tempOwl = new Owl(tempName,tempAge,tempWeight);
            data[owli] = tempOwl;
            owli++;
        }
        return numLines;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        populateData();
    }

    public double averageAge(){
        double sum = 0;
        if (data.length == 0){
            return -1;
        }
        else{
            for(Owl tempowl : data) {
                sum += tempowl.getAge();
            }
        }
        return (sum/this.popSize());
    }


    public Owl getYoungest(){
        int youngestAge=10000;
        int youngestIndex=0;
        for(int i=0; i<data.length; i++){
            if (data[i].getAge()<youngestAge) {
                youngestIndex = i;
                youngestAge = data[i].getAge();
            }
        }
        return data[youngestIndex];
    }

    public Owl getHeaviest(){
        double heaviestWeight=-10000;
        int heaviestIndex=0;
        for(int i=0; i<data.length; i++){
            if (data[i].getWeight()>heaviestWeight) {
                heaviestIndex = i;
                heaviestWeight = data[i].getWeight();
            }
        }
        return data[heaviestIndex];
    }

    public String toString(){
        Owl young = getYoungest();
        Owl heavy = getHeaviest();
        double avg = averageAge();
        System.out.println("Youngest Owl Name: " + young.getName() + ", Youngest Owl Age: " + young.getAge());
        System.out.println("Heaviest Owl Name: " + heavy.getName() + ", Heaviest Owl Age: " + heavy.getWeight());
        System.out.println("Average Age of all Owls: " + avg);
        return null;
    }

    public boolean containsOwl(Owl other){
        for(Owl owls : this.data){
            if (owls.equals(other)){
                return true;
            }
        }
        return false;
    }
	
    public void merge(OwlPopulation other) {
        // Implementing a Set
        HashSet<Owl> Owlset = new HashSet<Owl>();
        for (Owl owl : this.data){
            Owlset.add(owl);
        }

        for (Owl owl : other.data){
            boolean exists = false;
            for (Owl setItem : Owlset){
                if(owl.equals(setItem)){
                    exists = true;
                    break;
                }
            }

            if (!exists){
                Owlset.add(owl);
            }
        } // end for

        int newLen = Owlset.size();

        Owl[] newData = new Owl[newLen];
        int i = 0;
        for (Owl item : Owlset){
            newData[i++] = item;
        }
        this.data = newData;


    }



    public int popSize(){
        return data.length;
    }

    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());
            System.out.println(pop1.popSize());


            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
