import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // ArrayList te permite no tener en cuenta el length
        // CRUD

        //CREATE
        ArrayList<String>   persoComic =  new ArrayList<>();

        persoComic.add("Mortadelo");
        persoComic.add("Wolwerine");
        persoComic.add("Batman");
        persoComic.add("Condorito");
        persoComic.add("Harley Queen");

        //es posible insertar en posición específica, sin borrar el que había
        persoComic.add(1,"Bob Esponja");

        //READ
        // Leer todo: te hace un toString() directo:
        System.out.println(persoComic);

        // Leer uno: get():
        System.out.println(persoComic.get(2));

        // verlos de uno en uno con un for. Ojo, el length es size
        for(int i=0; i<persoComic.size(); i++){
            System.out.print(persoComic.get(i) + "\t");
        }

        System.out.println();

        //UPDATE: set(). Sobreescribe una posición con el nuevo valor y mueve los elementos anteriores desde esa posición
        persoComic.set(1,"Son Goku");
        System.out.println(persoComic);

        //DELETE: remove()
        persoComic.remove(3);
        System.out.println(persoComic); 

        //Borrar todo
        //persoComic.clear();
        //persoComic = null; //aparece un null
        //persoComic.add("Mortadelo");
        System.out.println("Todo eliminado: " +persoComic); //imprime []

        // ******************************************** //
        
        //ArrayList de enteros INTEGER
        ArrayList<Integer> edades = new ArrayList<>();
        edades.add(45);
        edades.add(12);
        edades.add(33);
        edades.add(78);
        edades.add(25);

        System.out.println(edades);

        //pasar de golpe los valores con Arrays.asList():
        ArrayList<String> perso2 = new ArrayList<>(Arrays.asList("Pocahontas","Lucky Luke", "Chicho Terremoto","Doraemon","Totoro"));
        System.out.println(perso2);

        //copiar ArrayList:
        ArrayList<String> perso2Copia = new ArrayList<>(perso2); //el otro como arg al nuevo
        System.out.println(perso2Copia);
        perso2.set(1, "Bob Esponja");
        System.out.println();

        //son diferentes:
        System.out.println(perso2);
        System.out.println(perso2Copia);

        //ArrayList de ArrayList:
        ArrayList<ArrayList<String>> persoTodos = new ArrayList<>();
        persoTodos.add(persoComic);
        persoTodos.add(perso2);
        System.out.println(persoTodos);

        //en un solo nivel. Usar addAll
        ArrayList<String> persoTodosPlano = new ArrayList<>();
        ////persoTodosPlano.add(persoComic); //da error
        persoTodosPlano.addAll(persoComic); //para añadir otro ArrayList
        persoTodosPlano.addAll(perso2);
        System.out.println(persoTodosPlano);

        //probar a unir tipos con LIST
        List<Object> revuelto = new ArrayList<>();
        revuelto.add(persoComic);
        revuelto.add(perso2);
        System.out.println(revuelto);
    }
}
