import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //Mascota m1 = new Mascota("Youjing", 4); 
        //no deja instanciarlo!

        Perro p1 = new Perro("Thor", 8, "Fox Terrier");
        Perro p2 = new Perro("Toby", 12, "Collie");
        Perro p3 = new Perro("Dora", 1, "Doberman");

        Gato g1 = new Gato("Nero", 12,false);
        Gato g2 = new Gato("Kino", 5,false);
        Gato g3 = new Gato("Marramiau", 2,true);

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();        

        System.out.println(p2);
        System.out.println(g3);


        ArrayList<Mascota> granja = new ArrayList<>();
        granja.add(p1);
        granja.add(p2);
        granja.add(p3);

        granja.add(g1);
        granja.add(g2);
        granja.add(g3);

        System.out.println(granja);

        System.out.println("todos los nombres con bucle for-each:");
        for(Mascota animal : granja){
            System.out.println(animal.getNombre());
        }
        
    }
}
