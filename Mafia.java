import java.util.*;
public class Mafia{
    public static void main(String[] args) {
        int NumSimulations = 10000;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number of traitors: ");//Asks user for number of traitors
        int NumTraitors = sc.nextInt();


        int traitorWins=0;
        for(int i=0;i<NumSimulations;i++)
        {
            if(simGame(NumTraitors)){//if the method returns true the traitor wins increment
                traitorWins++;
            }
        }
        double prob = (double) traitorWins/NumSimulations;
        System.out.println("Probability of traitors winning is: "+prob);
    }

    public static boolean simGame(int n){
        Random rand = new Random();
        int NumTraitors = n;//Traitors is the user input
        int players=22;
        int faithful=players-NumTraitors;//total of players - no.of traitors

        while(faithful>0 && NumTraitors>0 && (NumTraitors+faithful)>2){// While the number of players more than 2 and faithful and traitors are more than 0
            players--;
            faithful--;//updates the amount of players
            if(rand.nextInt(faithful+NumTraitors)<NumTraitors){
                NumTraitors--;//if true then the number of traitors decreases
            }
            else{
                faithful--;// else the number of faithful decreases
            }
        }
        if(NumTraitors>0){
            return true;//if theres at least one traitor left it returns true
        }
        else{
            return false;// else it returns false
        }

    }
}