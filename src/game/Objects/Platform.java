/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.*;


public class Platform extends StaticBody {
    private static final BodyImage image = new BodyImage("data/platform1.png", 1f);

//    private static final Shape shape = new PolygonShape(
//            -2.61f,0.49f, -2.62f,-0.485f, 2.568f,-0.485f, 2.578f,0.469f

    private static final Shape shape = new BoxShape(2.4f, 0.5f);


    public Platform(World world) {
        super(world, shape);
        addImage(image);
    }

}