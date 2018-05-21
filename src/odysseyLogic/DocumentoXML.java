/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odysseyLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author cris
 */
public class DocumentoXML {
    	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private Document doc;

    public Document getDoc() {
        return doc;
    }
        private Element rootElement;
        
            public DocumentoXML(String nombrePeticion) throws ParserConfigurationException{
            this.docFactory = DocumentBuilderFactory.newInstance();
            this.docBuilder = docFactory.newDocumentBuilder();
            this.doc = docBuilder.newDocument();
            this.rootElement = doc.createElement(nombrePeticion);
            doc.appendChild(rootElement);            
            
        }
        
        public void ejecutar() throws TransformerConfigurationException, TransformerException, IOException{
            	// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\archivo.xml"));
		//StreamResult result = new StreamResult(new File("archivo.xml"));
                
                // Si se quiere mostrar por la consola...
		// StreamResult result = new StreamResult(System.out);
                
                //filename is filepath string
                BufferedReader br = new BufferedReader(new FileReader(new File("archivo.xml")));
                String line;
                StringBuilder sb = new StringBuilder();

                while((line=br.readLine())!= null){
                    sb.append(line.trim());
                }
                System.out.println("Soy estee: "+ line );
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
        }
        
        public void crearElemento(String nombre){
	                
        }
        
        public void crearHijos(String NombreElemento, String Atributo){
                Element nuevo = doc.createElement(NombreElemento);
		nuevo.appendChild(doc.createTextNode(Atributo));
		rootElement.appendChild(nuevo);
        }
}
