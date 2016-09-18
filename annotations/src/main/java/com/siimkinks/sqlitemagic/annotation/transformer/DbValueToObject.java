package com.siimkinks.sqlitemagic.annotation.transformer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks that method transforms database retrieved raw object to Java object.<br>
 * Marked method must be a static method inside a class that is marked with {@link Transformer}
 * annotation.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface DbValueToObject {
}
