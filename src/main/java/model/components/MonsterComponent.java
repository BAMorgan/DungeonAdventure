package model.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import model.EntityType;

public class MonsterComponent extends Component {
    private final int myMinHeal;
    private final int myMaxHeal;
    private HealerComponent myHealerComponent;
    private final CharacterComponent myCharacterComponent;
    public MonsterComponent(final int theMinHeal, final int theMaxHeal, final int theMinDmg,
                            final int theMaxDmg, final int theAtkSpd, final Double theChncHit,
                            final int theHealth, final String theName) {
        super();
        myCharacterComponent = new CharacterComponent(theMinDmg,
                theMaxDmg, theAtkSpd, theChncHit, theHealth, theName);
        myMinHeal = theMinHeal;
        myMaxHeal = theMaxHeal;
    }
    
    @Override
    public void onUpdate(final double theTpf) {
        final Entity player = FXGL.getGameWorld().getSingleton(EntityType.PLAYER);
        
        if (getEntity().distance(player) > 48) {
            getEntity().translateTowards(player.getPosition(), 3);
        }
        
        if (getEntity().getX() < player.getX()) {
            getEntity().setScaleX(1);
        } else {
            getEntity().setScaleX(-1);
        }
    }
    
    public CharacterComponent getMyCharacterComponent() {
        return myCharacterComponent;
    }
}
