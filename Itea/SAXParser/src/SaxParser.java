import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class SaxParser  {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory f= SAXParserFactory.newInstance();

        SAXParser parser=f.newSAXParser();
        SaxParser handler=new SaxParser();
      // parser.parse(new File(),handler);
        parser.parse(new File("new 1.xml"), handler);



    }
}
