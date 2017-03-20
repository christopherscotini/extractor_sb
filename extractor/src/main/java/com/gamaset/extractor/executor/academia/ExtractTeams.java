package com.gamaset.extractor.executor.academia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gamaset.extractor.entity.Team;

public class ExtractTeams {

	public List<Team> extractTeams(String url) {
		List<Team> ret = new ArrayList<Team>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements matches = doc.select("table[class=competition-rounds competition-half-padding]").first().
			select("tr[class~=(even|odd)]");
			
			for (Element element : matches) {
				Element aHome = element.select("td").get(2).select("a").first();
				Long idHome = Long.valueOf(aHome.attr("href").substring(aHome.attr("href").lastIndexOf("/")+1));
				ret.add(new Team(idHome, aHome.text(), null));
				Element aAway = element.select("td").get(4).select("a").first();
				Long idAway = Long.valueOf(aAway.attr("href").substring(aAway.attr("href").lastIndexOf("/")+1));
				ret.add(new Team(idAway, aAway.text(), null));
//				System.out.println(element.select("td").get(2).select("a").text());
//				System.out.println(element.select("td").get(4).select("a").text());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

}
