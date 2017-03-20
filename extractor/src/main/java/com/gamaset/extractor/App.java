package com.gamaset.extractor;

import java.util.ArrayList;
import java.util.List;

import com.gamaset.extractor.entity.Competition;
import com.gamaset.extractor.entity.Country;
import com.gamaset.extractor.entity.Flag;
import com.gamaset.extractor.entity.Team;
import com.gamaset.extractor.executor.academia.ExtractTeams;
import com.gamaset.extractor.executor.exceltosql.ConvertExcelDataToStringSql;
import com.gamaset.extractor.executor.exceltosql.ReadExcelData;
import com.gamaset.extractor.utils.GenFile;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
//		generateCountryInserts();
//		generateFlagInserts();
//		generateCompetitionInserts();
//		extractTeams();
		generateTeamInserts();
	}

	private static void extractTeams(){
		ExtractTeams e = new ExtractTeams();
		List<Team> teams = new ArrayList<Team>();
		List<Competition> competitions = DataMock.competitions();
		
		for (Competition competition : competitions) {
			List<Team> nameTeams = e.extractTeams(competition.getLink());
			for (Team team : nameTeams) {
				System.out.println(String.format("%d\t%s\t%s", team.getId(), team.getName(), competition.getCountry().getId()));
				teams.add(new Team(team.getId(), team.getName(), competition.getCountry()));
			}
		}
		
	}
	
	private static void generateCountryInserts() {
		ReadExcelData read = new ReadExcelData();
		List<Country> countries = read.readCountry();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertCountries = convert.convertCountry(countries);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertCountries, "countries_insert");
		
	}

	private static void generateFlagInserts() {
		ReadExcelData read = new ReadExcelData();
		List<Flag> flags = read.readFlag();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertFlags = convert.convertFlag(flags);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertFlags, "flags_insert");
		
	}

	private static void generateCompetitionInserts() {
		ReadExcelData read = new ReadExcelData();
		List<Competition> competitions = read.readCompetition();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertFlags = convert.convertCompetition(competitions);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertFlags, "competition_insert");
		
	}
	
	private static void generateTeamInserts() {
		ReadExcelData read = new ReadExcelData();
		List<Team> teams = read.readTeam();
		
		ConvertExcelDataToStringSql convert = new ConvertExcelDataToStringSql();
		List<String> convertCountries = convert.convertTeam(teams);
		
		GenFile genFile = new GenFile();
		genFile.generateTXT(convertCountries, "team_insert");
	}
}
