public class Bus2 {
    private int capacity;
    Passenger[] passengers;
    int nextSeat;

    public Bus2(){
        this.capacity = 40;
        this.passengers = new Passenger[40];
    }

    public Bus2(int cap){
        this.capacity = cap;
        this.passengers = new Passenger[cap];
    }

    public void addPassenger(Passenger p){
        if (nextSeat != this.passengers.length){
            passengers[nextSeat] = p;
        }
        else{
            System.out.println("No more room on the bus");
        }
    }

    public int numberOfPassengers(){
        return (nextSeat + 1);
    }

    //quicksort will complete the sorting process in O(n*logn)


    // 2 | TIME COMPLEXITY
    // O(n)
    // O(n^2)
    //

    // 3 | DEBUGGING

    //public Whatever(int data) {
    // ## change to int
    //this.data = data;
    // ## add this
    //public void setData(int newData) {
    // ## remove static because it wouldn't be accessible by objects
    //this.data = newData;
    // ## add this


    // need to convert data to an int before adding
    // could change the s.hasNext() to data != "stop".
    //      initializing data to something else before loop starts


    // need new for butter
    // need to create a method for adding elements to the recipe array
    // the loop does 4 iterations, only 3 placed values, unknown output

    //4 | COMPREHENSION
    //

}
