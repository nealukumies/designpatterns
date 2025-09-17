import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoList; // Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        model.setOption(optionNumber, choice);
        saveToHistory();
        gui.updateHistoryList();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        model.setIsSelected(isSelected);
        saveToHistory();
        gui.updateHistoryList();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento currentState = history.remove(history.size() - 1);
            redoList.add(currentState);
            IMemento previousState = history.get(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Memento found in redo");
            IMemento redoState = redoList.remove(redoList.size() - 1);
            history.add(redoState);
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    public void moveToMemento(int index) {
        if (index >= 0 && index < history.size()) {
            System.out.println("Moving to Memento at index: " + index);
            IMemento targetState = history.get(index);
            model.restoreState(targetState);
            history.subList(index, history.size()).clear();
            gui.updateGui();
        } else {
            System.out.println("Index out of bounds: " + index);
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoList.clear();
    }

    public List<IMemento> getHistory() {
        return history;
    }
}