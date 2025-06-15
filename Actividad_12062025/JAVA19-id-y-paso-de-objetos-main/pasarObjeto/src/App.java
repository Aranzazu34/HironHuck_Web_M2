public class App {
    public static void main(String[] args) throws Exception {
       


        Mascota m1 = new Mascota("Perro","Fifi", 9);
        Mascota m2 = new Mascota("Gato","Mishi", 12);
        Mascota m3 = new Mascota("Loro","Jack", 33);
        
        Persona p1 = new Persona("tío Al", m1);
        Persona p2 = new Persona("tía Pili", m2);
        Persona p3 = new Persona("tío Tito", m3);

        

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("----------------------");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println("----------------------");
        System.out.println(p1.getNombre() + " tiene un " + p1.getSuMascota().getTipo());
    }
}
