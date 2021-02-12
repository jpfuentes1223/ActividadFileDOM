
package actividad_xml_dom;

public class Actividad_XML_DOM {

    public static void main(String[] args) {
        DOM_Object dom_Object = new DOM_Object("books.xml");
        
        System.out.println(dom_Object.getFILENAME());
        System.out.println(dom_Object.getFileInfo(dom_Object.getDOC()));
    }
    
}
