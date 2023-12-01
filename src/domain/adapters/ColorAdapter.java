package domain.adapters;

public record ColorAdapter(int r, int g, int b) {
    @Override
    public String toString() {
        return String.format("[%s, %s, %s]", r, g, b);
    }
}
