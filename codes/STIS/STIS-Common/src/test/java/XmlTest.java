import com.dj.stis.common.utils.JsonUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Description: 【XML文件解析】 <br/>
 * Created on 14:03 2017/8/3 <br/>
 *
 * Reference:
 * http://www.cnblogs.com/longqingyang/p/5577937.html
 *
 */
public class XmlTest {

    //解析文件webservice.xml

    //TODO Use Dom Parse Xml File

    /**
     * DOM解析
     * 文档对象模型解析，通过对对象模型的解析实现对Xml的操作
     * 一次性读取XML，资源耗费严重
     * @param filePath
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void parseXmlByDom(String filePath)
            throws ParserConfigurationException,SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(filePath);
        //获取所有interface节点列表
        NodeList interfaceList = document.getElementsByTagName("interface");
        for (int i = 0; i < interfaceList.getLength(); i++) {
            //获取第一个interface节点
            Node interfaceNode = interfaceList.item(i);
            //获取节点所有属性
            NamedNodeMap attributes = interfaceNode.getAttributes();

            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);
                String nodeName = attribute.getNodeName();
                String nodeValue = attribute.getNodeValue();
                System.out.println("interface " + nodeName + "," + nodeValue);
            }

            //获取所有子节点
            NodeList childNodes = interfaceNode.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node chileNode = childNodes.item(j);
                if (Node.ELEMENT_NODE == chileNode.getNodeType()) {
                    String nodeName = chileNode.getNodeName();
                    Node firstChild = chileNode.getFirstChild();
                    String nodeValue = "";
                    if (firstChild != null) {
                        nodeValue = firstChild.getNodeValue();
                    }
                    System.out.println("interface " + nodeName + "," + nodeValue);
                }
            }
        }
    }


    //TODO Use Sax Parse Xml File

    /**
     * SAX的全称是Simple APIs for XML，也即XML简单应用程序接口
     * 与DOM不同，SAX提供的访问模式是一种顺序模式，这是一种快速读写XML数据的方式。
     * 当使用SAX分析器对XML文档进行分析时，会触发一系列事件，并激活相应的事件处理函数，
     * 应用程序通过这些事件处理函数实现对XML文档的访问，因而SAX接口也被称作事件驱动接口。
     * 编码比较麻烦。很难同时访问XML文件中的多处不同数据。
     * @param filePath
     * @throws Exception
     */
    public static void parseXmlBySax(String filePath) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXParserHandler handler = new SAXParserHandler();
        parser.parse(filePath, handler);
        System.out.println(JsonUtils.toJson(handler.configs));
    }



    public static void main(String[] str) throws Exception{
        System.out.println("Dom解析");
        XmlTest.parseXmlByDom("../STIS-Common/src/main/resources/webservice.xml");
        System.out.println("Sax解析");
        XmlTest.parseXmlBySax("../STIS-Common/src/main/resources/webservice.xml");
    }
}
