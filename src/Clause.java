public class Clause {
    private final char[] premise;
    private final char conclusion;

    public Clause(char[] premise, char conclusion) {
        this.premise = premise;
        this.conclusion = conclusion;
    }

    public char[] getPremise() {
        return premise;
    }

    public char getConclusion() {
        return conclusion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(premise != null) {
            for (char c : premise) {
                sb.append(c);
            }
            sb.append("=>");
        }
        sb.append(conclusion);
        return sb.toString();
    }


}
