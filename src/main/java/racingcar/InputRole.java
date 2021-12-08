package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputRole {
    private static final String NAME_INPUT_INSTRUCTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) ";
    private static final String TRIAL_NUMBER_INPUT_INSTRUCTION = "시도할 회수는 몇회인가요? ";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NAME_LENGTH_ERROR = "입력한 이름들의 길이가 유효하지 않습니다. 1자에서 5자 이내의 이름을 입력해주세요. ";
    private static final String NAME_WHITESPACE_ERROR = "입력에 공백이 들어가면 안됩니다. ";
    private static final String NUMBER_VALID_ERROR = "시도 횟수는 숫자여야 한다. ";

    public String[] getNameList() {
        while (true) {
            try {
                return inputNames();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getTrialNmber() {
        while (true) {
            try {
                return inputTrialNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private String[] inputNames() {
        System.out.println(NAME_INPUT_INSTRUCTION);
        String inputNames = Console.readLine();
        String[] nameList = inputNames.split(",");
        for (String name : nameList) {
            checkNameWhiteSpaceValid(name);
            checkNameLengthValid(name);
        }
        return nameList;
    }


    private void checkNameLengthValid(String name) {
        if (name.length() <= 0 || name.length() > 5) {
            throw new IllegalArgumentException(ERROR_HEADER + NAME_LENGTH_ERROR);
        }
    }

    private void checkNameWhiteSpaceValid(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(ERROR_HEADER + NAME_WHITESPACE_ERROR);
        }
    }

    private Integer inputTrialNumber() {
        System.out.println(TRIAL_NUMBER_INPUT_INSTRUCTION);
        String inputNumber = Console.readLine();
        checkTrialNumberValid(inputNumber);
        return Integer.valueOf(inputNumber);
    }

    private void checkTrialNumberValid(String trialNumber) {
        if (!trialNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_HEADER + NUMBER_VALID_ERROR);
        }
    }
}
