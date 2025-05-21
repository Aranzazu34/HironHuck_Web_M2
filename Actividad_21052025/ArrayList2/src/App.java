import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> pcs = new ArrayList<>(Arrays.asList("Dell", "hp", "Compact", "apple",
        "asus", "Acer", "lenovo"));

        /* METODO SORT() PARA ORDENAR STRINGS Y NUMEROS */
        System.out.println("PCs desordenados:");
        System.out.println(pcs);
        //pcs.sort(null)

        Collections.sort(pcs);
        System.out.println("PCs ordenados:");
        System.out.println(pcs);

        System.out.println("PCs REALMENTE ordenados:");  //control ASCII
        Collections.sort(pcs, String.CASE_INSENSITIVE_ORDER);
        System.out.println(pcs);

        /************************* */
        ArrayList<Integer> numeritos = new ArrayList<>(Arrays.asList(23,6,9,32,2579,1));
        System.out.println("Numeros desordenados:");
        System.out.println(numeritos);  
        
        Collections.sort(numeritos);
        System.out.println("Numeros ordenados:");
        System.out.println(numeritos); 

        /* METODO ADDALL() */
        ArrayList<String> impresoras = new ArrayList<>(Arrays.asList("Brother", "hp", "Canon", "Epson"));        
        System.out.println(impresoras);

        ArrayList<String> maquinas = new ArrayList<>();
        maquinas.addAll(pcs);
        maquinas.addAll(impresoras);
        maquinas.add("cortacesped");
        System.out.println("Todas las máquinas:");
        System.out.println(maquinas);

        System.out.println("Todas las máquinas ordenadas:");        
        Collections.sort(maquinas, String.CASE_INSENSITIVE_ORDER);
        System.out.println(maquinas);

        
        ArrayList<String> pcs2 = new ArrayList<>(Arrays.asList("Dell", "hp", "Compact", "apple",
        "asus", "Acer", "lenovo"));
        ArrayList<String> impresoras2 = new ArrayList<>(Arrays.asList("Brother", "hp", "Canon", "Epson"));        
        System.out.println(pcs2.get(1).equals(impresoras2.get(1)));;

        //indexOf() te dice el indice de un valor
        //si no lo encuentra, te da -1
        System.out.println(pcs.indexOf("hp"));        
        System.out.println(impresoras.indexOf("hp"));
        System.out.println(pcs.get(5).equals(impresoras.get(1)));

    
        // contains() te dice TRUE o FALSE si un valor está en una lista
        System.out.println(pcs.contains("hp"));
        System.out.println(pcs.contains("Brother"));

        if(pcs.contains("hp")){
            System.out.println("Lo hemos encontrado hp!");
        }else{
            System.out.println("no lo tenemos, pero lo podemos encargar");
        }

        if(pcs.indexOf("hp") != -1){ //si lo encuentra, no será -1
            System.out.println("Lo hemos encontrado hp en la posición " + pcs.indexOf("hp"));
        }else{
            System.out.println("no lo tenemos, pero lo podemos encargar");
        }

        // isEmpty()
        pcs.clear();  //borra todo

        if (!pcs.isEmpty()){  //comprueba si hay algo en la lista
            System.out.println(pcs);
        }else
            System.out.println("la lista está vacía");
    

        List<Object> todoMezclado = Arrays.asList("el Coyote", 28, false, "jaimito", 56.897);
        System.out.println(todoMezclado);
        System.out.println(todoMezclado.get(1));
        int miNumero = (int) todoMezclado.get(1); //castearlo
        String miString = (String) todoMezclado.get(0);
        System.out.println(miNumero);
        System.out.println(miString);
        

    }
}
