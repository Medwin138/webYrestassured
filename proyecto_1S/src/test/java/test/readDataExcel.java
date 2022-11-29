package test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class readDataExcel {


@Test
    public  void main(String[] args) throws Exception {
        File file = new File("/Users/mlaguna/Downloads/Libro1.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(0);
    int rowcount = sheet.getLastRowNum();
    for (int i = 0; i <= rowcount; i++) {
        XSSFRow row = sheet.getRow(i);
        int cellcount = row.getLastCellNum();
        for (int j = 0; j < cellcount; j++) {
            XSSFCell cell = row.getCell(j);
            System.out.print(cell.getStringCellValue() + ";");
        }
        System.out.println();
    }
    fis.close();
}



}
