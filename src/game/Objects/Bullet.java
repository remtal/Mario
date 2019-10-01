/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Objects;

import city.cs.engine.CircleShape;
import city.cs.engine.Walker;
import city.cs.engine.World;

import java.util.Timer;
import java.util.TimerTask;

public class Bullet extends Walker{

    private Timer timer;


    public Bullet(World world, float shapeX, float shapeY)
    {
        super(world, new CircleShape(0.2f));
        setBullet(true);
        /**
         Use of Timer so Bullet is destroyed after certain time
         */
        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {
                try{
                    Bullet.this.destroy();
                }catch(NullPointerException npe){

                }
            }
        }, 550,550);
    }

}