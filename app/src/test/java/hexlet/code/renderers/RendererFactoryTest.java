package hexlet.code.renderers;

import hexlet.code.exceptions.UnsupportedOutputFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RendererFactoryTest {

    @Test
    void getRenderer() {
        final Renderer renderer = RendererFactory.getRenderer("stylish");
        assertEquals(StylishRenderer.class, renderer.getClass());
    }

    @Test
    void getRendererWithException() {
        final var thrown = assertThrows(UnsupportedOutputFormatException.class,
                () -> RendererFactory.getRenderer(""));
        assertEquals("The output format is not supported", thrown.getMessage());
    }
}
