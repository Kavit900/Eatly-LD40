package com.zenwraight.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;

public interface PhysicsBody<T> {
    String getTag();

    T getObject();

    void beginContact(Contact contact, PhysicsBody other);

    Body getBody();
}