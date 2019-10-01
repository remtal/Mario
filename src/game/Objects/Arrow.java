/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.*;

/**
 * @author tsami
 */

public class Arrow extends StaticBody {

    private static final Shape shape = new PolygonShape(
            -0.07f, 1.35f, -1.4f, -0.86f, 0.03f, -1.31f, 1.44f, -0.88f, 0.53f, 0.63f


    );


    private static BodyImage image =
            new BodyImage("data/arrow.png", 2.0f);


    /**
     * Constructor for Arrow
     */
    public Arrow(World world) {
        super(world, shape);

        addImage(image);


    }


}


 