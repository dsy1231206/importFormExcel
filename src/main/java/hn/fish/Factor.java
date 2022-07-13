package hn.fish;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 只计算第一行的数据
 */
public class Factor {
    private List<List<List>> excel;

    private File file;

    public Factor(){
        file = new File("D:\\temp\\res2.xls");
        excel = ReadExcel.readExcel(file);
    }

    public List<Double> getN(){
        //拿到sheet0和sheet1
        List<List> sheet0 = excel.get(0);
        List<List> sheet1 = excel.get(1);
        //拿到C净
        List row0 = sheet0.get(1);
        List row1 = sheet1.get(1);

        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row0.size(); i++){
            Double num0 = Double.parseDouble((String)row0.get(i));
            Double num1 = Double.parseDouble((String)row1.get(i));
            Double value = num0 / num1;
            //System.out.println(num0 + " / " + num1 + " = " + value);
            res.add(value);
        }
        return res;
    }

    public List<Double> getF(){
        //拿到sheet1和sheet2
        List<List> sheet1 = excel.get(1);
        List<List> sheet2 = excel.get(2);
        //拿到碳排
        List row1 = sheet1.get(1);
        List row2 = sheet2.get(1);

        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row1.size(); i++){
            Double num0 = Double.parseDouble((String)row1.get(i));
            Double num1 = Double.parseDouble((String)row2.get(i));
            Double value = num0 / num1;
            //System.out.println(num0 + " / " + num1 + " = " + value);
            res.add(value);
        }
        return res;
    }

    public List<Double> getE(){
        //拿到sheet2和sheet3
        List<List> sheet2 = excel.get(2);
        List<List> sheet3 = excel.get(3);
        //拿到碳排
        List row2 = sheet2.get(1);
        List row3 = sheet3.get(1);

        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row2.size(); i++){
            Double num0 = Double.parseDouble((String)row2.get(i));
            Double num1 = Double.parseDouble((String)row3.get(i));
            Double value = num0 / num1;
            //System.out.println(num0 + " / " + num1 + " = " + value);
            res.add(value);
        }
        return res;
    }

    public List<Double> getS(){
        //拿到sheet3和sheet4
        List<List> sheet3 = excel.get(3);
        List<List> sheet4 = excel.get(4);
        //拿到碳排
        List row3 = sheet3.get(1);
        List row4 = sheet4.get(1);

        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row3.size(); i++){
            Double num0 = Double.parseDouble((String)row3.get(i));
            Double num1 = Double.parseDouble((String)row4.get(i)) / 100000.0;
            Double value = num0 / num1;
            //System.out.println(num0 + " / " + num1 + " = " + value);
            res.add(value);
        }
        return res;
    }

    public List<Double> getG(){
        //拿到sheet3和sheet4
        List<List> sheet4 = excel.get(4);
        List<List> sheet5 = excel.get(5);
        //拿到碳排
        List row4 = sheet4.get(1);
        List row5 = sheet5.get(1);

        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row4.size(); i++){
            Double num0 = Double.parseDouble((String)row4.get(i)) / 100000.0;
            Double num1 = Double.parseDouble((String)row5.get(i)) / 10000.0;
            Double value = num0 / num1;
            //System.out.println(num0 + " / " + num1 + " = " + value);
            res.add(value);
        }
        return res;
    }

    public List<Double> getP(){
        List<List> sheet5 = excel.get(5);
        List row = sheet5.get(1);
        List<Double> res = new ArrayList<>();
        for(int i = 1; i < row.size(); i++){
            Double num = Double.parseDouble((String)row.get(i)) / 10000.0;
            res.add(num);
        }
        return res;
    }
}
