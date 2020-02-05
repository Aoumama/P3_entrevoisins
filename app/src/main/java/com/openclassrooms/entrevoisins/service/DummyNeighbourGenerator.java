package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "1 allée gutemberg 93200 Saint-denis", "06.48.22.28.09", "www.facebook.fr/Caroline", "Bonjour, Je sais pas quoi dire"),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e", "2 rue Alexis Leonov 93200 La Courneuve", "06.14.42.65.85", "www.facebook.fr/Jack", "Hello ! A tous"),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", "3 avenue Gustave Eifeil 93600 Aulnay-Sous-Bois", "07.33.85.64.57", "www.facebook.fr/Chloe","Coucou tous le monde"),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a",  "1 allée gutemberg 93200 Saint-denis", "06.48.22.28.09", "www.facebook.fr/Vincent", "Bonjour, Je sais pas quoi dire"),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b",  "2 rue Alexis Leonov 93200 La Courneuve", "06.14.42.65.85", "www.facebook.fr/Elodie", "Hello ! A tous"),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", "44 rue des fauvettes 93120 Blanc-Mesnil", "07.99.63.45.71", "www.facebook.fr/Sylvain", "Hey !"),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d",  "3 avenue Gustave Eifeil", "07.33.85.64.57", "www.facebook.fr/Laeticia","Coucou tous le monde"),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b",  "1 allée gutemberg 93200 Saint-denis", "06.48.22.28.09", "www.facebook.fr/Dan", "Bonjour, Je sais pas quoi dire"),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d",  "2 rue Alexis Leonov 93200 La Courneuve", "06.14.42.65.85", "www.facebook.fr/Joseph", "Hello ! A tous"),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d",  "44 rue des fauvettes 93120 Blanc-Mesnil", "07.99.63.45.71", "www.facebook.fr/Emma", "Hey !"),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d",  "3 avenue Gustave Eifeil", "07.33.85.64.57", "www.facebook.fr/Patrick","Coucou tous le monde"),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d",  "1 allée gutemberg 93200 Saint-denis", "06.48.22.28.09", "www.facebook.fr/Ludovic", "Bonjour, Je sais pas quoi dire")
    );

    static List<Neighbour> generateNeighbours() { return new ArrayList<>(DUMMY_NEIGHBOURS);
    }


}
