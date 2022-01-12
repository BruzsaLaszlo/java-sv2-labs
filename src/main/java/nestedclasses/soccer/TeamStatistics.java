package nestedclasses.soccer;

import java.util.Objects;

public class TeamStatistics {

    private class Games {
        private int played;
        private int won;
        private int tied;
        private int lost;
    }

    private class Goals {
        private int goalsFor;
        private int goalsAgainst;
    }

    private String name;
    private int points;
    private Games games = new Games();
    private Goals goals = new Goals();

    public TeamStatistics(String name) {
        this.name = name;
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst) {
        goals.goalsFor += plusGoalsFor;
        goals.goalsAgainst += plusGoalsAgainst;
        games.played++;
        if (plusGoalsFor > plusGoalsAgainst) {
            games.won++;
            points += 3;
        } else if (plusGoalsFor == plusGoalsAgainst) {
            games.tied++;
            points++;
        } else {
            games.lost++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamStatistics that = (TeamStatistics) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public Games getGames() {
        return games;
    }

    public Goals getGoals() {
        return goals;
    }

    public int getPlayed() {
        return games.played;
    }

    public int getWon() {
        return games.won;
    }

    public int getTied() {
        return games.tied;
    }

    public int getLost() {
        return games.lost;
    }

    public int getGoalsfor() {
        return goals.goalsFor;
    }

    public int getGoalsAgainst() {
        return goals.goalsAgainst;
    }
}
