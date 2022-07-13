package hn.fish;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static void main(String[] args) {
        File file = new File("D:\\temp\\res2.xls");
        List<List<List>> excelList = readExcel(file);
        System.out.println("打印list中数据：");

        //有几个sheet
        //System.out.println("sheet有几页：" + excelList.size());

        //获得excelList，最外面一层是每一页sheet
        //第二层是每一行row
        //第三层是每一行的数据
        for(int i = 0; i < excelList.size(); i++){
            //获得每一个sheet的数据
            List<List> sheet = excelList.get(i);
            System.out.println("当前sheet有几行数据：" + sheet.size());
            for(int j = 0; j < sheet.size(); j++){
                //获取每一行
                List row = sheet.get(j);
                //System.out.println("当前行有几个数据：" + row.size());
                //打印每一个数据
                for(int k = 0; k < row.size(); k++){
                    System.out.println(row.get(k));
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public static List<List<List>> readExcel(File file){
        try{
            //创建输入流，读取excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            //jxl提供的WorkBook类
            Workbook wb = Workbook.getWorkbook(is);
            //Excel的sheet数量
            int sheet_size = wb.getNumberOfSheets();
            //结果
            List<List<List>> res = new ArrayList<>();
            for(int index = 0; index < sheet_size; index++){
                List<List> outerList = new ArrayList<>();
                //每个sheet创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                //sheet.getRows()返回该页的总行数
                for(int i = 0; i < sheet.getRows(); i++){
                    List innerList = new ArrayList();
                    //sheet.getColumns()返回该页的总列数
                    for(int j = 0; j < sheet.getColumns(); j++){
                        String cellInfo = sheet.getCell(j,i).getContents();
                        if(cellInfo == null){
                            continue;
                        }
                        innerList.add(cellInfo);
                    }
                    outerList.add(innerList);
                }
                res.add(outerList);
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
