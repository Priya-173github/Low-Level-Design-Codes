import java.io.*;
import java.util.*;

// 1. Breaking Single responsibility principle (SRP)
// 2. Breaking Open Close principle (OCP)

public class DocumentEditor1 {

    List<String> documentElements = new ArrayList<>();
    String renderedDocument = "";

    // Adds text as a plain string
    void addText(String text) {
        documentElements.add(text);
    }

    // Adds an image represented by its file path
    void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    String renderDocument() {
        if (renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();

            for (String element : documentElements) {
                if (element.length() > 4 &&
                        (element.endsWith(".jpg") || element.endsWith(".png"))) {

                    result.append("[Image: ")
                            .append(element)
                            .append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }

            renderedDocument = result.toString();
        }

        return renderedDocument;
    }

    void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("document.txt"))) {
            writer.write(renderDocument());
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }

    public static void main(String args[]) {
        DocumentEditor1 editor = new DocumentEditor1();
        editor.addText("Text of first dcument");
        editor.addImage("picture.jpg");
        editor.addText("Text no 2");

        System.out.println(editor.renderDocument());
        editor.saveToFile();
    }
}
