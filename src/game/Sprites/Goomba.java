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

public class Goomba extends Walker implements StepListener {


    private static final Shape shape = new PolygonShape(-0.048f, 0.996f, -0.496f, 0.956f, -0.976f, 0.32f,
            -0.984f, -0.964f, 0.96f, -0.964f, 0.976f, 0.18f, 0.36f, 0.94f);

    private static final BodyImage image
            = new BodyImage("data/goomba.png", 2.0f);

    private static float G1WALKING_SPEED = 4;


    public Goomba(World world) {
        super(world, shape);
        addImage(image);
        this.startWalking(G1WALKING_SPEED);
        world.addStepListener(this);

    }


    /**
     * Step Listener used to make the Goomba move between two x coordinates
     */

    @Override
    public void preStep(StepEvent stepEvent) {

        if (this.getPosition().x > 11.5) {

            G1WALKING_SPEED = -4;
            this.startWalking(G1WALKING_SPEED);
        } else if (this.getPosition().x < -11.5) {
            G1WALKING_SPEED = 4;
            this.startWalking((G1WALKING_SPEED));
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

}
 