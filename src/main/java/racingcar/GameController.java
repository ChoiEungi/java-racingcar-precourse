package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final InputRole inputRole = new InputRole();
    private final List<Car> carList = new ArrayList<>();

    public void gameStart() {
        Game game = new Game();
        OutputRole outputRole = new OutputRole();
        changeInputToCar(inputRole.getNameList());
        Integer trialNumber = inputRole.getTrialNmber();

        outputRole.pirntResultInstruction();
        for (int i = 0; i < trialNumber; i++) {
            game.startOnce(carList);
            outputRole.printOneGame(carList);
        }
        outputRole.printWinner(game.winner(carList));
    }

    private void changeInputToCar(String[] nameList) {
        for (String name : nameList) {
            this.carList.add(new Car(name));
        }
    }


}
