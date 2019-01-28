import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory f= DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder=f.newDocumentBuilder();
        Document doc= builder.parse(new File("new 1.xml"));

       /* NodeList nodeList= doc.getElementsByTagName("hero");
        for (int i = 0; i <nodeList.getLength() ; i++) {
            Node node= nodeList.item(i);
            Element element= (Element) node;
            System.out.println(element.getTextContent());
        }*/

        NodeList nodeList= doc.getElementsByTagNameNS("*","*");
        for (int i = 1; i <nodeList.getLength() ; i++) {
            Node node= nodeList.item(i);
            Element element= (Element) node;
            System.out.println(node.getNodeName()+"+"+element.getTextContent());
        }





    }
}
