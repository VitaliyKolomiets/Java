import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyParser extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("I found start");
    }
    public void endDocument()throws SAXException{
        System.out.println("I found end");
    }

    public void startElement(String uri, String local, String qName, Attributes attributes)throws SAXException{
        System.out.println("I found end"+qName);
        for (int i = 0; i <attributes.getLength() ; i++) {
            System.out.println("Attribute "+attributes.getQName(i)+"="+attributes.getValue(i));
        }
    }
}
