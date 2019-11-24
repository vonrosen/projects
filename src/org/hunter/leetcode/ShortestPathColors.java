package org.hunter.leetcode;

public class ShortestPathColors {

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        ShortestPathColors s = new ShortestPathColors();
//        int n = 9;
//        int [][] red_edges = new int [][] {
//                {1, 1},
//                {1, 6},
//                {6, 8}
//        };
//        int [][] blue_edges = new int [][] {
//            {0, 1},
//            {1, 6}
//        };

//        100
//        [[15,8],[21,13],[69,30],[14,90],[77,86],[62,24],[99,78],[89,44],[70,50],[45,44],[94,17],[27,21],[29,48],[79,77],[32,59],[33,89],[70,66],[45,34],[42,3],[18,84],[57,51],[91,44],[81,68],[76,14],[96,28],[16,13],[67,4],[65,24],[2,41],[35,73],[24,4],[96,77],[51,15],[53,91],[91,35],[2,6],[90,95],[45,49],[41,35],[53,50],[69,79],[99,17],[43,29],[84,82],[86,63],[39,63],[18,69],[19,73],[57,30],[59,68],[43,45],[3,29],[15,19],[77,1],[50,89],[59,9],[21,10],[84,56],[4,28],[0,34],[62,49],[73,42],[70,14],[8,71],[16,21],[63,51],[12,24],[56,4],[2,25],[71,48],[93,83],[5,11],[28,64],[67,54],[3,18],[10,75],[81,37],[68,79],[26,95],[72,85],[15,95],[62,16],[65,49],[78,29],[20,99],[16,49],[24,34],[9,58],[83,99],[71,10],[67,1],[34,36],[31,61],[62,64],[81,95],[84,34],[63,26],[90,70],[55,16],[23,83],[54,7],[81,15],[88,90],[99,58],[45,13],[21,28],[28,14],[60,98],[41,13],[25,95],[40,5],[69,78],[8,94],[78,12],[15,5],[96,11],[0,32],[79,98],[9,55],[69,65],[52,56],[39,31],[81,89],[85,72],[71,17],[99,52],[27,15],[91,48],[61,97],[23,91],[88,68],[70,28],[83,45],[61,36],[34,2],[90,8],[86,78],[66,0],[61,4],[48,26],[75,75],[92,75],[46,2],[89,73],[62,70],[45,50],[83,41],[69,29],[99,87],[64,21],[68,55],[12,77],[13,91],[74,28],[22,23],[77,51],[13,55],[49,68],[78,60],[57,29],[15,42],[80,94],[2,27],[19,25],[54,62],[19,37],[40,76],[38,87],[70,32],[34,17],[72,25],[15,48],[63,44],[40,31],[74,7],[66,16],[70,47],[28,71],[36,30],[96,20],[52,29],[72,47],[36,16],[9,39],[21,35],[65,41],[70,12],[13,18],[11,69],[98,11],[71,45],[66,99],[89,76],[87,55],[10,95],[8,18],[93,0],[4,21],[40,30],[19,68],[9,15],[74,81],[75,63],[85,16],[47,8],[9,78],[76,32],[48,4],[72,75],[42,94],[49,69],[68,78],[51,37],[49,66],[37,54],[28,76],[29,62],[74,45],[45,10],[26,20],[75,38],[50,2],[55,19],[84,89],[94,75],[65,72],[35,48],[82,63],[59,41],[47,3],[1,88],[79,43],[45,87],[91,6],[32,58],[5,27],[60,41],[11,55],[78,55],[10,7],[23,76],[98,10],[93,63],[64,50],[49,33],[11,49],[20,41]]
//        [[51,54],[49,66],[61,0],[72,70],[5,97],[86,22],[15,33],[65,52],[85,21],[54,77],[63,70],[6,12],[97,79],[13,45],[41,67],[8,65],[39,47],[56,43],[63,66],[52,66],[53,48],[4,74],[88,70],[74,1],[36,39],[4,32],[68,11],[7,57],[85,7],[93,21],[59,45],[64,51],[31,60],[30,60],[14,3],[56,72],[78,2],[47,98],[74,58],[63,5],[10,89],[3,6],[63,41],[3,22],[81,90],[25,4],[93,64],[18,3],[83,43],[82,19],[76,66],[8,48],[35,94],[44,54],[98,25],[71,20],[57,18],[81,26],[39,61],[5,43],[64,38],[76,58],[13,18],[9,55],[88,46],[74,34],[56,1],[58,67],[25,62],[61,82],[96,16],[65,3],[32,11],[10,18],[79,11],[33,3],[81,41],[13,62],[20,13],[93,93],[46,84],[69,94],[86,16],[14,14],[57,30],[66,35],[6,79],[57,79],[17,9],[38,84],[80,3],[99,96],[91,67],[52,3],[51,12],[1,1],[24,99],[72,32],[54,28],[30,97],[55,42],[42,95],[90,16],[97,58],[1,39],[25,22],[23,49],[55,95],[15,16],[83,18],[55,58],[75,56],[36,11],[19,46],[59,3],[71,58],[66,48],[17,97],[94,43],[98,89],[26,99],[97,33],[0,13],[81,43],[36,31],[19,16],[53,5],[93,40],[93,28],[72,22],[12,6],[40,90],[11,88],[70,46],[59,51],[96,10],[21,86],[54,74],[93,36],[26,23],[12,84],[37,21],[40,37],[52,18],[47,72],[42,46],[72,55],[55,32],[64,31],[70,97],[91,41],[49,6],[58,48],[7,41],[49,22],[98,55],[98,93],[82,8],[13,16],[96,4],[95,24],[90,43],[41,82],[19,97],[35,20],[3,20],[64,40],[90,5],[78,21],[39,1],[8,91],[19,90],[29,33],[65,73],[21,66],[61,13],[3,9],[41,23],[50,33],[84,34],[0,1],[35,81],[63,32],[28,72],[5,27],[86,67],[20,25],[68,66],[22,59],[92,32],[65,22],[55,30],[31,66],[62,31],[17,41],[11,97],[1,51],[26,86],[72,23],[78,58],[96,15],[57,10],[40,47],[87,39],[79,6],[20,76],[54,15],[1,93],[43,31],[92,91],[61,38],[96,52],[21,74],[83,87],[45,57],[80,37],[63,30],[94,25],[41,59],[64,84],[96,62],[55,53],[8,97],[64,15],[7,29],[64,14],[97,25],[5,17],[20,22],[73,43],[35,72],[82,18]]

//          int n = 100;
//          int [][] red_edges = new int [][] {{15,8},{21,13},{69,30},{14,90},{77,86},{62,24},{99,78},{89,44},{70,50},{45,44},{94,17},{27,21},{29,48},{79,77},{32,59},{33,89},{70,66},{45,34},{42,3},{18,84},{57,51},{91,44},{81,68},{76,14},{96,28},{16,13},{67,4},{65,24},{2,41},{35,73},{24,4},{96,77},{51,15},{53,91},{91,35},{2,6},{90,95},{45,49},{41,35},{53,50},{69,79},{99,17},{43,29},{84,82},{86,63},{39,63},{18,69},{19,73},{57,30},{59,68},{43,45},{3,29},{15,19},{77,1},{50,89},{59,9},{21,10},{84,56},{4,28},{0,34},{62,49},{73,42},{70,14},{8,71},{16,21},{63,51},{12,24},{56,4},{2,25},{71,48},{93,83},{5,11},{28,64},{67,54},{3,18},{10,75},{81,37},{68,79},{26,95},{72,85},{15,95},{62,16},{65,49},{78,29},{20,99},{16,49},{24,34},{9,58},{83,99},{71,10},{67,1},{34,36},{31,61},{62,64},{81,95},{84,34},{63,26},{90,70},{55,16},{23,83},{54,7},{81,15},{88,90},{99,58},{45,13},{21,28},{28,14},{60,98},{41,13},{25,95},{40,5},{69,78},{8,94},{78,12},{15,5},{96,11},{0,32},{79,98},{9,55},{69,65},{52,56},{39,31},{81,89},{85,72},{71,17},{99,52},{27,15},{91,48},{61,97},{23,91},{88,68},{70,28},{83,45},{61,36},{34,2},{90,8},{86,78},{66,0},{61,4},{48,26},{75,75},{92,75},{46,2},{89,73},{62,70},{45,50},{83,41},{69,29},{99,87},{64,21},{68,55},{12,77},{13,91},{74,28},{22,23},{77,51},{13,55},{49,68},{78,60},{57,29},{15,42},{80,94},{2,27},{19,25},{54,62},{19,37},{40,76},{38,87},{70,32},{34,17},{72,25},{15,48},{63,44},{40,31},{74,7},{66,16},{70,47},{28,71},{36,30},{96,20},{52,29},{72,47},{36,16},{9,39},{21,35},{65,41},{70,12},{13,18},{11,69},{98,11},{71,45},{66,99},{89,76},{87,55},{10,95},{8,18},{93,0},{4,21},{40,30},{19,68},{9,15},{74,81},{75,63},{85,16},{47,8},{9,78},{76,32},{48,4},{72,75},{42,94},{49,69},{68,78},{51,37},{49,66},{37,54},{28,76},{29,62},{74,45},{45,10},{26,20},{75,38},{50,2},{55,19},{84,89},{94,75},{65,72},{35,48},{82,63},{59,41},{47,3},{1,88},{79,43},{45,87},{91,6},{32,58},{5,27},{60,41},{11,55},{78,55},{10,7},{23,76},{98,10},{93,63},{64,50},{49,33},{11,49},{20,41}};
//          int [][] blue_edges = new int [][] {{51,54},{49,66},{61,0},{72,70},{5,97},{86,22},{15,33},{65,52},{85,21},{54,77},{63,70},{6,12},{97,79},{13,45},{41,67},{8,65},{39,47},{56,43},{63,66},{52,66},{53,48},{4,74},{88,70},{74,1},{36,39},{4,32},{68,11},{7,57},{85,7},{93,21},{59,45},{64,51},{31,60},{30,60},{14,3},{56,72},{78,2},{47,98},{74,58},{63,5},{10,89},{3,6},{63,41},{3,22},{81,90},{25,4},{93,64},{18,3},{83,43},{82,19},{76,66},{8,48},{35,94},{44,54},{98,25},{71,20},{57,18},{81,26},{39,61},{5,43},{64,38},{76,58},{13,18},{9,55},{88,46},{74,34},{56,1},{58,67},{25,62},{61,82},{96,16},{65,3},{32,11},{10,18},{79,11},{33,3},{81,41},{13,62},{20,13},{93,93},{46,84},{69,94},{86,16},{14,14},{57,30},{66,35},{6,79},{57,79},{17,9},{38,84},{80,3},{99,96},{91,67},{52,3},{51,12},{1,1},{24,99},{72,32},{54,28},{30,97},{55,42},{42,95},{90,16},{97,58},{1,39},{25,22},{23,49},{55,95},{15,16},{83,18},{55,58},{75,56},{36,11},{19,46},{59,3},{71,58},{66,48},{17,97},{94,43},{98,89},{26,99},{97,33},{0,13},{81,43},{36,31},{19,16},{53,5},{93,40},{93,28},{72,22},{12,6},{40,90},{11,88},{70,46},{59,51},{96,10},{21,86},{54,74},{93,36},{26,23},{12,84},{37,21},{40,37},{52,18},{47,72},{42,46},{72,55},{55,32},{64,31},{70,97},{91,41},{49,6},{58,48},{7,41},{49,22},{98,55},{98,93},{82,8},{13,16},{96,4},{95,24},{90,43},{41,82},{19,97},{35,20},{3,20},{64,40},{90,5},{78,21},{39,1},{8,91},{19,90},{29,33},{65,73},{21,66},{61,13},{3,9},{41,23},{50,33},{84,34},{0,1},{35,81},{63,32},{28,72},{5,27},{86,67},{20,25},{68,66},{22,59},{92,32},{65,22},{55,30},{31,66},{62,31},{17,41},{11,97},{1,51},{26,86},{72,23},{78,58},{96,15},{57,10},{40,47},{87,39},{79,6},{20,76},{54,15},{1,93},{43,31},{92,91},{61,38},{96,52},{21,74},{83,87},{45,57},{80,37},{63,30},{94,25},{41,59},{64,84},{96,62},{55,53},{8,97},{64,15},{7,29},{64,14},{97,25},{5,17},{20,22},{73,43},{35,72},{82,18}};

//        100
//        [[1,70],[74,85],[13,37],[10,83],[95,71],[6,45],[4,83],[89,50],[20,15],[25,96],[97,10],[75,75],[57,53],[0,13],[30,63],[67,42],[15,32],[87,77],[36,15],[67,80],[14,74],[53,45],[97,19],[58,26],[1,60],[66,84],[29,46],[31,83],[6,83],[7,23],[87,30],[7,72],[69,22],[19,79],[6,53],[33,38],[4,50],[28,30],[68,92],[55,69],[20,83],[45,94],[93,64],[12,30],[73,3],[60,48],[80,49],[14,56],[97,61],[78,39],[6,16],[70,73],[34,15],[62,6],[48,12],[26,5],[36,86],[42,39],[84,77],[2,34],[82,0],[26,29],[88,78],[16,63],[29,50],[19,17],[28,25],[69,4],[0,5],[50,6],[81,19],[69,48],[53,55],[25,51],[87,25],[8,16],[47,44],[35,33],[14,61],[83,16],[73,45],[1,1],[11,78],[26,74],[56,87],[29,60],[21,52],[12,35],[17,50],[12,29],[81,73],[59,91],[55,8],[86,9],[34,23],[31,21],[79,86],[57,49],[76,0],[56,20],[75,50],[76,85],[52,69],[41,58],[87,75],[91,3],[0,70],[17,72],[6,25],[87,98],[88,82],[56,1],[31,52],[32,54],[26,27],[9,43],[20,21],[45,62],[5,18],[47,1],[76,3],[16,56],[48,9],[1,17],[1,40],[44,54],[52,64],[43,7],[62,17],[69,52],[81,10],[78,50],[74,83],[68,50],[23,11],[23,81],[79,8],[64,29],[60,34],[75,35],[4,91],[2,48],[99,53],[91,34],[23,86],[67,69],[80,28],[33,54],[73,15],[9,89],[69,3],[45,76],[62,33],[60,93],[32,50],[89,13],[65,54],[37,19],[1,36],[22,51],[38,37],[3,12],[97,32],[76,42],[79,92],[15,15],[87,84],[36,48],[32,9],[43,6],[85,33],[43,16],[30,22],[90,95],[30,24],[17,71],[26,44],[46,31],[92,80],[51,23],[90,64],[62,41],[74,72],[85,42],[67,14],[97,30],[25,57],[77,39],[29,97],[44,21],[20,99],[51,43],[61,25],[73,0],[80,21],[23,44],[2,55],[49,72],[38,17],[47,41],[38,82],[15,38],[85,10],[58,8],[15,28],[8,58],[63,21],[41,20],[67,58],[85,1],[56,25],[61,98],[72,91],[5,40],[99,8],[17,63],[78,88],[35,87],[75,46],[10,9],[99,41],[24,45],[94,44],[38,93],[25,80],[78,25],[60,40],[66,46],[50,14],[57,45],[76,81],[77,6],[24,83],[74,42],[60,19],[26,78],[49,19],[82,22],[98,26],[86,37],[64,66],[98,17],[69,47],[71,34],[99,16],[45,1],[18,19],[2,66],[74,88],[67,64],[39,72],[69,45],[14,2]]
//        [[9,60],[62,0],[56,87],[56,84],[78,44],[95,74],[53,33],[80,40],[81,45],[37,90],[25,26],[49,5],[47,87],[20,43],[84,26],[59,22],[5,91],[98,55],[40,29],[64,16],[68,61],[60,44],[38,12],[69,99],[7,62],[73,51],[12,8],[44,44],[16,87],[36,59],[33,5],[5,38],[81,34],[31,92],[7,32],[60,37],[87,54],[63,32],[28,32],[82,94],[36,16],[16,83],[35,13],[48,56],[60,67],[9,29],[39,2],[0,55],[71,21],[18,94],[32,42],[2,77],[99,56],[72,21],[64,68],[64,45],[89,56],[61,77],[96,38],[87,56],[94,91],[78,62],[1,43],[85,69],[61,29],[76,46],[21,36],[30,57],[97,20],[78,85],[67,69],[38,36],[95,45],[60,7],[75,92],[63,88],[9,53],[46,10],[57,4],[0,23],[51,89],[62,48],[80,75],[13,51],[29,32],[77,23],[1,13],[29,91],[10,32],[14,43],[13,36],[47,97],[63,41],[87,31],[86,47],[3,57],[18,32],[61,59],[8,47],[66,16],[60,23],[30,35],[15,8],[27,98],[11,95],[2,6],[99,19],[10,31],[20,72],[78,46],[55,20],[61,6],[19,18],[91,90],[5,27],[72,77],[90,24],[5,12],[3,6],[67,18],[70,84],[5,4],[40,63],[24,32],[26,57],[43,69],[33,32],[63,54],[17,57],[8,58],[3,88],[27,34],[54,0],[65,50],[7,13],[51,94],[48,85],[85,1],[12,2],[56,31],[69,44],[48,76],[18,93],[29,51],[4,45],[11,9],[25,27],[81,18],[94,18],[90,19],[82,14],[51,24],[9,57],[97,26],[95,50],[91,4],[30,38],[62,28],[61,9],[23,43],[64,54],[2,4],[12,61],[32,36],[72,65],[46,27],[64,1],[95,22],[10,90],[23,60],[25,99],[89,35],[59,63],[49,12],[31,72],[96,60],[77,98],[8,89],[98,40],[87,44],[40,69],[17,51],[56,2],[34,85],[62,31],[55,35],[17,23],[82,18],[55,27],[5,76],[76,64],[29,30],[33,93],[0,22],[3,30],[36,81],[75,69],[17,2],[1,38],[9,31],[54,31],[99,53],[65,71],[96,49],[80,51],[65,75],[15,66]]
//          int n = 100;
//          int [][] red_edges = new int[][] {{1,70},{74,85},{13,37},{10,83},{95,71},{6,45},{4,83},{89,50},{20,15},{25,96},{97,10},{75,75},{57,53},{0,13},{30,63},{67,42},{15,32},{87,77},{36,15},{67,80},{14,74},{53,45},{97,19},{58,26},{1,60},{66,84},{29,46},{31,83},{6,83},{7,23},{87,30},{7,72},{69,22},{19,79},{6,53},{33,38},{4,50},{28,30},{68,92},{55,69},{20,83},{45,94},{93,64},{12,30},{73,3},{60,48},{80,49},{14,56},{97,61},{78,39},{6,16},{70,73},{34,15},{62,6},{48,12},{26,5},{36,86},{42,39},{84,77},{2,34},{82,0},{26,29},{88,78},{16,63},{29,50},{19,17},{28,25},{69,4},{0,5},{50,6},{81,19},{69,48},{53,55},{25,51},{87,25},{8,16},{47,44},{35,33},{14,61},{83,16},{73,45},{1,1},{11,78},{26,74},{56,87},{29,60},{21,52},{12,35},{17,50},{12,29},{81,73},{59,91},{55,8},{86,9},{34,23},{31,21},{79,86},{57,49},{76,0},{56,20},{75,50},{76,85},{52,69},{41,58},{87,75},{91,3},{0,70},{17,72},{6,25},{87,98},{88,82},{56,1},{31,52},{32,54},{26,27},{9,43},{20,21},{45,62},{5,18},{47,1},{76,3},{16,56},{48,9},{1,17},{1,40},{44,54},{52,64},{43,7},{62,17},{69,52},{81,10},{78,50},{74,83},{68,50},{23,11},{23,81},{79,8},{64,29},{60,34},{75,35},{4,91},{2,48},{99,53},{91,34},{23,86},{67,69},{80,28},{33,54},{73,15},{9,89},{69,3},{45,76},{62,33},{60,93},{32,50},{89,13},{65,54},{37,19},{1,36},{22,51},{38,37},{3,12},{97,32},{76,42},{79,92},{15,15},{87,84},{36,48},{32,9},{43,6},{85,33},{43,16},{30,22},{90,95},{30,24},{17,71},{26,44},{46,31},{92,80},{51,23},{90,64},{62,41},{74,72},{85,42},{67,14},{97,30},{25,57},{77,39},{29,97},{44,21},{20,99},{51,43},{61,25},{73,0},{80,21},{23,44},{2,55},{49,72},{38,17},{47,41},{38,82},{15,38},{85,10},{58,8},{15,28},{8,58},{63,21},{41,20},{67,58},{85,1},{56,25},{61,98},{72,91},{5,40},{99,8},{17,63},{78,88},{35,87},{75,46},{10,9},{99,41},{24,45},{94,44},{38,93},{25,80},{78,25},{60,40},{66,46},{50,14},{57,45},{76,81},{77,6},{24,83},{74,42},{60,19},{26,78},{49,19},{82,22},{98,26},{86,37},{64,66},{98,17},{69,47},{71,34},{99,16},{45,1},{18,19},{2,66},{74,88},{67,64},{39,72},{69,45},{14,2}};
//          int [][] blue_edges = new int[][] {{9,60},{62,0},{56,87},{56,84},{78,44},{95,74},{53,33},{80,40},{81,45},{37,90},{25,26},{49,5},{47,87},{20,43},{84,26},{59,22},{5,91},{98,55},{40,29},{64,16},{68,61},{60,44},{38,12},{69,99},{7,62},{73,51},{12,8},{44,44},{16,87},{36,59},{33,5},{5,38},{81,34},{31,92},{7,32},{60,37},{87,54},{63,32},{28,32},{82,94},{36,16},{16,83},{35,13},{48,56},{60,67},{9,29},{39,2},{0,55},{71,21},{18,94},{32,42},{2,77},{99,56},{72,21},{64,68},{64,45},{89,56},{61,77},{96,38},{87,56},{94,91},{78,62},{1,43},{85,69},{61,29},{76,46},{21,36},{30,57},{97,20},{78,85},{67,69},{38,36},{95,45},{60,7},{75,92},{63,88},{9,53},{46,10},{57,4},{0,23},{51,89},{62,48},{80,75},{13,51},{29,32},{77,23},{1,13},{29,91},{10,32},{14,43},{13,36},{47,97},{63,41},{87,31},{86,47},{3,57},{18,32},{61,59},{8,47},{66,16},{60,23},{30,35},{15,8},{27,98},{11,95},{2,6},{99,19},{10,31},{20,72},{78,46},{55,20},{61,6},{19,18},{91,90},{5,27},{72,77},{90,24},{5,12},{3,6},{67,18},{70,84},{5,4},{40,63},{24,32},{26,57},{43,69},{33,32},{63,54},{17,57},{8,58},{3,88},{27,34},{54,0},{65,50},{7,13},{51,94},{48,85},{85,1},{12,2},{56,31},{69,44},{48,76},{18,93},{29,51},{4,45},{11,9},{25,27},{81,18},{94,18},{90,19},{82,14},{51,24},{9,57},{97,26},{95,50},{91,4},{30,38},{62,28},{61,9},{23,43},{64,54},{2,4},{12,61},{32,36},{72,65},{46,27},{64,1},{95,22},{10,90},{23,60},{25,99},{89,35},{59,63},{49,12},{31,72},{96,60},{77,98},{8,89},{98,40},{87,44},{40,69},{17,51},{56,2},{34,85},{62,31},{55,35},{17,23},{82,18},{55,27},{5,76},{76,64},{29,30},{33,93},{0,22},{3,30},{36,81},{75,69},{17,2},{1,38},{9,31},{54,31},{99,53},{65,71},{96,49},{80,51},{65,75},{15,66}};

//        100
//        [[23,30],[63,11],[92,53],[53,51],[74,47],[19,13],[25,67],[22,62],[15,57],[61,7],[84,11],[54,1],[1,67],[28,12],[93,3],[57,78],[43,17],[21,12],[48,30],[81,19],[76,11],[64,61],[37,3],[65,54],[81,73],[39,4],[29,64],[72,59],[37,49],[22,19],[52,66],[34,85],[62,29],[19,68],[43,74],[93,50],[91,22],[2,69],[6,9],[27,44],[19,41],[21,99],[18,96],[42,26],[88,38],[54,2],[31,60],[92,1],[12,49],[43,58],[31,37],[89,83],[15,42],[98,15],[96,26],[63,20],[54,47],[12,94],[10,7],[16,6],[14,17],[97,6],[6,28],[84,33],[17,83],[76,0],[29,14],[53,24],[61,41],[66,10],[2,37],[72,81],[85,47],[29,36],[94,24],[17,42],[53,80],[1,38],[56,49],[13,96],[64,9],[37,31],[45,31],[35,12],[91,80],[0,39],[38,41],[34,18],[36,8],[12,86],[9,83],[17,18],[31,16],[64,81],[17,17],[65,75],[32,93],[40,6],[8,28],[57,84],[24,87],[33,75],[86,38],[34,33],[79,40],[60,35],[99,79],[72,9]]
//        [[5,78],[33,51],[92,13],[32,15],[73,8],[40,41],[71,16],[86,47],[33,94],[57,44],[68,9],[89,52],[13,97],[40,15],[61,79],[51,2],[77,86],[66,24],[54,12],[42,92],[29,44],[11,55],[98,35],[63,59],[79,95],[33,90],[63,85],[78,10],[14,7],[8,36],[54,41],[95,74],[67,72],[83,87],[77,81],[66,43],[59,58],[34,19],[46,34],[24,3],[50,0],[47,83],[37,87],[92,92],[0,94],[25,2],[72,97],[79,24],[16,15],[31,33],[4,46],[65,63],[76,18],[64,89],[11,85],[68,62],[26,91],[47,75],[17,43],[70,22],[53,98],[55,39],[53,48],[45,51],[51,24],[79,50],[82,73],[27,26],[76,11],[1,50],[59,63],[42,78],[60,35],[47,51],[76,72],[96,35],[97,12],[87,6],[33,40],[15,35],[46,37],[57,59],[89,48],[3,27],[4,61],[34,40],[60,61],[32,43],[40,12],[60,23],[90,64],[81,75],[36,61],[47,73],[89,29],[34,78],[45,74],[75,13],[86,76],[13,93],[94,56],[93,91],[53,19],[95,6],[20,12],[2,45],[49,33],[20,78],[50,56],[79,14],[85,32],[65,45],[0,48],[81,82],[61,87],[50,15],[43,70],[86,38],[62,2],[89,97],[17,14],[52,2],[46,87],[0,16],[16,54],[86,5],[2,69],[80,77],[37,3],[89,59],[45,32],[47,17],[19,29],[69,81],[12,28],[52,73],[88,1],[10,92],[1,80],[21,57],[11,74],[19,25],[11,15],[25,29],[44,88],[86,13],[60,22],[97,55],[3,95],[73,51],[85,56],[58,97],[78,16],[42,84],[26,98],[46,10],[28,18],[14,12],[76,26],[79,12],[58,40],[72,89],[5,81],[41,65],[46,28],[18,25],[65,5],[0,85],[10,65],[28,56],[39,49],[22,17],[30,26],[53,6],[12,12],[16,16],[70,52],[96,55],[37,10],[72,15],[80,84],[50,60],[58,1],[76,74],[96,45],[42,77],[15,22],[99,19],[86,48],[98,11],[50,4],[71,44],[49,10],[4,31],[67,52],[52,94],[35,75],[83,63],[7,7],[99,38],[71,67],[18,84],[80,46],[80,15],[18,86],[10,75],[81,93],[67,31],[72,69],[18,24],[57,42],[93,8],[93,58]]
        // exp:
        // [0,6,10,3,11,9,2,10,15,8,9,6,7,8,5,7,1,3,4,7,6,-1,9,9,2,5,3,11,8,10,2,7,-1,6,-1,9,12,8,6,1,7,8,4,5,9,11,13,2,1,2,7,3,7,6,9,7,9,8,6,8,8,9,9,5,12,9,8,6,8,11,-1,-1,7,3,6,3,9,5,5,-1,7,8,9,3,5,1,5,5,13,13,7,11,5,9,1,11,10,7,7,-1]
        // out:
        // [0,6,10,3,11,9,2,10,-1,8,9,6,7,8,5,7,1,3,4,7,6,-1,9,9,2,5,3,11,8,10,2,7,-1,6,-1,9,12,8,6,1,7,8,4,5,9,11,13,2,1,2,7,3,7,6,9,7,9,8,6,8,8,9,9,5,12,9,8,6,8,11,-1,-1,7,3,6,3,9,5,5,-1,7,8,9,3,5,1,5,5,13,13,7,11,5,9,1,11,10,7,7,-1]
        // to 8, exp 15, mine = -1

