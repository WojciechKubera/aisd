import java.util.StringTokenizer;

public class InfixtoPostfix {

    private String wyrazenieInfiksowe;
    private String wyrazeniePostfiksowe;

    public InfixtoPostfix(String wyrazenie) {
        wyrazenieInfiksowe = wyrazenie;
        wyrazeniePostfiksowe = "";
        infiksNaPostfiks();
    }

    private void infiksNaPostfiks() {

        Stos<String> stos = new Stos<String>();
        StringTokenizer st = new StringTokenizer(wyrazenieInfiksowe, "+-*/()%", true);
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if( s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")|| s.equals("%")) {
                while(!stos.isEmpty() && priorytet(stos.Peek()) >= priorytet(s))
                    wyrazeniePostfiksowe += stos.Pop()  + " ";
                stos.Push(s);
            }
            else if(s.equals("(")) stos.Push(s);
            else if(s.equals(")")) {
                while(!stos.Peek().equals("(")) wyrazeniePostfiksowe += stos.Pop() + " ";
                stos.Pop();
            }
            else wyrazeniePostfiksowe += s  + " ";
        }
        while(!stos.isEmpty()) wyrazeniePostfiksowe += stos.isEmpty()  + " ";
    }

    public static int priorytet(String operator) {
        if(operator.equals("+") || operator.equals("-")) return 1;
        else if(operator.equals("*") || operator.equals("/")|| operator.equals("%")) return 2;
        else return 0;
    }

    public String toString() {
        return wyrazeniePostfiksowe;
    }


}

