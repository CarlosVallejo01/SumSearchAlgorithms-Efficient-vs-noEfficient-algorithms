import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class SumSearch {
    private  int arraySize;
    private  int numbersList[];
    private boolean result;
    private double elapsedTime;

    public  SumSearch(int size, int x) {
        arraySize = size;
        numbersList = new int[arraySize];
        fillArray();
        Stopwatch stopwatch = new Stopwatch();
        this.result = search(x);
        this.elapsedTime = stopwatch.elapsedTime();
    }

    public boolean getResult(){
        return this.result;
    }

    public double getElapsedTime(){
        return this.elapsedTime;
    }

    public boolean search(int x){

        for (int i = 0; i < arraySize; i++){
            for (int j = i + 1; j < arraySize; j++){
                if (numbersList[i] + numbersList[j] == x){
                    return true;
                }
            }
        }
        return false;
    }

    public  void fillArray(){
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++){
            this.numbersList[i] = rand.nextInt(10000);
        }
    }
}


class Main2{
    public static void main(String[] args){
        int size = 1000;
        while (true){
            SumSearch sumSearch = new SumSearch(size, -1);
            System.out.println("Tamaño de N: " + size + ", \nResultado: " + sumSearch.getResult() + ", \nTiempo transcurrido: " + sumSearch.getElapsedTime()+ "\n");
            size = size * 2;
        }

    }

}
