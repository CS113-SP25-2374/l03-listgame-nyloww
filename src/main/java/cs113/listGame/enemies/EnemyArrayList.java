package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.FollowObject;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import cs113.listGame.gamecore.GameObject;
import cs113.listGame.gamecore.PlayerObject;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyArrayList extends EnemyObject {
    private final List<Behavior> behaviorList;
    private final Random random;

    public EnemyArrayList(ImageView imageView) {
        super(imageView);
        this.behaviorList = new ArrayList<>();
        this.random = new Random();
        seedBehaviors();
    }


    @Override
    public void seedBehaviors() {
        behaviorList.clear();

        GameObject PlayerObject = null;
        behaviorList.add(new FollowObject(this, 2000, null));
        behaviorList.add(new MoveToPoint(this, 3000, new Point2D(100, 200)));
        behaviorList.add(new Waiting(this, 2500));
        behaviorList.add(new FollowObject(this, 1500, null));
        behaviorList.add(new MoveToPoint(this, 2200, new  Point2D(400, 500)));
    }

    @Override
    public Behavior getNextBehavior() {
        if (behaviorList.isEmpty()) {
            seedBehaviors();
        }

        int index = random.nextInt(behaviorList.size());
        return behaviorList.remove(index);
    }
}