/**
 * 
 */
package com.qvision.certificacion.acsele.utils;

/**
 * @author UserQV
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToData {
	public static String[][] datosExcel;
	public static int filas;
	public static int columnas;

	@SuppressWarnings("unused")
	public static void readFile(String NAME) {
		// Se definen contadores para la limitación de la data

		int x = 0;
		int y = 0;
		int contador = 0;

		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while (contador == 0) {
				Sheet sh = sheets.next();
				Iterator<Row> iterator = sh.iterator();
				while (iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						if (x == 0) {
							y++;
						}

					}

					x++;
					System.out.println();
				}
				contador++;
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		columnas = y;
		filas = x;
		datosExcel = new String[filas][columnas];
		x = 0;
		y = 0;
		contador = 0;
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while (contador == 0) {
				Sheet sh = sheets.next();
				Iterator<Row> iterator = sh.iterator();
				while (iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						datosExcel[x][y] = cellValue;
						y++;

					}

					x++;
					y = 0;
					System.out.println();
				}
				contador++;
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		for (int i = 0; i < filas; i++) {
//			for (int j = 0; j < columnas; j++)
//				System.out.print(" | " + datosExcel[i][j] + " | ");
//			System.out.println("\n----------------------------------------");

//		}

	}

	public static String[][] getDataExcel() {
		return datosExcel;

	}
}
