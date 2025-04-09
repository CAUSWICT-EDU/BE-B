package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class sub {
    public static String[] name;
    public static int countt;
    public static String[] score;

    public boolean names(){
        String input = Console.readLine();
        name = input.split(",");
        for(int i = 0; i < name.length; i++){
            if(name[i].length() > 5)
                return false;
        }
        return true;
    }

    public int count(String y){
        countt =Integer.parseInt(y);
        return countt;
    }

    public void scoresystem(){
        for(int i = 0; i <= name.length; i++){
            int n = Randoms.pickNumberInRange(0,9);
            score[i] ="";
            if(n>4) {
                score[i] += "-";
                System.out.println(name[i]+":+"+score[i]);
            }
        }
    }//이걸 다시 main에다가 반복문으로 게임 개수만큼 돌릴거임
    public void victory(){
        int max = 0;
        System.out.print("최종 우승자: ");
        for(int i = 0; i <= score.length; i++){
            if(max<score[i].length())
                max = score[i].length();
        }
        System.out.print(max);

        for(int i = 0; i <= name.length; i++){
            if(max == score[i].length())
                System.out.print(score[i].length());
        }
    }

}

