import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhoupanchn on 2018/7/4.
 */
public class XmlTest {
    public static void main(String[] args) {
        String result1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><bill><id>4028a8973f5c45db013f5c61fb8f0002</id><ProofBillBarCode>B11000000000020130600003</ProofBillBarCode><proofInfo id=\"4028708c3f552dbd013f552dbd140000\">W11000000000020130600001</proofInfo></bill>";
        try {
            Document doc   = DocumentHelper.parseText(result1);
            Element  books = doc.getRootElement();
            System.out.println("根节点" + books.getName());
            Iterator Elements = books.elementIterator();
            while (Elements.hasNext()) {
                Element user = (Element) Elements.next();
                System.out.println("节点" + user.getName() + "\ttext=" + user.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
