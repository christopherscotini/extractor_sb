package com.gamaset.extractor;

import java.util.List;

import com.gamaset.extractor.exceltosql.ConvertExcelDataToStringSql;
import com.gamaset.extractor.exceltosql.ReadExcelData;
import com.gamaset.extractor.exceltosql.dto.CompetitionDTO;
import com.gamaset.extractor.exceltosql.dto.CountryDTO;
import com.gamaset.extractor.exceltosql.dto.FlagDTO;
import com.gamaset.extractor.utils.GenFile;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		generateCountryInserts();
//		generateFlagInserts();
//		generateCompetitionInserts();
	}

	private static void generateCountryInserts() {
		ReadExcelData read = new ReadExcelData();
		List<CountryDTO> countries = read.readCountry();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertCountries = convert.convertCountry(countries);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertCountries, "countries_insert");
		
	}

	private static void generateFlagInserts() {
		ReadExcelData read = new ReadExcelData();
		List<FlagDTO> flags = read.readFlag();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertFlags = convert.convertFlag(flags);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertFlags, "flags_insert");
		
	}

	private static void generateCompetitionInserts() {
		ReadExcelData read = new ReadExcelData();
		List<CompetitionDTO> competitions = read.readCompetition();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertFlags = convert.convertCompetition(competitions);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertFlags, "competition_insert");
		
	}
}
