package odysseyLogic;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Node_XML {
	private Document document;
	
	public Node_XML (Document document) {
		this.document = document;
	}
	public NodeList by_tagName (String key) {
		return document.getElementsByTagName(key);
	}
	
	public Node by_id_index (String key, int index) {
		Node nNode = document.getElementsByTagName(key).item(index);
		return nNode;
	}
	
	public void set_parent (Node node, Node parent) {
		
	}
	public String get_value_index (String key, String value, int index) {
		Node nNode = document.getElementsByTagName(key).item(index);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return eElement.getAttribute(value).toString();
		} else {
			return null;
		}
	}
	
	public String get_value (Node node, String value) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) node;
			return eElement.getAttribute(value);
		}
		else {
			return null;
		}
	}
	
}
