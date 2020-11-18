package com.bonnysid.human;

import java.util.List;

public interface Converter<E, T> {
    List<T> convert(List<E> in);
}
