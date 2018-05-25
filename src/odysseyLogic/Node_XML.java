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
	//Constructor de la clase
	public Node_XML (Document document) {
		this.document = document;
	}
	
	// Obtiene una lista de todos los elementos que tengan como nombre (key)
	public NodeList by_tagName (String key) {
		return document.getElementsByTagName(key);
	}
	// Obtiene un nodo por indice con el key
	public Node by_id_index (String key, int index) {
		Node nNode = document.getElementsByTagName(key).item(index);
		return nNode;
	}
	
	public void set_parent (Node node, Node parent) {
		
	}

	public String get_value_index (String key, int index, String value) {
		Node nNode = document.getElementsByTagName(key).item(index);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return eElement.getElementsByTagName(value).item(0).getTextContent();
		} else {
			
			return null;
		}
	}
	// Obtiene un valor (value) de un Nodo (node)
	public String get_value (Node node, String value) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) node;
			return eElement
	                  .getElementsByTagName(value)
	                  .item(0)
	                  .getTextContent();
		}
		else {
			return null;
		}
	}
	
	// Obtiene la cantidad de elementos que hay con ese key
	public int get_lenght_of_key (String key) {
		return document.getElementsByTagName(key).getLength();
	}
	
}
