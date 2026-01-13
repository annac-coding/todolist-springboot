package annaccoding.todolist.util;

public final class TextNormalizer {

    private TextNormalizer() {
        // impede instanciação
    }

    public static String normalize(String value) {
        return (value == null || value.isBlank()) ? null : value.trim();
    }
}
