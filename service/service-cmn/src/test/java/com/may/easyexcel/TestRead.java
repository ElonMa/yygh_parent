package com.may.easyexcel;

import com.alibaba.excel.EasyExcel;

public class TestRead {
    public static void main(String[] args) {
        //读取文件路径
        String filename = "D:\\excel\\01.xlsx";
        EasyExcel.read(filename,UserData.class,new ExcelListener()).sheet().doRead();


    }
}
