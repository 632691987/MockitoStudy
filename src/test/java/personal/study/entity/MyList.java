package personal.study.entity;

import java.util.AbstractList;

public class MyList<String> extends AbstractList<String> {

    @Override
    public String get(final int index) {
        return null;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public void add(int index, String element) {
        // no-op
    }

    final public int finalMethod() {
        return 0;
    }
}
