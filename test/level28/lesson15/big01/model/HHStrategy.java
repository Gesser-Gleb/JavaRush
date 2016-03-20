package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gesse_000 on 26.10.2015.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();

        int i = 0;
        while (true) {
            try {
               Document document = getDocument(searchString, i++);

                Elements el = document.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
                if (el.size() > 0) {
                    for (Element element : el) {
                        Vacancy vac = new Vacancy();
                        vac.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-title").attr("href"));
                        vac.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-title").text());
                        vac.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-address").text());
                        vac.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-employer").text());
                        Elements sal = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-compensation");
                        if (sal.size() == 0) vac.setSalary("");
                        else vac.setSalary(sal.text());
                        vac.setSiteName(document.title());
                        list.add(vac);
                    }

                }

            } catch (IOException e) {
            }
            ;
            return list;
        }
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String usAg = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36";
        String ref = "hh.ru";
        String address = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(address).userAgent(usAg).referrer(ref).get();
        return doc;
    }
}
