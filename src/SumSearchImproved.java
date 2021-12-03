import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class SumSearchImproved {
    private  int arraySize;
    private  int numbersList[];
    private boolean result;
    private double elapsedTime;

    public  SumSearchImproved(int size, int x) {
        arraySize = size;
        numbersList = new int[arraySize];
        fillArray();
        Stopwatch stopwatch = new Stopwatch();
        //Arrays.sort(numbersList); //n log n
        this.result = search(x);
        this.elapsedTime = stopwatch.elapsedTime();

    }

    public boolean search(int x){
        Arrays.sort(numbersList);
        int key;
        for (int i = 0; i < this.arraySize; i++){
            key = x - numbersList[i];
            if (binarySearch(key) == key){
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int key) { //log n
        int lo = 0, hi = numbersList.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < numbersList[mid]) hi = mid - 1;
            else if (key > numbersList[mid]) lo = mid + 1;
            else return mid;
        }
        return key-1;
    }

    public  void fillArray(){
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++){
            this.numbersList[i] = rand.nextInt(10000);
        }
    }

    public boolean getResult(){
        return this.result;
    }

    public double getElapsedTime(){
        return this.elapsedTime;
    }

}


class Main3{
    public static void main(String[] args){
        int size = 1000;
        while (true){
            SumSearchImproved sumSearchImproved = new SumSearchImproved(size, -1);
            System.out.println("Tamaño de N: " + size + ", \nResultado: " + sumSearchImproved.getResult() + ", \nTiempo transcurrido: " + sumSearchImproved.getElapsedTime()+ "\n");
            size = size * 2;
        }

    }

}