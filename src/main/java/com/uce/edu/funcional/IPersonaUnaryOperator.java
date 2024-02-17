package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
    T aplicar(T arg);
}
