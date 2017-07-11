package trabalho.view;

import java.util.Scanner;

/**
 * Created by nilton on 21/06/17.
 */
public class FazerNovamente {
    Scanner sc = new Scanner(System.in);

    public boolean MaisUm(){
        String refaz = "";

        while(!refaz.equalsIgnoreCase("s") & !refaz.equalsIgnoreCase("n")){
            System.out.println("Nova Alteração ( S/N )");
            refaz = sc.next();
        }

        if(refaz.equalsIgnoreCase("s")){
            return true;
        }else{
            return false;
        }
    }
}
