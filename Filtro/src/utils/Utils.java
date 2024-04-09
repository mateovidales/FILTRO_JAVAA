package utils;

import java.util.List;

public class Utils {
    public static <obj> obj[] listToArray(List<obj> list){
        //crear un arreglo de Object del tamaño de la lista
        obj[] array = (obj[]) new Object[list.size()];

        int i=0;
        for (obj iterador:list){
            array[i++] = iterador;
        }
        return array;
    }
}
