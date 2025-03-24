package cdi;

import javax.inject.Inject;

public class ImageFileProcessor implements ImageFileEditor {
    private final ImageFileEditor imageFileEditor;

    @Inject
    public ImageFileProcessor(ImageFileEditor imageFileEditor) {
        this.imageFileEditor = imageFileEditor;
    }

    @Override
    public String openFile(String fileName) {
        return imageFileEditor.openFile(fileName);
    }

    @Override
    public String editFile(String fileName) {
        return imageFileEditor.editFile(fileName);
    }

    @Override
    public String writeFile(String fileName) {
        return imageFileEditor.writeFile(fileName);
    }

    @Override
    public String saveFile(String fileName) {
        return imageFileEditor.saveFile(fileName);
    }
}
