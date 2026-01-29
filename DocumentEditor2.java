// 1. SIP (Single Responsibility Principle) followed
// 2. OCP (Open close Principle) followed
// 3. Liscoff Principle followed
// 4. Interface Segregation principle followed
// 5. Dependency Inversion Principle

import java.util.*;
import java.io.*;

abstract class DocumentElement {
    abstract String render();
}

class TextElement extends DocumentElement {
    private String text;

    // constructor
    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement extends DocumentElement {
    private String imagePath;

    // constructor
    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image : " + imagePath + "]";
    }
}

class newLineElement extends DocumentElement {

    @Override
    public String render() {
        return "\n";
    }
}

class TabSpaceElement extends DocumentElement {

    @Override
    public String render() {
        return "\t";
    }
}

abstract class Persistence {
    abstract void save(String data);
}

class FileStorage extends Persistence {

    @Override
    void save(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("document.txt"))) {
            writer.write(data);
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

class DBStorage extends Persistence {

    @Override
    void save(String db) {
        // save to DB
    }
}

class Document {
    List<DocumentElement> documentElements;

    public Document() {
        this.documentElements = new ArrayList<>();
    }

    String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }

        return result.toString();
    }

    void addElement(DocumentElement d) {
        documentElements.add(d);
    }
}

public class DocumentEditor2 {
    Document document;
    Persistence storage;
    String renderedDocument = "";

    // constructor
    DocumentEditor2(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    void addText(String text) {
        document.addElement(new TextElement(text));
    }

    void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    void addNewLine() {
        document.addElement(new newLineElement());
    }

    void addTab() {
        document.addElement(new TabSpaceElement());
    }

    String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    void saveDocument() {
        storage.save(renderDocument());
    }

    // client
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FileStorage();
        DocumentEditor2 editor = new DocumentEditor2(document, persistence);

        // simulate client using the editor with common text formatting features

        editor.addText("This is the first text");
        editor.addNewLine();
        editor.addText("This is a real world document editor example.");
        editor.addNewLine();
        editor.addTab();
        editor.addText("Text after tab space");
        editor.addImage("photo.jpg");

        // render and display final document
        System.out.println(editor.renderDocument());
        editor.saveDocument();
    }
}
