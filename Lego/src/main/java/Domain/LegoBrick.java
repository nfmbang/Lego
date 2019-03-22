/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nille
 */
public class LegoBrick {

    private final int Height, Width, Length;
    private final Map dim = new HashMap();

    public LegoBrick(int Height, int Width, int Length) {
        this.Height = Height;
        this.Width = Width;
        this.Length = Length;
        dim.put("Height", Height);
        dim.put("Width", Width);
        dim.put("Length", Length);
    }

    /**
     * yes
     *
     * @return Height of the brick.
     */
    public int getHeight() {
        return Height;
    }

    /**
     *
     * @return Width of the brick.
     */
    public int getWidth() {
        return Width;
    }

    /**
     *
     * @return Length of the brick.
     */
    public int getLength() {
        return Length;
    }

    /**
     *
     * @return Map of dimensions, Height, Width, Length.
     */
    public Map getDim() {
        return dim;
    }
}
