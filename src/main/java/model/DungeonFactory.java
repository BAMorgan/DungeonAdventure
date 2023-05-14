package model;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import controller.PlayerComponent;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;


public class DungeonFactory implements EntityFactory {

    @Spawns("wall")
    public Entity newDungeonWall(SpawnData data){
        return entityBuilder(data)
                .type(TerrainType.DUNGEONWALL)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .with(new CollidableComponent(true))
                .build();
    }

    @Spawns("door")
    public Entity newDungeonDoor(SpawnData data){
        return entityBuilder(data)
                .type(TerrainType.DUNGEONDOOR)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())

                .build();
    }
    @Spawns("player")
    public Entity newPlayer(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);

        return entityBuilder()
                .type(CharacterType.PLAYER)
                .viewWithBBox("player.png")
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new PlayerComponent())
                .build();
    }


}
