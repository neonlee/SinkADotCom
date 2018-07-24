package sinkadotcom;

import java.util.*;

public class DotComBust {

    private final GameHelper helper = new GameHelper();
    private final ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");

        DotCom two = new DotCom();
        two.setName("eToys.com");

        DotCom tree = new DotCom();
        tree.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(tree);

        System.out.println("Seu objetivo é eliminar tres dot.com");
        System.out.println("Pets.com, eToys.com e Go2.com");
        System.out.println("Tente eliminar todas com o menor numero de tentativas");

        for (DotCom dotCom : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotCom.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Insira um palpite: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "errado";

        for (DotCom dotCom : dotComList) {
            result = dotCom.checkYourSelf(userGuess);

            if (result.equals("eliminar")) {
                dotComList.remove(dotCom);
                System.out.println("Ora voce eliminou " + dotCom.getName());
                break;
            }

            if (result.equals("correto")) {
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Todas as dotCom foram eliminadas, seu conjuto esta vazio");

        if (numOfGuesses <= 18) {
            System.out.println("Voce usou: " + numOfGuesses + "tentativas");
            System.out.println("Voce saiu antes de eliminar suas opcoes");
        } else {
            System.out.println("Demorou demais: " + numOfGuesses + "Palpites");
            System.out.println("Nao havera pesca com essas opcoes");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
