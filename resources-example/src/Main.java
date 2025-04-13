//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.InputStream;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main {

    public static void main(String[] args) {
        try {
            // Load the XML file from the resources folder
            InputStream inputStream = Main.class.getResourceAsStream("example.xml");

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and build the Document
            Document document = builder.parse(inputStream);

            // Normalize the XML structure
            document.getDocumentElement().normalize();

            // Get elements by tag name
            NodeList nodeList = document.getElementsByTagName("name");

            // Process the nodes
            IntStream.range(0, nodeList.getLength()).mapToObj(i -> nodeList.item(i).getTextContent()).forEach(System.out::println);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}