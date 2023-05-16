// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Ejercicio 6_b
        LinkedList<Integer> lista1 = new LinkedList<Integer>();

        Integer elemento10 = 10;
        Integer elemento21 = 21;
        Integer elemento11 = 11;
        Integer elemento12 = 12;
        Integer elemento3 = 3;
        Integer elemento1 = 1;
        Integer elemento5 = 5;

        lista1.insertFront(elemento21);
        lista1.insertFront(elemento11);
        lista1.insertFront(elemento10);
        lista1.insertFront(elemento5);
        lista1.insertFront(elemento1);

        LinkedList<Integer> lista2 = new LinkedList<>();

        lista2.insertFront(elemento21);
        lista2.insertFront(elemento12);
        lista2.insertFront(elemento11);
        lista2.insertFront(elemento3);
        lista2.insertFront(elemento1);
        /*
        for(Integer n: lista1)
            System.out.print(n + " ");

        System.out.print("\n" );

        for(Integer n: lista2)
            System.out.print(n + " ");

        System.out.print("\n" );
        System.out.println("Lista resultante del ejercicio 6 B:");
        LinkedList<Integer> lista3 = combinarListasOrdenadas(lista1, lista2);

        System.out.print("\n" );
        for(Integer n: lista3)
            System.out.print(n + " ");*/

        //ejercicio 9

        String rotor = "rotor";
        String motor = "motor";
        
        System.out.println(rotor +" es capipcua: " + isPalindromo(rotor));
        System.out.println(motor +" es capipcua: " + isPalindromo(motor));

        /*
        //Ejercicio 11
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13}; // arreglo ordenado

        int elem1 = 5;
        int elem2 = 8;

        System.out.println("El elemento " + elem1 + " esta en el arreglo: "
                + buscarElemento(arreglo, elem1, 0, arreglo.length - 1));

        System.out.println("El elemento "  + elem2 + " esta en el arreglo: "
                + buscarElemento(arreglo, elem2, 0, arreglo.length - 1));*/
    }


    public static boolean isPalindromo(String cadena){
        if(cadena.length() <= 1){ // Caso base: cadena vacía o con un solo caracter es palindrómica
            return true;
        }else{
            if(cadena.charAt(0) == cadena.charAt(cadena.length()-1)){ // Verifica si el primer y último caracter son iguales
                cadena = cadena.substring(1,cadena.length()-1);
                return isPalindromo(cadena); // Llamada recursiva para verificar el resto de la cadena
            }else{
                return false; //Si los caracteres no son iguales, no es palindrómica
            }
        }
    }

    //Ejercicio 11
    public static boolean buscarElemento(int[] arr, int elemento, int inicio, int fin) {
        if (inicio > fin) {
            return false; // Caso base: el elemento no se encontró
        }

        int medio = inicio + (fin - inicio) / 2; // Calcula el índice medio

        if (arr[medio] == elemento) {
            return true; // Caso base: el elemento se encontró en el medio
        } else if (arr[medio] > elemento) {
            // Llamada recursiva para buscar en la mitad inferior del arreglo
            return buscarElemento(arr, elemento, inicio, medio - 1);
        } else {
            // Llamada recursiva para buscar en la mitad superior del arreglo
            return buscarElemento(arr, elemento, medio + 1, fin);
        }
    }


    public static LinkedList<Integer> combinarListasOrdenadas(LinkedList<Integer> lista1, LinkedList<Integer> lista2){

        LinkedList<Integer> nuevaLista = new LinkedList<Integer>();
        MyIterator<Integer> iterator1 = lista1.iterator();
        MyIterator<Integer> iterator2 = lista2.iterator();
        while ((iterator1.hasNext()) && (iterator2.hasNext())){
            if (iterator1.getInfoNodo()< iterator2.getInfoNodo()){
                iterator1.next();
            }
            else if(iterator2.getInfoNodo()< iterator1.getInfoNodo()){
                iterator2.next();
            }
            else if(iterator1.getInfoNodo() == iterator2.getInfoNodo()){
                nuevaLista.insertLast(iterator1.getInfoNodo());
                iterator1.next();
                iterator2.next();

            }
        }
        return nuevaLista;

    }
}


