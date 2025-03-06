package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.ArrayList;

public class ResourceArrayList implements ResourceList {

    private final ArrayList<ResourceObject> resources;

    public ResourceArrayList() {
        resources = new ArrayList<>();
    }

    @Override
    public void add(ResourceObject resource) {
        resources.add(resource);
    }

    @Override
    public void remove(ResourceObject resource) {
        resources.remove(resource);
    }

    @Override
    public void truncate(ResourceObject resource) {
        int index = resources.indexOf(resource);
        if (index != -1){
            resources.subList(index, resources.size()).clear();
        }
    }

    @Override
    public void follow(GameObject leader) {
        if (resources.isEmpty()) return;

        resources.getFirst().moveTowards(leader);

        for (int i = 1; i < resources.size(); i++) {
            resources.get(i).moveTowards(resources.get(i - 1));
        }
    }
}
