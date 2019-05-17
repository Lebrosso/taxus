package application;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;


public class ReportGenerator {

    private static final String EXCEL_FILE_LOCATION = "Raport.xlsx";

    public void generate() {

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add something into the Excel sheet
            Label label = new Label(0, 0, "lp.");
            excelSheet.addCell(label);

            label = new Label(1, 0, "Nazwa");
            excelSheet.addCell(label);

            label = new Label(2, 0, "Obserwacje");
            excelSheet.addCell(label);

            label = new Label(2, 0, "Monitoring");
            excelSheet.addCell(label);

            myFirstWbook.write();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        }
    }

