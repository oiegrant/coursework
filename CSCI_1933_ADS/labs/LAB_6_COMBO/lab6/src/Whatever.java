public class Whatever {
    private int data;
    public Whatever(int newData) {
        data = newData;
    }
    public void setData(int newData) {
        data = newData;
    }
    public int getData() {
        return data;
    }
    public static void doWhatever(Whatever w, int i, int d) {
        System.out.println("doWhatever(1): w: "+w.getData()+", i: "+i+"; d: "
                +d);
        w.setData(i);
        d = i;
        i = d;
        System.out.println("doWhatever(2): w: "+w.getData()+", i: "+i+"; d: "
                +d);
    }
    public static void main(String[] args) {
        Whatever w = new Whatever(1);
        int i = 2;
        double d = 3;
        System.out.println("main(1): w: "+w.getData()+", i: "+i+"; d: "+d);
        doWhatever(w, i, (int)d);
        System.out.println("main(2): w: "+w.getData()+", i: "+i+"; d: "+d);
        w = new Whatever(i);
        d = i / 4;
        System.out.println("main(3): w: "+w.getData()+", i: "+i+"; d: "+d);
    }
}
//main(1): w: 1, i: 2; d: 3.0
//doWhatever(1): w: 1, i: 2; d: 3
//doWhatever(2): w: 2, i: 2; d: 2
//main(2): w: 2, i: 2; d: 3.0
//main(3): w: 2, i: 2; d: 0.0