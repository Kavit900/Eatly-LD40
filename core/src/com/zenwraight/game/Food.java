package com.zenwraight.game;


import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Food extends Entity implements PhysicsBody<Food>{

    public static final String TAG = "Food";

    public static int COLLECT_COUNT = 0;

    private Body body;

    public Food(GameStage gameStage, MapObject obj) {
        super(gameStage, Res.createSprite("food1"));

        float x = (Float)(obj.getProperties().get("x"));
        float y = (Float)(obj.getProperties().get("y"));
        float w = (Float)(obj.getProperties().get("width"));
        float h = (Float)(obj.getProperties().get("height"));

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        body = gameStage.getWorld().createBody(bodyDef);

        FixtureDef def = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(0.25f);
        def.shape = shape;
        Fixture f = body.createFixture(def);
        f.setSensor(true);
        shape.dispose();
        body.setUserData(this);

        setPosition(x, y);

        x *= Constants.SCR2BOX;
        y *= Constants.SCR2BOX;
        w *= Constants.SCR2BOX;
        h *= Constants.SCR2BOX;
        body.setTransform(x + w / 2f, y + h / 2f, 0f);
    }
    @Override
    public boolean remove() {
        gameStage.queueForDestruction(body);
        return super.remove();
    }

    @Override
    public String getTag() {
        return TAG;
    }

    @Override
    public Food getObject() {
        return this;
    }

    @Override
    public void beginContact(Contact contact, PhysicsBody other) {

    }

    @Override
    public Body getBody() {
        return body;
    }
}