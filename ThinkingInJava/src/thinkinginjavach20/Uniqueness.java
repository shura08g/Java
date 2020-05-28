// 11
package thinkinginjavach20;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
