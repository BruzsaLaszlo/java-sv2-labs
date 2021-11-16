package defaultconstructor.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessTournament {

    private List<Team> teams;

    public ChessTournament() {
        teams = List.of(new Team(), new Team(), new Team());
    }

    public void addPlayesToTeams(List<Player> playersRegistrated) {

        int count = playersRegistrated.size() > 6 ? 6 : playersRegistrated.size();

        for (int i = 0; i < count; i++) {
            teams.get(i/2).setPlayerOne(playersRegistrated.get(i));
            teams.get(i/2).setPlayerTwo(playersRegistrated.get(i));
        }

    }

}
