import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Clause> clauses;
        char query;
        if(args.length != 0) {
            clauses = extractClauses(args[0]);
            query = args[1].charAt(args[1].length()-2);
        } else {
            clauses = extractClauses("KB = {A, B, A \uF0D9 B \uF0DE L, A \uF0D9 P \uF0DE L, B \uF0D9 L \uF0DE M, L \uF0D9 M \uF0DE P, P \uF0DE Q}");
            query = 'Q';
        }
        Engine engine = new Engine(clauses, query);
        System.out.println(engine.run());
    }

    private static ArrayList<Clause> extractClauses(String s) {
        ArrayList<Clause> clauses = new ArrayList<>();
        String[] split = s.substring(6, s.length()-1)
                .replaceAll(" ", "")
                .split(",");
        for (String clause: split) {
            if(clause.length() == 1) {
                clauses.add(new Clause(null, clause.charAt(0)));
            } else {
                StringBuilder premises = new StringBuilder();
                for (int i = 0; i < clause.length()-1; i++) {
                    int c = clause.charAt(i);
                    if(c < 60 || c > 90) continue;
                    premises.append((char)c);
                }
                clauses.add(new Clause(premises.toString().toCharArray(), clause.charAt(clause.length()-1)));
            }
        }
        for (Clause c: clauses) System.out.println(c);
        return clauses;
    }
}
