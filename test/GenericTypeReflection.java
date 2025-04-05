import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericTypeReflection {

    ArrayList<String> listField = new ArrayList<>();
    
    @Test
    public  void main() throws NoSuchFieldException {
        var list = new ArrayList<String>();

        Class<?> clazz = list.getClass();
        System.out.println(clazz); // class java.util.ArrayList

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass); // class java.util.AbstractList<E>
    }
    
    @Test
    public void typeOfField() throws NoSuchFieldException {
        Field field = GenericTypeReflection.class.getDeclaredField("listField");

        Type genericType = field.getGenericType();

        if (genericType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) genericType;
            Type actualType = pt.getActualTypeArguments()[0];
            System.out.println("Generic type: " + actualType); // 💡 java.lang.String
        }
    }

    public static Type getGenericType(Object list) throws NoSuchFieldException {
//        // Get the Class object of the ArrayList
//        Class<?> clazz = list.getClass();
//
//        // If the list is a ParameterizedType (e.g., ArrayList<String>), we can check its generic type
//        if (clazz.getGenericSuperclass() instanceof ParameterizedType) {
//            ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
//            return parameterizedType.getActualTypeArguments()[0];
//        }

        // Alternative: Check if it's a field (if stored in a class)
        // This is more useful when the generic type is retained (e.g., in class fields)
        Field field = GenericTypeReflection.class.getDeclaredField("list");
        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericFieldType;
            return pType.getActualTypeArguments()[0];
        }

        return null;

        //return clazz; // Fallback: returns the raw type (ArrayList)
    }
}