package zad1.a;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    int size;
    int[] buffer;
    boolean[] status;
    List<Integer> lastIndex;
    int wholeEmpty = 0;
    boolean wholeEmptyBoolean = true;

    public Buffer(int size){
        this.size=size;
        buffer = new int[size];
        status = new boolean[size];
        lastIndex = new ArrayList<>();

        for (int i = 0; i < status.length; i++) {
            status[i]=false;
        }
    }

    public int get(){
        wholeEmpty=0;

        int val;
        val = buffer[lastIndex.get(0)];
        status[lastIndex.get(0)] = false;
        lastIndex.remove(lastIndex.get(0));

        for (int i = 0; i < status.length; i++) {
            if(status[i]==false){
                wholeEmpty++;
                if(wholeEmpty==buffer.length){
                    wholeEmptyBoolean=true;
                }
            }
        }

        return val;
    }

    public void put(int n){
        wholeEmptyBoolean=false;
        boolean freePlace= false;
        int index=0;

        for (int i = 0; i < status.length; i++) {
            if(status[i]==false){
                freePlace=true;
                index=i;
            }
        }

        if(freePlace){
            buffer[index]=n;
            lastIndex.add(index);
            status[index]=true;
            System.out.println(Producer.counter++ + " Wstawiono wartość! " + n);
        }else{

        }
    }

    public boolean checkStopStart(){
        boolean b = true;
        for (int i = 0; i <status.length ; i++) {
            if(status[i]==false){
                b=false;
            }
        }
        //System.out.println("B False");
        return b;
    }
}
