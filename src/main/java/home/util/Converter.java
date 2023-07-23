package home.util;

import java.util.List;

public interface Converter<S, T> {

    T convert(S source);

    default List<T> convert(List<S> source) {
        return source.stream().map(this::convert).toList();
    }

    default String getStringWithCheckForNull(String param) {
        return param == null ? "" : param;
    }

    default String getStatusWithCheckForNull(Enum param) {
        return param == null ? null : param.name(); // return param == null ? "" : param.name();
    }

}
