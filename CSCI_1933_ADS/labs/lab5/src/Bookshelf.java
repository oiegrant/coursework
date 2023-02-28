public class Bookshelf {
    private Book[] books;
    private int nextEmpty = 0;

    //No argument constructor for bookshelf
    public Bookshelf() {
        books = new Book[20];
        this.setNextEmpty();
    }

    public Bookshelf(int numBooks) {
        books = new Book[numBooks];
        this.setNextEmpty();
    }

    public Bookshelf(Book[] bookArr) {
        books = bookArr;
        this.setNextEmpty();
    }

    public boolean add(Book newBook) {
        int temp;
        if (!(nextEmpty == books.length)) {
            books[nextEmpty] = newBook;
            this.setNextEmpty();
            return true;
        } else {
            return false;
        }

    }

    public void setNextEmpty() {
        boolean emptyExists = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                nextEmpty = i;
                emptyExists = true;
                break;
            }
        }
        if (!emptyExists) {
            nextEmpty = books.length;
        }

    }

    public Bookshelf getBooksByAuthor(String author) {
        int counter = 0;
        for (Book book : this.books) {
            if (book.getAuthor() == author) {
                counter++;
            }
        }
        Bookshelf temp = new Bookshelf(counter);
        for (int i = 0; i < counter; i++) {
            if (this.books[i].getAuthor() == author) {
                temp.books[i] = this.books[i];
            }
        }
        return temp;
    }

    public String toString() {
        String retString = "";
        for (int i = 0; i < nextEmpty; i++) {
            retString += books[i].toString() + "\n";
        }
        return retString;
    }

    public void sort(char sortBy) {
        int i, j;
        Book temp;
        boolean swapped = true;

        for (i = 0; i < nextEmpty && swapped == true; i++) {
            swapped = false;
            for (j = 1; j < nextEmpty; j++) {
//                if(books[j] == null){
//                    continue;
//                }
                if (books[j].compareTo(books[j - 1], sortBy) < 0) {
                    swapped = true;
                    temp = books[j];
                    books[j] = books[j - 1];
                    books[j - 1] = temp;
                }
            }
        } // end for loop
    } // end sort
}

