public class Level1 {
    public static String MassVote(int n, int[] votes) {
        if (n == 1) {
            return "majority winner 1";
        }

        int[] ma = new int[n];
        double sumOfAllVotes = 0;

        for (int i = 0; i < n; i++) {
            ma[i] = votes[i];
            sumOfAllVotes += votes[i];
        }

        double maxVotesPerPerson = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (ma[i] > maxVotesPerPerson) {
                maxVotesPerPerson = ma[i];
                num = i;
            }
        }

        ma[num] = 0;

        String win1 = "majority winner " + (num + 1);
        String win2 = "minority winner " + (num + 1);
        String win3 = "no winner";

        for (int i : ma) {
            if (i == maxVotesPerPerson) {
                return win3;
            }
        }

        double votingResult = maxVotesPerPerson / sumOfAllVotes * 100 * 1000;
        double rezTmp = Math.round(votingResult);
        votingResult = rezTmp / 1000;

        if (votingResult > 50) {
            return win1;
        }

        return win2;
    }
}
