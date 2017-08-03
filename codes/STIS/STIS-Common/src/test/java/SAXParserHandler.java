import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 【SAX解析处理器】 <br/>
 * Created on 15:27 2017/8/3 <br/>
 */
public class SAXParserHandler extends DefaultHandler {
    List<WsdlConfig> configs = new ArrayList<WsdlConfig>();
    WsdlConfig config = null;
    String value = null;

    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("interface".equals(qName)){
            config = new WsdlConfig();
            for (int i = 0; i < attributes.getLength(); i++) {
                if ("id".equals(attributes.getQName(i))){
                    config.setId(attributes.getValue(i));
                }else if ("name".equals(attributes.getQName(i))){
                    config.setName(attributes.getValue(i));
                }else if ("explain".equals(attributes.getQName(i))){
                    config.setExplain(attributes.getValue(i));
                }
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("interface".equals(qName)) {
            configs.add(config);
            config = null;
        } else if ("wsdlLocation".equals(qName)) {
            config.setWsdlLocation(value);
        } else if ("operaionName".equals(qName)) {
            config.setOperaionName(value);
        } else if ("request".equals(qName)) {
            config.setRequest(value);
        } else if ("response".equals(qName)) {
            config.setResponse(value);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
    }

}
