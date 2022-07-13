package hn.fish;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Delta {
    private List<List<List>> excel;

    private File file;

    private Factor factor;


    public Delta(){
        file = new File("D:\\temp\\res2.xls");
        excel = ReadExcel.readExcel(file);
        factor = new Factor();
    }

    //ΔCnet
    public List<Double> getdeltaC(){
        //sheet0
        List<List> sheet0 = excel.get(0);
        //全国那一行
        List row = sheet0.get(1);
        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row.size() - 1; i++){
            Double num0 = Double.parseDouble((String)row.get(i));
            Double num1 = Double.parseDouble((String)row.get(i+1));
            Double value = num1 - num0;
            System.out.println(num1 + " - " + num0 + " = " + value);
            res.add(value);
        }
        return res;
    }

    //L(t+1,t)
    public List<Double> getL(){
        //sheet0
        List<List> sheet0 = excel.get(0);
        //全国那一行
        List row = sheet0.get(1);
        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row.size() - 1; i++){
            Double num0 = Double.parseDouble((String)row.get(i));
            Double num1 = Double.parseDouble((String)row.get(i+1));
            Double value = (num1 - num0) / (Math.log(num1) - Math.log(num0));
            res.add(value);
        }
        return res;
    }

    //ΔN
    public List<Double> getdeltaN(){
        List<Double> l = getL();
        List<Double> oriN = factor.getN();
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < oriN.size() - 1; i++){
            Double lNum = l.get(i);
            Double ln = Math.log((oriN.get(i+1) / oriN.get(i)));
            Double value = lNum * ln;
            System.out.println(lNum + " * " + ln + " = " + value);
            res.add(value);
        }
        return res;
    }

    //ΔF
    public List<Double> getdeltaF(){
        List<Double> l = getL();
        List<Double> oriF = factor.getF();
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < oriF.size() - 1; i++){
            Double lNum = l.get(i);
            Double ln = Math.log((oriF.get(i+1) / oriF.get(i)));
            Double value = lNum * ln;
            System.out.println(lNum + " * " + ln + " = " + value);
            res.add(value);
        }
        return res;
    }

    //ΔE
    public List<Double> getdeltaE(){
        List<Double> l = getL();
        List<Double> oriE = factor.getE();
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < oriE.size() - 1; i++){
            Double lNum = l.get(i);
            Double ln = Math.log((oriE.get(i+1) / oriE.get(i)));
            Double value = lNum * ln;
            System.out.println(lNum + " * " + ln + " = " + value);
            res.add(value);
        }
        return res;
    }

    //ΔS
    public List<Double> getdeltaS(){
        List<Double> l = getL();
        List<Double> oriS = factor.getS();
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < oriS.size() - 1; i++){
            Double lNum = l.get(i);
            Double ln = Math.log((oriS.get(i+1) / oriS.get(i)));
            Double value = lNum * ln;
            System.out.println(lNum + " * " + ln + " = " + value);
            res.add(value);
        }
        return res;
    }

    //ΔG
    public List<Double> getdeltaG(){
        List<Double> l = getL();
        List<Double> oriG = factor.getG();
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < oriG.size() - 1; i++){
            Double lNum = l.get(i);
            Double ln = Math.log((oriG.get(i+1) / oriG.get(i)));
            Double value = lNum * ln;
            System.out.println(lNum + " * " + ln + " = " + value);
            res.add(value);
        }
        return res;
    }

    //ΔP
    public List<Double> getdeltaP(){
        List<Double> l = getL();
        List<Double> oriP = factor.getP();
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < oriP.size() - 1; i++){
            Double lNum = l.get(i);
            Double ln = Math.log((oriP.get(i+1) / oriP.get(i)));
            Double value = lNum * ln;
            System.out.println(lNum + " * " + ln + " = " + value);
            res.add(value);
        }
        return res;
    }
}
