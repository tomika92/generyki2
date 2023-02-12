import java.util.*;
public class Triple <T1, T2, T3> implements Comparable<Triple>{
    private T1 first;
    private T2 second;
    private T3 third;
    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public T1 getFirst() {
        return first;
    }
    public T2 getSecond() {
        return second;
    }
    public T3 getThird() {
        return third;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(first, triple.first) &&
                Objects.equals(second, triple.second) && Objects.equals(third,
                triple.third);
    }
    @Override
    public String toString() {
        return "Triple<" + this.first + ", " + this.second + ", " +
                this.third + ">";
    }
    @Override
    public int compareTo(Triple o) {
        if(this.first instanceof Comparable) {
            Comparable firstComp = (Comparable) this.first;
            int wynik = firstComp.compareTo(o.getFirst());
            if(wynik != 0 ) {
                return wynik;
            }
            else{
                if(this.second instanceof Comparable){
                    Comparable secondComp = (Comparable) this.second;
                    wynik = secondComp.compareTo(o.getSecond());
                    if(wynik != 0){
                        return wynik;
                    }
                    else{
                        if(this.third instanceof Comparable){
                            Comparable thirdComp = (Comparable) this.third;
                            wynik = thirdComp.compareTo(o.getThird());
                            if(wynik != 0){
                                return wynik;
                            }
                            else{
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    public Comparator<Triple> reverse = new Comparator<Triple>() {
        @Override
        public int compare(Triple o, Triple t1) {
            return o.compareTo(t1) * -1;
        }
    };
    public static void main(String[] args) {
        List<Triple> lista = new ArrayList<>();
        Triple t1 = new Triple("dwa", 2, 2.0);
        Triple t2 = new Triple("dwa", 2, 2.0);
        Triple t3 = new Triple("dwa", -1, 2.0);
        Triple t4 = new Triple("jeden", 4, 8.0);
        Triple t5 = new Triple("pięć", 2, 2.0);
        lista.add(t1);
        lista.add(t2);
        lista.add(t3);
        lista.add(t4);
        lista.add(t5);
        System.out.println("Porównywanie elementów ze sobą:");
        for(int i = 0 ; i < lista.size() ; i++){
            for(int j = i ; j < lista.size() ; j++){
                if(lista.get(i).equals(lista.get(j))){
                    System.out.println("t" + (i+1) + " i t" + (j+1) + " są równe");
                }
                else{
                    System.out.println("t" + (i+1) + " i t" + (j+1) + " nie są równe");
                }
            }
        }
        System.out.println();
        System.out.println("Przed sortowaniem:");
        for(Triple x : lista){
            System.out.println(x);
        }
        Collections.sort(lista);
        System.out.println();
        System.out.println("Po sortowaniu:");
        for(Triple x : lista){
            System.out.println(x);
        }
        Collections.sort(lista, t1.reverse);
        System.out.println();
        System.out.println("Po sortowaniu odwrotnym:");
        for(Triple x : lista){
            System.out.println(x);
        }
    }
}