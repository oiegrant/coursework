import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class BookShelfReader {
    Bookshelf bs = new Bookshelf();


    public static Bookshelf readBooksFromFile(String fileName){
        Bookshelf bs = new Bookshelf();
        File f = new File(fileName);
        Scanner scanner = null;
        try{
        scanner = new Scanner(f);
        } catch (Exception e){
            System.out.println("File Not found");
        }

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] line = s.split(",");
            String tempTitle = line[0];
            String tempAuthor = line[1];
            double tempRating = Double.parseDouble(line[2]);
            Book tempBook = new Book(tempTitle,tempAuthor,tempRating);
            bs.add(tempBook);
        }
        return bs;
    }
    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p = null; // declare p outside try-catch block
        try {
            p = new PrintWriter(new File(fileName));
            p.println(b.toString());
            p.close();//if you do not close the file, the output file will remain
        } catch (Exception e) {
            System.out.println("Writing failed");
        }


    }
}
