public class AmongUs {
    /**
     * Find out the imposter in the spaceship,
     * which each crew-mate suspect one other person,
     * while the imposter suspect nobody.
     *
     * @param n       number of people
     * @param suspect list of sus
     *                i.e. n = 2, suspect = [[1,2]] -> 1 suspect 2, and 2 suspect no one
     *                therefore 2 is the imposter
     * @return the label of the imposter or -1 if the imposter does not exist
     */
    public int findImposter(int n, int[][] suspect) {
        //initialize boolean array for killer
        boolean[] killer = new boolean[n];

        // for each suspect, determine whether if there is a killer
        for (int i = 0; i < suspect.length; i++) {
            killer[suspect[i][0]-1] = true;
        }

        // initialize index
        int index = -2;

        // determine if the suspect is a killer
        for (int j = 0; j < killer.length; j++) {
            if (!killer[j]) {
                    index = j;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        AmongUs findKiller = new AmongUs();
        //Input: n = 4, suspect = [[1,3],[1,4],[2,3],[2,4],[4,3]]
        //Output: 3
        int[][] sus1 = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findKiller.findImposter(4, sus1));
        //Input: n = 2, suspect = [[1,2]]
        //Output: 2
        int[][] sus2 = {{1,2}};
        System.out.println(findKiller.findImposter(2, sus2));
        //Input: n = 3, suspect = [[1,3],[2,3],[3,2]]
        //Output: -1
        int[][] sus3 = {{1,3},{2,3},{3,2},};
        System.out.println(findKiller.findImposter(3, sus3));
    }
}