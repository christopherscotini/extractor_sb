package com.gamaset.extractor.executor.exceltosql;

import java.util.ArrayList;
import java.util.List;

import com.gamaset.extractor.entity.Competition;
import com.gamaset.extractor.entity.Country;
import com.gamaset.extractor.entity.Flag;
import com.gamaset.extractor.entity.Team;

public class ConvertExcelDataToStringSql {

	public List<String> convertCountry(List<Country> list) {
		List<String> ret = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			String[] params = { list.get(i).getId().toString(), list.get(i).getName() };
			ret.add(String.format("INSERT INTO `COUNTRY` VALUES (%s);", addParam(params)));
		}

		return ret;
	}

	public List<String> convertFlag(List<Flag> list) {
		List<String> ret = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			String[] params = { list.get(i).getId().toString(), list.get(i).getName(), list.get(i).getUrl() };
			ret.add(String.format("INSERT INTO `FLAG` VALUES (%s);", addParam(params)));
		}

		return ret;
	}

	public List<String> convertCompetition(List<Competition> list) {
		List<String> ret = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			String[] params = { list.get(i).getId().toString(), list.get(i).getName(), list.get(i).getLink(),
					list.get(i).getFlag().getId().toString(), list.get(i).getCountry().getId().toString() };
			ret.add(String.format("INSERT INTO `COMPETITION` VALUES (%s);", addParam(params)));
		}

		return ret;
	}

	public List<String> convertTeam(List<Team> list) {
		List<String> ret = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			String[] params = { list.get(i).getId().toString(), list.get(i).getName(), list.get(i).getCountry().getId().toString() };
			ret.add(String.format("INSERT INTO `TEAM` VALUES (%s);", addParam(params)));
		}

		return ret;
	}

	private String addParam(String[] params) {
		String ret = "";
		for (String str : params) {
			if (!ret.isEmpty()) {
				ret = ret.concat(", ").concat("'").concat(str).concat("'");
			} else {
				ret = ret.concat("'").concat(str).concat("'");
			}
		}
		return ret;
	}

}
