/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.*;
import game.Listeners.Pickup;
import game.Sprites.Mario;
import org.jbox2d.common.Vec2;

/**
 * @author tsami
 */

public class Block extends StaticBody {

    private static final Shape shape = new BoxShape(0.6f, 0.6f);
    private static final BodyImage image
            = new BodyImage("data/block.png", 1.2f);
    private Mario mario;
    private static final BodyImage empty = new BodyImage("data/empty.jpg", 1.2f);

    public Block(World world, Mario mario) {
        super(world, shape);
        addImage(image);
        this.mario = mario;
    }

    /**
     * Method to create new Token.
     */
    public void makeToken() {
        Body token = new Token(getWorld());
        token.setPosition(new Vec2(getPosition().x, getPosition().y + 1));
        Pickup pickup = new Pickup(mario);
        pickup.setBlock(this);
        token.addCollisionListener(pickup);


    }

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }

    public void createNewImage() {
        removeAllImages();
        addImage(empty);
    }
}
