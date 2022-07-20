import org.testng.annotations.DataProvider;

public class ExcelDataProviders {

    @DataProvider
    public Object[][] usersFromSheet1() throws Exception {
        String path = "src/main/resources/users.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        return excelReader.getSheetDataForTDD();
    }
}