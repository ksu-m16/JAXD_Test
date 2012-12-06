import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		try {
			 
			File file = new File("test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ListElement.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ListElement elt = (ListElement) jaxbUnmarshaller.unmarshal(file);
			System.out.println(elt);
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		
		//		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
//		f.setValidating(false);
//		DocumentBuilder builder = f.newDocumentBuilder();
//		Document doc = builder.parse(new File("test.xml"));
//		
//		StringBuffer content = new StringBuffer();
//		
//		Node node = doc.getChildNodes().item(0);
//		NamedNodeMap attrs = node.getAttributes();
//		
//		for (int i = 0; i < attrs.getLength(); i++)
//			if (attrs.item(i).getNodeType() == Node.TEXT_NODE) {
//				System.out.println (attrs.item(i).getNodeValue());
//			}
//		}
}

}

@XmlRootElement
class ListElement {
 
	String elt;
	int index;
 
	public String getElt() {
		return elt;
	}
 
	@XmlElement
	public void setElt(String elt) {
		this.elt = elt;
	}

	public int getId() {
		return index;
	}
 
	@XmlAttribute
	public void setId(int id) {
		this.index = id;
	}
 
}
