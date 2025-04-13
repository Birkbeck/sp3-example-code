package common.widget.com.thing;


import common.widget.org.jwidgets.SimpleRenderer;

public class RendererSupport {
    public void render(final Object object) {
        new SimpleRenderer().renderAsString(object);
    }
}