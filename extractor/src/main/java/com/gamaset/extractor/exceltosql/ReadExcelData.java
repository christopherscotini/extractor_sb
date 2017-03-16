package com.gamaset.extractor.exceltosql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gamaset.extractor.exceltosql.dto.CompetitionDTO;
import com.gamaset.extractor.exceltosql.dto.CountryDTO;
import com.gamaset.extractor.exceltosql.dto.FlagDTO;

public class ReadExcelData {

	private final String path = "C://Desenvolvimento//git//Pessoal//sonicbot_data//sql_structure//excel//";
	
	public List<CountryDTO> readCountry(){
		List<CountryDTO> list = new ArrayList<CountryDTO>();
		
		try {
			
			XSSFWorkbook wb = new XSSFWorkbook(
					new FileInputStream(path + "COUNTRY.xlsx")
					);
			
			XSSFSheet mySheet = wb.getSheetAt(0);
			
			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();
			
			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				CountryDTO dto = new CountryDTO(
						Long.valueOf((long) currentRow.getCell(CountryDTO.ID_COLUMN).getNumericCellValue()), 
						currentRow.getCell(CountryDTO.NAME_COLUMN).getStringCellValue()
						);
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
	
	public List<FlagDTO> readFlag(){
		List<FlagDTO> list = new ArrayList<FlagDTO>();
		
		try {
			
			XSSFWorkbook wb = new XSSFWorkbook(
					new FileInputStream(path + "FLAG.xlsx")
					);
			
			XSSFSheet mySheet = wb.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();
			
			while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                FlagDTO dto = new FlagDTO(
                		Long.valueOf((long) currentRow.getCell(FlagDTO.ID_COLUMN).getNumericCellValue()), 
                		currentRow.getCell(FlagDTO.NAME_COLUMN).getStringCellValue(),
                		currentRow.getCell(FlagDTO.URL_COLUMN).getStringCellValue()
                		);
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

	public List<CompetitionDTO> readCompetition(){
		List<CompetitionDTO> list = new ArrayList<CompetitionDTO>();
		
		try {
			
			XSSFWorkbook wb = new XSSFWorkbook(
					new FileInputStream(path + "COMPETITION.xlsx")
					);
			
			XSSFSheet mySheet = wb.getSheetAt(0);
			
			Iterator<Row> rowIterator = mySheet.iterator();
			rowIterator.next();
			
			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				CompetitionDTO dto = new CompetitionDTO(
						Long.valueOf((long) currentRow.getCell(CompetitionDTO.ID_COLUMN).getNumericCellValue()), 
						currentRow.getCell(CompetitionDTO.NAME_COLUMN).getStringCellValue(),
						currentRow.getCell(CompetitionDTO.URL_COLUMN).getStringCellValue(),
						new FlagDTO(Long.valueOf((long) currentRow.getCell(CompetitionDTO.FLAG_ID_COLUMN).getNumericCellValue()), null, null),
						new CountryDTO(Long.valueOf((long) currentRow.getCell(CompetitionDTO.COUNTRY_ID_COLUMN).getNumericCellValue()), null)
						);
				
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