        int n = 100;
        int[][] red_edges = new int[][] { { 23, 30 }, { 63, 11 }, { 92, 53 }, { 53, 51 }, { 74, 47 }, { 19, 13 },
                { 25, 67 }, { 22, 62 }, { 15, 57 }, { 61, 7 }, { 84, 11 }, { 54, 1 }, { 1, 67 }, { 28, 12 }, { 93, 3 },
                { 57, 78 }, { 43, 17 }, { 21, 12 }, { 48, 30 }, { 81, 19 }, { 76, 11 }, { 64, 61 }, { 37, 3 },
                { 65, 54 }, { 81, 73 }, { 39, 4 }, { 29, 64 }, { 72, 59 }, { 37, 49 }, { 22, 19 }, { 52, 66 },
                { 34, 85 }, { 62, 29 }, { 19, 68 }, { 43, 74 }, { 93, 50 }, { 91, 22 }, { 2, 69 }, { 6, 9 }, { 27, 44 },
                { 19, 41 }, { 21, 99 }, { 18, 96 }, { 42, 26 }, { 88, 38 }, { 54, 2 }, { 31, 60 }, { 92, 1 },
                { 12, 49 }, { 43, 58 }, { 31, 37 }, { 89, 83 }, { 15, 42 }, { 98, 15 }, { 96, 26 }, { 63, 20 },
                { 54, 47 }, { 12, 94 }, { 10, 7 }, { 16, 6 }, { 14, 17 }, { 97, 6 }, { 6, 28 }, { 84, 33 }, { 17, 83 },
                { 76, 0 }, { 29, 14 }, { 53, 24 }, { 61, 41 }, { 66, 10 }, { 2, 37 }, { 72, 81 }, { 85, 47 },
                { 29, 36 }, { 94, 24 }, { 17, 42 }, { 53, 80 }, { 1, 38 }, { 56, 49 }, { 13, 96 }, { 64, 9 },
                { 37, 31 }, { 45, 31 }, { 35, 12 }, { 91, 80 }, { 0, 39 }, { 38, 41 }, { 34, 18 }, { 36, 8 },
                { 12, 86 }, { 9, 83 }, { 17, 18 }, { 31, 16 }, { 64, 81 }, { 17, 17 }, { 65, 75 }, { 32, 93 },
                { 40, 6 }, { 8, 28 }, { 57, 84 }, { 24, 87 }, { 33, 75 }, { 86, 38 }, { 34, 33 }, { 79, 40 },
                { 60, 35 }, { 99, 79 }, { 72, 9 } };
        int[][] blue_edges = new int[][] { { 5, 78 }, { 33, 51 }, { 92, 13 }, { 32, 15 }, { 73, 8 }, { 40, 41 },
                { 71, 16 }, { 86, 47 }, { 33, 94 }, { 57, 44 }, { 68, 9 }, { 89, 52 }, { 13, 97 }, { 40, 15 },
                { 61, 79 }, { 51, 2 }, { 77, 86 }, { 66, 24 }, { 54, 12 }, { 42, 92 }, { 29, 44 }, { 11, 55 },
                { 98, 35 }, { 63, 59 }, { 79, 95 }, { 33, 90 }, { 63, 85 }, { 78, 10 }, { 14, 7 }, { 8, 36 },
                { 54, 41 }, { 95, 74 }, { 67, 72 }, { 83, 87 }, { 77, 81 }, { 66, 43 }, { 59, 58 }, { 34, 19 },
                { 46, 34 }, { 24, 3 }, { 50, 0 }, { 47, 83 }, { 37, 87 }, { 92, 92 }, { 0, 94 }, { 25, 2 }, { 72, 97 },
                { 79, 24 }, { 16, 15 }, { 31, 33 }, { 4, 46 }, { 65, 63 }, { 76, 18 }, { 64, 89 }, { 11, 85 },
                { 68, 62 }, { 26, 91 }, { 47, 75 }, { 17, 43 }, { 70, 22 }, { 53, 98 }, { 55, 39 }, { 53, 48 },
                { 45, 51 }, { 51, 24 }, { 79, 50 }, { 82, 73 }, { 27, 26 }, { 76, 11 }, { 1, 50 }, { 59, 63 },
                { 42, 78 }, { 60, 35 }, { 47, 51 }, { 76, 72 }, { 96, 35 }, { 97, 12 }, { 87, 6 }, { 33, 40 },
                { 15, 35 }, { 46, 37 }, { 57, 59 }, { 89, 48 }, { 3, 27 }, { 4, 61 }, { 34, 40 }, { 60, 61 },
                { 32, 43 }, { 40, 12 }, { 60, 23 }, { 90, 64 }, { 81, 75 }, { 36, 61 }, { 47, 73 }, { 89, 29 },
                { 34, 78 }, { 45, 74 }, { 75, 13 }, { 86, 76 }, { 13, 93 }, { 94, 56 }, { 93, 91 }, { 53, 19 },
                { 95, 6 }, { 20, 12 }, { 2, 45 }, { 49, 33 }, { 20, 78 }, { 50, 56 }, { 79, 14 }, { 85, 32 },
                { 65, 45 }, { 0, 48 }, { 81, 82 }, { 61, 87 }, { 50, 15 }, { 43, 70 }, { 86, 38 }, { 62, 2 },
                { 89, 97 }, { 17, 14 }, { 52, 2 }, { 46, 87 }, { 0, 16 }, { 16, 54 }, { 86, 5 }, { 2, 69 }, { 80, 77 },
                { 37, 3 }, { 89, 59 }, { 45, 32 }, { 47, 17 }, { 19, 29 }, { 69, 81 }, { 12, 28 }, { 52, 73 },
                { 88, 1 }, { 10, 92 }, { 1, 80 }, { 21, 57 }, { 11, 74 }, { 19, 25 }, { 11, 15 }, { 25, 29 },
                { 44, 88 }, { 86, 13 }, { 60, 22 }, { 97, 55 }, { 3, 95 }, { 73, 51 }, { 85, 56 }, { 58, 97 },
                { 78, 16 }, { 42, 84 }, { 26, 98 }, { 46, 10 }, { 28, 18 }, { 14, 12 }, { 76, 26 }, { 79, 12 },
                { 58, 40 }, { 72, 89 }, { 5, 81 }, { 41, 65 }, { 46, 28 }, { 18, 25 }, { 65, 5 }, { 0, 85 }, { 10, 65 },
                { 28, 56 }, { 39, 49 }, { 22, 17 }, { 30, 26 }, { 53, 6 }, { 12, 12 }, { 16, 16 }, { 70, 52 },
                { 96, 55 }, { 37, 10 }, { 72, 15 }, { 80, 84 }, { 50, 60 }, { 58, 1 }, { 76, 74 }, { 96, 45 },
                { 42, 77 }, { 15, 22 }, { 99, 19 }, { 86, 48 }, { 98, 11 }, { 50, 4 }, { 71, 44 }, { 49, 10 },
                { 4, 31 }, { 67, 52 }, { 52, 94 }, { 35, 75 }, { 83, 63 }, { 7, 7 }, { 99, 38 }, { 71, 67 }, { 18, 84 },
                { 80, 46 }, { 80, 15 }, { 18, 86 }, { 10, 75 }, { 81, 93 }, { 67, 31 }, { 72, 69 }, { 18, 24 },
                { 57, 42 }, { 93, 8 }, { 93, 58 } };

//        8
//        [[7,5],[0,0],[0,4],[5,1],[3,0],[1,5],[2,1],[2,3]]
//        [[2,3],[6,7],[6,2],[0,7],[7,7],[1,4],[7,4],[6,5],[2,5],[6,1],[1,0],[3,3],[5,4],[5,6],[7,5],[2,6],[5,1],[5,5],[1,5],[6,4]]
        // exp: [0,3,-1,-1,1,2,3,1]
        // out: [0,4,-1,-1,1,2,4,1]
        // blue 0,7 - 7,5 - 5,1

//        int n = 8;
//        int[][] red_edges = new int[][] {{7,5},{0,0},{0,4},{5,1},{3,0},{1,5},{2,1},{2,3}};
//        int[][] blue_edges = new int[][] {{2,3},{6,7},{6,2},{0,7},{7,7},{1,4},{7,4},{6,5},{2,5},{6,1},{1,0},{3,3},{5,4},{5,6},{7,5},{2,6},{5,1},{5,5},{1,5},{6,4}};

//        9
//        [[1,8],[5,7],[1,2],[2,2],[7,4],[7,2],[3,8],[7,0],[1,5],[2,7],[2,3],[6,3],[3,0],[4,8],[7,5],[1,6],[3,7]]
//        [[2,1],[1,4],[0,3],[0,5],[1,5],[8,2],[5,8],[2,6],[5,3],[6,7],[4,0],[2,2]]
        // exp: [0,5,3,1,8,1,5,2,2]

//        int n = 9;
//        int[][] red_edges = new int[][] { { 1, 8 }, { 5, 7 }, { 1, 2 }, { 2, 2 }, { 7, 4 }, { 7, 2 }, { 3, 8 },
//                { 7, 0 }, { 1, 5 }, { 2, 7 }, { 2, 3 }, { 6, 3 }, { 3, 0 }, { 4, 8 }, { 7, 5 }, { 1, 6 }, { 3, 7 } };
//        int[][] blue_edges = new int[][] { { 2, 1 }, { 1, 4 }, { 0, 3 }, { 0, 5 }, { 1, 5 }, { 8, 2 }, { 5, 8 },
//                { 2, 6 }, { 5, 3 }, { 6, 7 }, { 4, 0 }, { 2, 2 } };

//        5
//        [[2,2],[0,4],[4,2],[4,3],[2,4],[0,0],[0,1],[2,3],[1,3]]
//        [[0,4],[1,0],[1,4],[0,0],[4,0]]
        // e: [0,1,2,2,1]

//        int n = 5;
//        int[][] red_edges = new int[][] {
//            {2, 2},
//            {0, 4},
//            {4, 2},
//            {4, 3},
//            {2, 4},
//            {0, 0},
//            {0, 1},
//            {2, 3},
//            {1, 3}
//        };
//        int[][] blue_edges = new int[][] {
//            {0, 4},
//            {1, 0},
//            {1, 4},
//            {0, 0},
//            {4, 0}
//        };

//        int n = 2;
//        int[][] red_edges = new int[][] { };
//        int[][] blue_edges = new int[][] { };

//        int n = 9;
//        int [][] red_edges = new int[][]
//                  {{2,1},{5,1},{6,4},{1,0},{7,4},{0,8},{7,8},{7,6},{6,8},{3,1},{2,7},{3,6},{8,3},{0,0},{5,0},{8,1},{4,8},{4,7},{8,0},{8,5}};
//        int [][] blue_edges = new int[][]
//                  {{1,5},{2,7},{2,0},{5,2},{8,5},{1,7},{6,1},{1,4},{4,1},{3,6},{8,8},{7,6},{1,1},{6,8},{2,8},{7,7},{7,3},{1,2},{2,6}};

//        [[2,1],[5,1],[6,4],[1,0],[7,4],[0,8],[7,8],[7,6],[6,8],[3,1],[2,7],[3,6],[8,3],[0,0],[5,0],[8,1],[4,8],[4,7],[8,0],[8,5]]
//        [[1,5],[2,7],[2,0],[5,2],[8,5],[1,7],[6,1],[1,4],[4,1],[3,6],[8,8],[7,6],[1,1],[6,8],[2,8],[7,7],[7,3],[1,2],[2,6]]

//        5
//        [[3,2],[4,1],[1,4],[2,4]]
//        [[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]

//        6
//        [[2,3],[0,5],[3,1],[5,0],[3,0],[0,0]]
//        [[1,2],[3,2],[1,0],[2,2],[5,2]]
        // exp: [0,-1,2,3,-1,1]

//        7
//        [[0,2],[1,3],[1,5],[4,0],[4,2]]
//        [[1,2],[4,3],[3,1],[6,1],[1,5],[6,0],[5,1],[1,4],[6,3],[1,3],[0,1],[2,1]]
        // exp: [0,1,1,2,-1,2,-1]

//        int n = 7;
//        int [][] red_edges = new int[][] {
//            {0, 2},
//            {1, 3},
//            {1, 5},
//            {4, 0},
//            {4, 2}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 2},
//            {4, 3},
//            {3, 1},
//            {6, 1},
//            {1, 5},
//            {6, 0},
//            {5, 1},
//            {1, 4},
//            {6, 3},
//            {1, 3},
//            {0, 1},
//            {2, 1}
//        };

//      5
//      [[0,1],[1,2],[2,3],[3,4]]
//      [[1,2],[2,3],[3,1]]
        // expected: [0,1,2,3,7]

//        int n = 5;
//        int [][] red_edges = new int[][] {
//            {0, 1},
//            {1, 2},
//            {2, 3},
//            {3, 4}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 2},
//            {2, 3},
//            {3, 1}
//        };

//                  5
//                  [[3,2],[4,1],[1,4],[2,4]]
//                  [[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]
        // exp: [0,2,-1,-1,1]

//        6
//        [[1,5],[2,2],[5,5],[3,0],[4,5],[2,4],[4,1],[1,0],[1,2],[5,2],[2,3],[0,1]]
//        [[4,4],[2,5],[1,1],[5,4],[3,3]]
        // exp: [0,1,3,-1,4,3]

//        int n = 6;
//        int [][] red_edges = new int[][] {
//            {1, 5},
//            {2, 2},
//            {5, 5},
//            {3, 0},
//            {4, 5},
//            {2, 4},
//            {4, 1},
//            {1, 0},
//            {1, 2},
//            {5, 2},
//            {2, 3},
//            {0, 1}
//        };
//        int [][] blue_edges = new int[][] {
//            {4, 4},
//            {2, 5},
//            {1, 1},
//            {5, 4},
//            {3, 3}
//        };

//            int n = 5;
//            int [][] red_edges = new int[][] {
//                {3, 2},
//                {4, 1},
//                {1, 4},
//                {2, 4}
//            };
//            int [][] blue_edges = new int[][] {
//                {2, 3},
//                {0, 4},
//                {4, 3},
//                {4, 4},
//                {4, 0},
//                {1, 0}
//            };

//        int [][] red_edges = new int[][] {
//                {0, 1},
//                {1, 2}
//        };
//        int [][] blue_edges = new int[][] {};

//        int [][] red_edges = new int[][] {
//            {0, 1}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 2}
//        };

//        int n = 3;
//        int [][] red_edges = new int[][] {
//            {0, 1},
//            {1, 2}
//        };
//        int [][] blue_edges = new int[][] {
//        };
//        int [][] red_edges = new int[][] {
//            {0, 1},
//            {0, 2}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 0}
//        };

