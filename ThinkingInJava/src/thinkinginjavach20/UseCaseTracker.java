// 5
package thinkinginjavach20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        useCases.forEach((i) -> {
            System.out.println("Warning: Missing use case - " + i);
        });
    }
    
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50, 51);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
/*
Found Use Case: 49 New passwords can't equal previously used ones
Found Use Case: 47 Password must contain at least one numeric
Found Use Case: 48 no description
Warning: Missing use case - 50
Warning: Missing use case - 51
*/