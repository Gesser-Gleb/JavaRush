package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.*;
import java.util.List;

/**
 * Created by gesse_000 on 01.11.2015.
 */
public class HtmlView implements View {

    private final String filePath = this.getClass().getPackage().toString().replace('.', '/').replaceFirst("package ", "./src/")+"/vacancies.html";
    private Controller controller;
    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Moscow");
    }

    private String getUpdatedFileContent(List<Vacancy> list) {
        try {
            Document doc = getDocument();
            Element element = doc.getElementsByClass("template").first();
            Element elCopy = element.clone();
            elCopy.removeAttr("style");
            elCopy.removeClass("template");

            Elements vacEl = doc.getElementsByAttributeValue("class", "vacancy");
            for (Element element1 :vacEl) {
                element1.remove();
            }

            for (Vacancy vacancy :list) {
                Element vacClone = elCopy.clone();
                vacClone.getElementsByClass("city").first().text(vacancy.getCity());
                vacClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                vacClone.getElementsByClass("salary").first().text(vacancy.getSalary());
                vacClone.getElementsByTag("a").first().text(vacancy.getTitle());
                vacClone.getElementsByAttribute("href").attr("href", vacancy.getUrl());
                element.before(vacClone);
            }
            return doc.outerHtml();

        }catch (IOException e){
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String s) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
            writer.write(s);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");

    }
}
