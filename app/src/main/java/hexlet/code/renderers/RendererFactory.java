package hexlet.code.renderers;

import hexlet.code.exceptions.UnsupportedOutputFormatException;

public final class RendererFactory {
    public static Renderer getRenderer(final String type) {
        try {
            return switch (Format.valueOf(type.toUpperCase())) {
                case STYLISH -> new StylishRenderer();
                case JSON -> null;
            };
        } catch (Exception e) {
            throw new UnsupportedOutputFormatException("The output format is not supported");
        }
    }
}
