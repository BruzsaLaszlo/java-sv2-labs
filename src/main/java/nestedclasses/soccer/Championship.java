package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Championship {

    public static class GameResult {
        private String teamHome;
        private String teamGuest;
        private int goalHome;
        private int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }

    private List<TeamStatistics> leagueTable = new ArrayList<>();

    public void addGame(GameResult result) {
        TeamStatistics teamHome = findTeamByName(result.teamHome).orElseGet(() -> {
            TeamStatistics team = new TeamStatistics(result.teamHome);
            leagueTable.add(team);
            return team;
        });
        TeamStatistics teamGuest = findTeamByName(result.teamGuest).orElseGet(() -> {
            TeamStatistics team = new TeamStatistics(result.teamGuest);
            leagueTable.add(team);
            return team;
        });
        teamHome.played(result.goalHome, result.goalGuest);
        teamGuest.played(result.goalGuest, result.goalHome);
    }

    public List<TeamStatistics> getLeagueTable() {
        return List.copyOf(leagueTable);
    }

    private Optional<TeamStatistics> findTeamByName(String name) {
        for (TeamStatistics teamStatistics : leagueTable) {
            if (teamStatistics.getName().equals(name)) {
                return Optional.of(teamStatistics);
            }
        }
        return Optional.empty();
    }
}
