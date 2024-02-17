package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
    boolean evaluar(T arg);
}
