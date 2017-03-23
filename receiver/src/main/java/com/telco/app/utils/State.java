package com.telco.app.utils;

public enum State {
    NEW,
    MODIFIED,
    REMOVED;

    public static State getValue(final String s) {
        for (State state : values()) {
            if (state.name().equalsIgnoreCase(s)) {
                return state;
            }
        }
        throw new IllegalArgumentException(String.format("Can't find state %s", s));
    }
}
