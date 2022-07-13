package hn.fish;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Factor factor = new Factor();
        Delta delta = new Delta();
        List<Double> res = delta.getdeltaP();
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
