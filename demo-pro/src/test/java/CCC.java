import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by zhoupanchn on 2019/3/26.
 */
public class CCC {
    public static void main(String[] args) throws IOException {
        File     file = new File("E:/Projects/ForeignMinistry/tmp/statementFile/日内瓦代表团(BK18765).htm");
        Document doc  = Jsoup.parse(file, "gb2312");
        Elements divs = doc.select("div[id*=PrintDiv]");
        //顶部信息
        Element header = divs.get(0);
        //编号
        String td        = header.select("td[align=right][width=20%]").text();
        String substring = td.substring(td.indexOf("B"), td.lastIndexOf("号"));
        //使馆名
        String strong = header.select("font[size=3]").select("strong").text();

        //时间
        String time = header.select("td[align=center][width=30%]").text();

        //System.out.println(header);
        /*Elements td          = header.select("span[id=LabelEmName]");
        Elements total       = header.select("span[id=Label1]");
        Elements Label1YB    = header.select("span[id=Label1YB]");
        Elements Label7per   = header.select("span[id=Label7per]");
        Elements Label2      = header.select("span[id=Label2]");
        Elements Label5      = header.select("span[id=Label5]");
        Elements LabelNumber = header.select("span[id=LabelNumber]");
        Elements Label6      = header.select("span[id=Label6]");
        Elements LabelDate   = header.select("span[id=LabelDate]");
        Elements LabelFen    = header.select("span[id=LabelFen]");
        String   s           = Label6.text();
        //底部信息
        Element bottom = divs.get(divs.size() - 1);
        //包装费
        Element element = bottom.select("td[align=right]").get(0);
        //运费
        Element element1 = bottom.select("td[align=right]").get(1);
        //负责人
        Elements select = bottom.select("td[width=33%]");
        String   text   = select.get(0).text();
        String   text1  = select.get(1).text();
        String   text2  = select.get(2).text();*/
        /*for (int d = 0; d < divs.size(); d++) {
            if (divs.get(d).text() != null && !"".equals(divs.get(d).text())) {
                Element  elements = divs.get(d);*/
                Elements trs      = header.select("tbody").get(2).select("tr[align=center]").nextAll();
                for (int t = 0; t < trs.size(); t++) {
                    Elements tdEs = trs.get(t).select("td");
                    if (!tdEs.get(0).text().equals("") || tdEs.get(0).text() == null) {
                        //System.out.println("==============" + tdEs.get(1).text());
                    }
                }
                Element bottom = header.select("tbody").get(3);
                //金额
                String div1 = bottom.select("div").get(0).text();
                String div2 = bottom.select("div").get(1).text();
                String div3 = bottom.select("div").get(2).text();
                //人
                Elements selectTr = header.select("tbody").get(3).select("tr");
                Elements tds      = selectTr.get(selectTr.size() - 1).select("td");
        System.out.println(tds);
                String   text     = tds.get(0).text();
                String   text1    = tds.get(1).text();
                String   text2    = tds.get(2).text();
               /* System.out.println(text);
                System.out.println(text1);
                System.out.println(text2);*/
       /*     }
        }*/
        /*Element elements = divs.get(divs.size() - 1);
        String  strong   = elements.select("strong").text();
        System.out.println(strong);
        Elements trs = divs.get(divs.size() - 1).select("tbody").get(1).select("tr[align=center]").nextAll();
        for (int t = 0; t < trs.size()-1; t++) {
            Elements tdEs = trs.get(t).select("td");
            if (!tdEs.get(0).text().equals("") || tdEs.get(0).text() == null) {
                System.out.println("==============" + tdEs.get(0).text());
                System.out.println("**************" + tdEs.get(1).text());
                System.out.println("##############" + tdEs.get(2).text());
            }
        }*/
    }

    private static BigDecimal toBigDecimal(String str) {
        return new BigDecimal(str.replaceAll(",", ""));
    }
}
