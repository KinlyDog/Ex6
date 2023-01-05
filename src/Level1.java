public class Level1 {
    public static String MassVote(int n, int[] votes) {
        if (n == 1) {
            return "majority winner 1";
        }

        int[] ballot = new int[n];
        double sumOfAllVotes = 0;

        for (int i = 0; i < n; i++) {
            ballot[i] = votes[i];
            sumOfAllVotes += votes[i];
        }

        double maxVotesPerPerson = 0;
        int winner = 0;
        for (int i = 0; i < n; i++) {
            if (ballot[i] > maxVotesPerPerson) {
                maxVotesPerPerson = ballot[i];
                winner = i;
            }
        }

        ballot[winner] = 0;

        String win1 = "majority winner " + (winner + 1);
        String win2 = "minority winner " + (winner + 1);
        String win3 = "no winner";

        // проверка наличия кандидата с таким же максимальным количеством голосов
        for (int i : ballot) {
            if (i == maxVotesPerPerson) {
                return win3;
            }
        }

        // вычисляем процент голосов за победителя с точностью до 3 знаков
        assert (sumOfAllVotes != 0);
        double votingResult = maxVotesPerPerson / sumOfAllVotes * 100 * 1000;
        double rezTmp = Math.round(votingResult);
        votingResult = rezTmp / 1000;

        if (votingResult > 50) {
            return win1;
        }

        return win2;
    }
}
