import Especies.AnimalDomestico;
import Especies.AnimalSalvaje;
import Naturaleza.Arbol;
import Naturaleza.Planta;

public class App {
    /*
     * Tienes una granja con un establo y un invernadero => 2 packages (paquetes de clases),

Dentro de la carpeta src (donde se encuentra el main) tienes dos carpetas con archivos java (paquetes), donde cada uno de estos paquetes contienen 
al menos dos clases:


- Package1:
o Clase Arbol: atributos default, private y public (uno de cada)
o Y clase Planta: atributos default, private y public (uno de cada)


- Package2:

o Crear clase madre Animales, y atributos protected. Las clases hijas son:
o Clase AnimalSalvaje
o Clase AnimalDomestico



Desde la clase Principal, crear:
- Un objeto de la clase Planta (o/y Arbol)
- Un objeto de la clase AnimalSalvaje
- Un objeto de la clase AnimalDomestico
- (No hace falta instanciar la clase madre) (puede ser abstract)


Como siempre, cuando instancias esos objetos desde el main, le pasas los valores para cada atributo. Estos atributos los inventas tú.


Imprimes todos estos objetos, y propiedades de objetos de todas las clases desde la clase main. ¿De qué manera accedes a cada uno de ellos? 
Prueba a acceder a los atributos con modificadores protected, default, private y public desde el main.

+EXTRA: ¿Y podrías, por ejemplo acceder desde la clase Planta a algún atributo de la clase Arbol?


Sobre todo, es fundamental el PLANTEAMIENTO del esquema de dónde está cada cosa: se aconseja crear un esquema visual antes en lápiz y papel. 
Suerte!

     */
    public static void main(String[] args) throws Exception {

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();      


        //ARBOL
        Arbol a1 = new Arbol("Eucaliptus", 2, true);

        System.out.println(a1.toString());
        System.out.println("===========================");

        /*
        private String nombre;  //privado
        public  int    estacion;  //publico
        boolean        frutal; //default    
         */
         
        System.out.println("Nombre Árbol: " + a1.getNombre());
        System.out.println("Estancion num.: " + a1.estacion);
        System.out.println( (a1.isfrutal() ? "Árbol frutal" : "Árbol no frutal" ));


        System.out.println("===========================");
        System.out.println();  


        //PLANTA
        Planta p1 = new Planta("Gardenia", 10, false);

        System.out.println(p1.toString());
        System.out.println("===========================");

        /*
        private String nombre;  //privado
        public  int    mes_plantar;  //publico
        boolean        deInterior; //default 
        */  

        System.out.println("Nombre Planta: " + p1.getNombre());
        System.out.println("Mes Plantar: " + p1.mes_plantar);
        System.out.println( (p1.isDeInterior() ? "Planta de Interior" : "Planta de Exterior" ));

        System.out.println();
        p1.getArbol(a1);
        System.out.println();

        System.out.println("===========================");
        System.out.println();

        
        //ANIMAL SALVAJE
        AnimalSalvaje as = new AnimalSalvaje(false, "Herbivora", "Mamífero", "Elefante", 4, "Asia");

        System.out.println(as.toString());
        System.out.println("===========================");    

        /*
        private boolean nocturno;
        private String  alimentacion;
        final boolean  protegido = true;   
        */     

        System.out.println( (as.isNocturno() ? "A. Salvaje Nocturno" : "A. Salvaje Diurno" ));
        System.out.println("Alimentacion: " + as.getAlimentacion());
        System.out.println( (as.isProtegido() ? "Animal Protegido" : "Animal sin peligro de extinción" ));

        /*
        protected  String especie;
        protected  String nombre;
        protected  int    num_patas;
        protected  String origen; //continente/país        
        */
        System.out.println("Especie de clase Padre: " +as.getEspecie());
        

        System.out.println("===========================");
        System.out.println();

        
        //ANIMAL DOMESTICO
        AnimalDomestico ad = new AnimalDomestico("Pienso", 12, "Felina", "Gato", 4, "Egipcia");

        System.out.println(ad.toString());
        System.out.println("===========================");    

        /*
        private String alimentacion;
        private int num_longevidad;
        */

        System.out.println( "Alimentación: " + ad.getAlimentacion());
        System.out.println("Longevidad años: " + ad.getNum_longevidad());   

        System.out.println("Nº Patas de clase Padre: " +ad.getNum_patas());


        System.out.println();
        ad.getArbol(a1);
        System.out.println();        


        System.out.println("===========================");
        System.out.println();        

        
    }
}
