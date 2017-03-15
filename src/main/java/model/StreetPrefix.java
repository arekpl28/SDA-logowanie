package model;

public enum StreetPrefix {
    STREET("ul."), AVENUE("al."), SQUERE("pl.");

    private final String prefix;

    StreetPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

}
