public class Main {
    public static void main(String[] args) {
        StateManager manager = new StateManager();

        manager.addState("1");
        manager.addState("2");
        manager.addState("3");
        manager.printCurrent(); 

        manager.undo();          
        manager.undo();          
        manager.redo();          

        manager.addState("4");   
        manager.printCurrent();  
    }
}