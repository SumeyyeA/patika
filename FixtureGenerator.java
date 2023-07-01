import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FixtureGenerator {
    private List<String> teams;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
    }

    public List<String> generateFixture() {
        List<String> fixture = new ArrayList<>();

        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int totalRounds = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        for (int round = 0; round < totalRounds; round++) {
            for (int match = 0; match < matchesPerRound; match++) {
                int homeTeamIndex = (round + match) % (teams.size() - 1);
                int awayTeamIndex = (teams.size() - 1 - match + round) % (teams.size() - 1);

                if (match == 0) {
                    awayTeamIndex = teams.size() - 1;
                }

                String homeTeam = teams.get(homeTeamIndex);
                String awayTeam = teams.get(awayTeamIndex);

                String matchInfo = homeTeam + " vs " + awayTeam;
                fixture.add(matchInfo);
            }
        }

        return fixture;
    }

    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        FixtureGenerator generator = new FixtureGenerator(teams);
        List<String> fixture = generator.generateFixture();

        for (int i = 0; i < fixture.size(); i++) {
            System.out.println("Round " + (i + 1));
            System.out.println(fixture.get(i));
            System.out.println();
        }
    }
}
