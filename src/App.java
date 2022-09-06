public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50, 0);
        lista.add(60, 1);
        lista.add(70, lista.size() - 1);
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
        System.out.println(lista.indexOf(10));
        lista.clear();
        System.out.println(lista.isEmpty());
        System.out.println(lista);
    }
}
