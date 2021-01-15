package cn.dsq.customer.util;
        import cn.dsq.customer.dao.GoodDao;
        import cn.dsq.customer.dao.impl.GoodDaoImpl;
        import cn.dsq.customer.domain.Good;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import java.io.FileInputStream;
        import org.apache.poi.hssf.usermodel.HSSFWorkbook;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import java.io.File;
        import java.io.InputStream;

public class ImportExcelGoods {

    public static void main(String[] args) {

        ImportExcelGoods excelTest=new ImportExcelGoods();

        Workbook wb = excelTest.getExcel("D:\\dsq\\tab_user.xls");

        if(wb==null)
            System.out.println("文件读入出错");
        else {
            excelTest.analyzeExcel(wb);
        }

    }

    public Workbook getExcel(String filePath){
        Workbook wb=null;
        File file=new File(filePath);
        if(!file.exists()){
            System.out.println("文件不存在");
            wb=null;
        }
        else {
            String fileType=filePath.substring(filePath.lastIndexOf("."));//获得后缀名
            try {
                InputStream is = new FileInputStream(filePath);
                if(".xls".equals(fileType)){
                    wb = new HSSFWorkbook(is);
                }else if(".xlsx".equals(fileType)){
                    wb = new XSSFWorkbook(is);
                }else{
                    System.out.println("格式不正确");
                    wb=null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wb;
    }

    public void analyzeExcel(Workbook wb){
        GoodDao goodDao = new GoodDaoImpl();
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        int id = 0;
        String name = null;
        double price;
        for(int i=0;i<=rowNum;i++){
            Row row=sheet.getRow(i);//获得行
            int colNum=row.getLastCellNum();//获得当前行的列数
            for(int j=0;j<colNum;j++){
                Cell cell=row.getCell(j);//获取单元格
                if(cell==null)
                    System.out.print("null     ");
                else {
                    String n = cell.toString();
                    if(j==0){
                        id=Integer.parseInt(n);
                    }else if(j==1){
                        name=n;
                    }else if(j==2){
                        price=Double.parseDouble(n);
                        Good good = new Good(id,name,price);
                        goodDao.save(good);
                    }
                }
            }
        }
    }

}



