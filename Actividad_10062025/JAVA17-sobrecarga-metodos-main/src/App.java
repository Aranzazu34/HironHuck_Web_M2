import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // Mascota m1 = new Mascota("Rod", 4); //no deja instanciarlo!

        Perro p1 = new Perro("Toby", 12, "Golden"); 
        Perro p2 = new Perro("Popper", 5, "Collie");
        Perro p3 = new Perro("Dora", 7, "Doberman");

        Gato g1 = new Gato("Mifiu", 6, true);
        Gato g2 = new Gato("Mishima", 2, true);
        Gato g3 = new Gato("Marramiau", 8, true);
        Gato g4 = new Gato();
        
        System.out.println(p2);
        System.out.println(g3);
        System.out.println(g3.getClass().getSimpleName());

        ArrayList<Mascota> granja = new ArrayList<>();
        granja.add(p1); granja.add(p2); granja.add(p3);
        granja.add(g1); granja.add(g2);granja.add(g3);
        System.out.println(granja);

        System.out.println("\ntodos los nombres con bucle for-each:");
        for(Mascota animal : granja){
            System.out.println(animal.getNombre());
        }
        System.out.println("\n--------------------------------");
        System.out.println("metodo vacio:");
        System.out.println(g3.descripcion()); //todo

        System.out.println("solo edad:");

        System.out.println("le pasamos true:");
        System.out.println(g3.descripcion(true)); //solo nombre y edad

        System.out.println("\nle pasamos false:");
        System.out.println(g3.descripcion(false)); //todo

        System.out.println("\nle pasamos una frase de presentación:");
        g3.descripcion("Bienvenidos a Mundo Gatuno, hoy tenemos una estrella singular. Pero dejemos que se presente a sí mism@:\n"); //más presentación personalizada

    }
}
