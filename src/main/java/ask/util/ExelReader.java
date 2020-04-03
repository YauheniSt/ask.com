package ask.util;

public class ExelReader {

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		String TESTDATA_SHEET_PATH = dir + "\\src\\main\\java\\ask\\testData\\askData.xlsx";
		Xls_Reader reader=new Xls_Reader(TESTDATA_SHEET_PATH);
		String sheetName="LoginData";
		String data1= reader.getCellData(sheetName, 0, 1);
		String data2= reader.getCellData(sheetName, 0, 2);
		String data3= reader.getCellData(sheetName, 0, 3);
		String data4= reader.getCellData(sheetName, 0, 4);
		
		
		
		String data5= reader.getCellData(sheetName, 1, 1);
		String data6= reader.getCellData(sheetName, 1, 2);
		String data7= reader.getCellData(sheetName, 1, 3);
		String data8= reader.getCellData(sheetName, 1, 4);
		
		System.out.println(data5);
		System.out.println(data6);
		System.out.println(data7);
		System.out.println(data8);
	}

}
