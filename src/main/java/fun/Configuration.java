/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package fun;

import smtp.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Représente la configuration de l'application SmtpJoker.
 */
public class Configuration {
    public String[] victims;
    public Joke[] jokes;

    /**
     *
     * @return Une blague sélectionnée aléatoirement.
     */
    public Joke getRandomJoke(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, jokes.length);
        return jokes[randomNum];
    }

    /**
     * Crée 'count' groupes.
     * @param count Nombre de groupes à créer.
     * @return Un tableau de groupes contenant des victimes et permettant de renseigner l'émetteur et les récepteurs
     * d'un mail.
     */
    public Group[] createGroups(int count){
        if (victims.length < 3){
            throw new RuntimeException("Too few victims setup. Must be at least 3.");
        }

        for (String victim : victims) {
            if (victim == null || victim.isEmpty() || victim.trim().isEmpty()) {
                throw new RuntimeException("Victim cannot be null or empty");
            }
        }

        int victimsPerGroup = victims.length / count;
        if (victimsPerGroup < 3){
            throw new RuntimeException("Too few victims to create " + count + " groups of at least 3 victims.");
        }

        List<String> victimsList = Arrays.asList(victims);
        Collections.shuffle(victimsList);
        victimsList.toArray(victims);

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
