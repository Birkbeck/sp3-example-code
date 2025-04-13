package behavioural.memento;

//Originator
public class Editor {
    //behavioural.state
    public String editorContents;

    public void setState(String contents) {
        this.editorContents = contents;
    }

    public EditorMemento save() {
        return new EditorMemento(editorContents);
    }

    public void restoreToState(EditorMemento memento) {
        editorContents = memento.getSavedState();
    }
}