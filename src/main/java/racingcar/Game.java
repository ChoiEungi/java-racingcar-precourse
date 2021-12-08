package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MOVE_FORWARD_CONTION_NUMBER = 4;
    private static final int MAX_PICK_NUMBER = 9;
    private static final int MIN_PICK_NUMBER = 0;

    public void startOnce(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = getRandomNumber();
            if (checkMoveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }

    public List<String> winner(List<Car> carList) {
        int maxValue = findMaxInCarList(carList);
        List<String> winnersList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxValue) {
                winnersList.add(car.getName());
            }
        }
        return winnersList;
    }


    private int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
        return randomNumber;
    }


    private boolean checkMoveForward(int randomNumber) {
        return randomNumber >= MOVE_FORWARD_CONTION_NUMBER;
    }

    private int findMaxInCarList(List<Car> carList) {
        int maxValue = -1;
        for (Car car : carList) {
            if (maxValue < car.getPosition()) {
                maxValue = car.getPosition();
            }
        }
        return maxValue;
    }
}
