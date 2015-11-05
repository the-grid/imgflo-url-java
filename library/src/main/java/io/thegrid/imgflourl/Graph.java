package io.thegrid.imgflourl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Specification for the graph to be used for processing an image
 */
public class Graph {
  public static final Integer NO_DIMENSION = null;

  /**
   * Simple graph that does nothing but resizing.
   */
  public static class Passthrough extends Graph {
    /**
     * Creates a new Passthrough graph configuration
     *
     * @param width  Target width of the image or {@link #NO_DIMENSION} for keeping the aspect ratio
     * @param height Target height of the image or {@link #NO_DIMENSION} for keeping the aspect ratio
     */
    public Passthrough(Integer width, Integer height) {
      super("passthrough", width, height);
    }
  }

  private final String name;
  private final Map<String, String> params;

  private Graph(String name, Integer width, Integer height) {
    this.name = name;
    this.params = new LinkedHashMap<String, String>();

    if (height != null) {
      addParam("height", height);
    }
    if (width != null) {
      addParam("width", width);
    }
  }

  public String getName() {
    return name;
  }

  public Map<String, String> getParams() {
    return params;
  }

  void addParam(String name, String value) {
    params.put(name, value);
  }

  void addParam(String name, int value) {
    addParam(name, String.valueOf(value));
  }
}