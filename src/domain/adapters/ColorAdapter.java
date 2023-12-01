package domain.adapters;

public record ColorAdapter(String r, String g, String b) {
    @Override
    public String toString() {
        return String.format("[%s, %s, %s]", r, g, b);
    }
}