        s.printArr(s.shortestAlternatingPaths(n, red_edges, blue_edges));
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][][] graph = new int[100][100][2];
        int[] results = new int[n];

        if (red_edges.length == 0 && blue_edges.length == 0) {
            for (int i = 0; i < n; ++i) {
                if (i > 0) {
                    results[i] = -1;
                }
            }
        }

        int maxEdgeLength = Math.max(red_edges.length, blue_edges.length);

        for (int count = 0; count < red_edges.length + blue_edges.length; ++count) {
            for (int i = 0; i < maxEdgeLength; ++i) {
                int[] red_edge = null;
                int[] blue_edge = null;
                if (i < red_edges.length) {
                    red_edge = red_edges[i];
                }

                if (i < blue_edges.length) {
                    blue_edge = blue_edges[i];
                }

                if (red_edge != null) {
                    if (graph[red_edge[0]][red_edge[1]][0] == 0 && red_edge[0] == 0) {
                        graph[red_edge[0]][red_edge[1]][0] = 1;
                        results[red_edge[1]] = 1;
                    }
                }

                if (blue_edge != null) {
                    if (graph[blue_edge[0]][blue_edge[1]][1] == 0 && blue_edge[0] == 0) {
                        graph[blue_edge[0]][blue_edge[1]][1] = 1;
                        results[blue_edge[1]] = 1;
                    }
                }

                for (int g = 0; g < graph.length; ++g) {
                    if (red_edge != null) {
                        if (graph[g][red_edge[0]][1] > 0) { // link from a blue edge
                            if (graph[red_edge[0]][red_edge[1]][0] == 0) {
                                graph[red_edge[0]][red_edge[1]][0] = graph[g][red_edge[0]][1] + 1;
                                if (results[red_edge[1]] == 0
                                        || results[red_edge[1]] > graph[red_edge[0]][red_edge[1]][0]) {
                                    results[red_edge[1]] = graph[red_edge[0]][red_edge[1]][0];
                                }
                            }
                            else {
                                if (graph[red_edge[0]][red_edge[1]][0] > graph[g][red_edge[0]][1] + 1) {
                                    graph[red_edge[0]][red_edge[1]][0] = graph[g][red_edge[0]][1] + 1;
                                    if (results[red_edge[1]] == 0
                                            || results[red_edge[1]] > graph[red_edge[0]][red_edge[1]][0]) {
                                        results[red_edge[1]] = graph[red_edge[0]][red_edge[1]][0];
                                    }
                                }
                            }
                        }
                    }

                    if (blue_edge != null) {
                        if (graph[g][blue_edge[0]][0] > 0) { // link from red edge
                            if (graph[blue_edge[0]][blue_edge[1]][1] == 0) {
                                graph[blue_edge[0]][blue_edge[1]][1] = graph[g][blue_edge[0]][0] + 1;
                                if (results[blue_edge[1]] == 0
                                        || results[blue_edge[1]] > graph[blue_edge[0]][blue_edge[1]][1]) {
                                    results[blue_edge[1]] = graph[blue_edge[0]][blue_edge[1]][1];
                                }
                            }
                            else {
                                if (graph[blue_edge[0]][blue_edge[1]][1] > graph[g][blue_edge[0]][0] + 1) {
                                    graph[blue_edge[0]][blue_edge[1]][1] = graph[g][blue_edge[0]][0] + 1;
                                    if (results[blue_edge[1]] == 0
                                            || results[blue_edge[1]] > graph[blue_edge[0]][blue_edge[1]][1]) {
                                        results[blue_edge[1]] = graph[blue_edge[0]][blue_edge[1]][1];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int to = 0; to < n; ++to) {
            if (to == 0) {
                results[to] = 0;
                continue;
            }

            if (results[to] == 0) {
                results[to] = -1;
            }
        }

        return results;
    }
}
