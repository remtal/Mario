/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Sprites;

import city.cs.engine.*;

/**
 * @author tsami
 */

public class Peach extends StaticBody {

    private static final Shape shape = new PolygonShape(-0.16f, 1.27f, -0.76f, 0.79f, -0.74f, -1.29f, 0.62f, -1.31f, 0.66f, 0.78f, 0.03f, 1.2f);


    private static BodyImage image =
            new BodyImage("data/peach2.png", 3.0f);


    public Peach(World world) {
        super(world, shape);
        addImage(image);


    }


}


 