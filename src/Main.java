import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlType; 


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
			JAXBContext jaxbContext = JAXBContext.newInstance(XuList.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XuList elt = (XuList) jaxbUnmarshaller.unmarshal(file);
			System.out.println(elt);
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		
	}

}

@XmlRootElement(name = "list")
class XuList {
	
	@XmlElements(value = { @XmlElement(name = "li", type = ListElement.class) })
	private List<ListElement> elements = new LinkedList<ListElement>();	
 
    public List<ListElement> getElements()
    {
        return elements;
    }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ListElement elt: elements) {
			sb.append(elt + "\n");
		}
		return sb.toString();
	}
 
}

@XmlType(name="li")
class ListElement {

	private int index;
	private String elt;
	
	public String toString() {
		return index + ". " + elt; 
	}
	
	public String getElt() {
	return elt;
	}

	@XmlValue
	public void setElt(String elt) {
		this.elt = elt;
	}
	
	public int getIndex() {
		return index;
	}
	
	@XmlAttribute(name = "index")
	public void setIndex(int index) {
		this.index = index;
	}
	
}


