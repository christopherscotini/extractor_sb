package com.gamaset.extractor.executor.exceltosql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gamaset.extractor.entity.Competition;
import com.gamaset.extractor.entity.Country;
import com.gamaset.extractor.entity.Flag;
import com.gamaset.extractor.entity.Team;

public class ReadExcelData {

	private final String path = "C://Users//t.christopher.rosari//OneDrive//Favoritos//BETLIFE//Stats//sonicbot_data//database_structure//excel//";

	public List<Country> readCountry() {
		List<Country> list = new ArrayList<Country>();

		try {

			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path + "COUNTRY.xlsx"));

			XSSFSheet mySheet = wb.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				Country dto = new Country(
						Long.valueOf((long) currentRow.getCell(Country.ID_COLUMN).getNumericCellValue()),
						currentRow.getCell(Country.NAME_COLUMN).getStringCellValue());
				list.add(dto);
			}

			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Flag> readFlag() {
		List<Flag> list = new ArrayList<Flag>();

		try {

			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path + "FLAG.xlsx"));

			XSSFSheet mySheet = wb.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				Flag dto = new Flag(Long.valueOf((long) currentRow.getCell(Flag.ID_COLUMN).getNumericCellValue()),
						currentRow.getCell(Flag.NAME_COLUMN).getStringCellValue(),
						currentRow.getCell(Flag.URL_COLUMN).getStringCellValue());
				list.add(dto);
			}

			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Competition> readCompetition() {
		List<Competition> list = new ArrayList<Competition>();

		try {

			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path + "COMPETITION.xlsx"));

			XSSFSheet mySheet = wb.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				Competition dto = new Competition(
						Long.valueOf((long) currentRow.getCell(Competition.ID_COLUMN).getNumericCellValue()),
						currentRow.getCell(Competition.NAME_COLUMN).getStringCellValue(),
						currentRow.getCell(Competition.URL_COLUMN).getStringCellValue(),
						new Flag(
								Long.valueOf(
										(long) currentRow.getCell(Competition.FLAG_ID_COLUMN).getNumericCellValue()),
								null, null),
						new Country(
								Long.valueOf(
										(long) currentRow.getCell(Competition.COUNTRY_ID_COLUMN).getNumericCellValue()),
								null));

				list.add(dto);
			}

			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Team> readTeam() {
		List<Team> list = new ArrayList<Team>();

		try {

			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path + "TEAM.xlsx"));

			XSSFSheet mySheet = wb.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				Team dto = new Team(
						Long.valueOf((long) currentRow.getCell(Team.ID_COLUMN).getNumericCellValue()),
						currentRow.getCell(Team.NAME_COLUMN).getStringCellValue(),
						new Country(
								Long.valueOf(
										(long) currentRow.getCell(Team.COUNTRY_ID_COLUMN).getNumericCellValue()),
								null));

				list.add(dto);
			}

			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}
