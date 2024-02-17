package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaFunction<T, R> {
    T aplicar(R arg);
}
