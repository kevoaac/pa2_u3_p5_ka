package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {
    void accept(T arg);
}
