public class App  {
    public static void main(String[] args) throws Exception {
        
        // instanciar un objeto instrumento
        //concretar al llamar al método constructor

        Instrumento ints1 = new Instrumento("violin", "Stradivarius", 17000, "vs100", true);

        System.out.println(ints1.toString()); //imprime todo

        //con la definición private, no se puede aplicar lo siguiente:
        //se ha de hacer usos de los get() y set()
        //System.out.println(ints1.nombre);
        //System.out.println(ints1.marca);
        System.out.println("el instrumento es: " + ints1.getNombre());

        ints1.setNombre("Violonchelo");
        System.out.println("el instrumento actualizado es: " + ints1.getNombre());
        double ofertaViolonchelo = ints1.getPrecio()*0.80;
        System.out.println("Hey, el Violonchelo está de oferta,");
        System.out.println("Ahora vale solo: "+ofertaViolonchelo);

        Instrumento inst2 = new Instrumento("Guitarra", "Ibñez", 1500, "gib200", false);

        System.out.println(inst2);
        System.out.println("marca y precio:" + inst2.getMarca() + ", " + inst2.getPrecio());
        
    }
}
