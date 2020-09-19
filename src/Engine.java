import java.util.ArrayList;

public class Engine {

    private final ArrayList<Clause> kb;
    private final char query;

    public Engine(ArrayList<Clause> knowledgeBase, char query) {
        this.kb = knowledgeBase;
        this.query = query;
    }

    public boolean run() {

        return false;
    }
}
