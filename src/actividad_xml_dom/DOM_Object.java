package actividad_xml_dom;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM_Object {

    private final String FILENAME;
    private Document DOC;

    public DOM_Object(String FILENAME) {
        this.FILENAME = FILENAME;
        try {
            this.DOC = GenerateDoc(FILENAME);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(DOM_Object.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public Document getDOC() {
        return DOC;
    }

    private Document GenerateDoc(String filename) throws SAXException, IOException {
        Document doc = null;
        try {
            DocumentBuilderFactory db_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = db_factory.newDocumentBuilder();

            doc = db.parse(filename);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOM_Object.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doc;
    }

    public String getFileInfo(Document doc) {
        String texto_salida = "";

        String[] node_data;

        Node node;

        Node root = doc.getFirstChild();
        NodeList nodelist = root.getChildNodes();

        for (int i = 0; i < nodelist.getLength(); i++) {
            node = nodelist.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                node_data = processNode(node);

                texto_salida += "\n El titulo del libro es:" + node_data[2];
                texto_salida += "\n El autor del libro es:" + node_data[1];
                texto_salida += "\n El libro fue publicado en:" + node_data[0]+"\n";
            }
        }

        return texto_salida;
    }

    private String[] processNode(Node node) {
        String[] nodeData = new String[3];

        Node ntemp;
        int counter = 1;

        nodeData[0] = node.getAttributes().item(0).getNodeValue();

        NodeList nodes = node.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            ntemp = nodes.item(i);

            if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                nodeData[counter] = ntemp.getChildNodes().item(0).getNodeValue();
                counter++;
            }
        }
        return nodeData;
    }

    public boolean addNode(String fecha_publi, String autor, String titulo) {
        boolean createdSuccess = false;
        
        System.out.println("¿Desea guardar los cambios en el documento?(S/N): ");
        
        return createdSuccess;
    }

    private boolean saveDomFile(Document doc) {
        boolean savedSuccess = false;
        return savedSuccess;
    }

}
