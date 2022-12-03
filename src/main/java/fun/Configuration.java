package fun;

import smtp.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Configuration {
    public String[] victims;
    public Joke[] jokes;

    public Joke getRandomJoke(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, jokes.length);
        return jokes[randomNum];
    }

    public Group[] createGroups(int count){
        if (victims.length < 3){
            throw new RuntimeException("Too few victims setup. Must be at least 3.");
        }

        int victimsPerGroup = victims.length / count;
        if (victimsPerGroup < 3){
            throw new RuntimeException("Too few victims to create " + count + " groups of at least 3 victims.");
        }

        List<String> victimsList = Arrays.asList(victims);
        Collections.shuffle(victimsList);

        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            Group group = new Group();
            group.setFrom(victims[i]);
            groups.add(group);
        }

        for (int i = 0; i < victims.length - count; ++i){
            groups.get(i % count).addTo(victims[i + count]);
        }

        return groups.toArray(new Group[0]);
    }
}
