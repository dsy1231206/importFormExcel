package hn.fish;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * sheet对应：
 * 0 - 碳净
 * 1 - 碳排
 * 2 - 能耗
 * 3 - 经济产值
 * 4 - 捕捞产量
 * 5 - 员工人数
 *
 * sheet的行数对应：
 * 0 ：年份
 * 1 - 10 ： 具体数值
 *
 * 每一列对应：
 * 0 ：地区
 * 1 - 16 ：年份
 */
public class Calculate {
    public static void main(String[] args) {
        File file = new File("D:\\temp\\res2.xls");
        List<List<List>> excelList = ReadExcel.readExcel(file);
        List<List<Double>> l = getL(excelList);
        /*for(int i = 0; i < l.size(); i++){
            for(int j = 0; j < l.get(i).size(); j++){
                System.out.println(l.get(i).get(j));
            }
            System.out.println();
        }*/
        List<List<Double>> deltaC = CPure(excelList);
        for(int i = 0; i < deltaC.size(); i++){
            for(int j = 0; j < deltaC.get(i).size(); j++){
                System.out.println(deltaC.get(i).get(j));
            }
            System.out.println();
        }



    }

    /**
     * 求各地区的净碳排
     * 第十二行是空白行
     * @param excelList
     * @return
     */
    public static List<List<Double>> CPure(List<List<List>> excelList){
        List<List<Double>> res = new ArrayList<>();
        //拿到净碳排的sheet
        List<List> sheet0 = excelList.get(0);

        //有11行
        for(int i = 1; i < sheet0.size(); i++){
            //第一个for计算每个地区的数值
            List<Double> list = new ArrayList<>();
            List row = sheet0.get(i);
            for(int j = 1; j < row.size() - 1; j++){
                //求t+1 - t
                Double delta = Double.parseDouble((String)row.get(j+1)) - Double.parseDouble((String)row.get(j));
                list.add(delta);
            }
            res.add(list);
        }
        return res;

    }

    //直接得到L(Ct+1,Ct)的list
    public static List<List<Double>> getL(List<List<List>> excelList){
        List<List<Double>> res = new ArrayList<>();
        List<List> sheet0 = excelList.get(0);
        //去掉第一行和最后一行
        for(int i = 1; i < sheet0.size(); i++){
            List<Double> list = new ArrayList<>();
            List row = sheet0.get(i);
            for(int j = 1; j < row.size() - 1;j++){
                Double c2 = Double.parseDouble((String)row.get(j+1));
                Double c1 = Double.parseDouble((String)row.get(j));
                Double num = (c2 - c1) / (Math.log(c2) - Math.log(c1));
                System.out.println("Ct+1:" + c2 + "，Ct:" + c1 + "，结果：" + num);
                list.add(num);
            }
            System.out.println();
            res.add(list);
        }
        return res;
    }
}
