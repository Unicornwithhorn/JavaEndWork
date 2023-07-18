import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static void addResults(ArrayList<Laptop> laptops, HashMap<String, Set<String>> choosenParameters, double minScreenSize, int currentMinPrice, int currentMinHardDiskSize, int currentMinRamMemoryInstalledSize, String currentBluetoothCondition){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Laptop> choosenLaptops = new ArrayList<>();
        System.out.println("Удовлетворяющие вашему запросы ноутбуки:\n");
        String choice = null;
        int laptopNumber = 1;
        for (Laptop laptop:laptops) {
            if ((choosenParameters.get("brand").contains(laptop.describedParameters[0]) || choosenParameters.get("brand").size() == 0)
                    && (choosenParameters.get("modelName").contains(laptop.describedParameters[1]) || choosenParameters.get("modelName").size() == 0)
                    &&(choosenParameters.get("color").contains(laptop.describedParameters[2]) || choosenParameters.get("color").size() == 0)
                    && (choosenParameters.get("CPUModel").contains(laptop.describedParameters[3]) || choosenParameters.get("CPUModel").size() == 0)
                    && (choosenParameters.get("operatingSystem").contains(laptop.describedParameters[4]) || choosenParameters.get("operatingSystem").size() == 0)
                    && minScreenSize<= laptop.screenSize
                    && currentMinPrice<= laptop.price
                    && currentMinHardDiskSize<= laptop.hardDiskSize
                    && currentMinRamMemoryInstalledSize<= laptop.ramMemoryInstalledSize
                    && (currentBluetoothCondition.equals(laptop.bluetooth) || currentBluetoothCondition.equals("Не имеет значения"))){
                System.out.print(laptopNumber++ + ")");
                System.out.println(laptop);
                choosenLaptops.add(laptop);
            }
        }
        if (laptopNumber == 1){
            System.out.println("не найдены. Измените критерии вашего запроса");
            System.out.println(" ");
        }
        else {
            System.out.print(laptopNumber + ")Выход в основное меню");
            System.out.println(" ");
            System.out.println("Выберите номер товара из списка для получения детальной информации или нажмите "
                    + laptopNumber + " для выхода в основное меню");
            boolean flag = true;
            while (flag){
                try {
                    choice = scanner.nextLine();
                    if (Integer.parseInt(choice) == laptopNumber){
                        return;
                    } else if (Integer.parseInt(choice) < laptopNumber && Integer.parseInt(choice) > 0) {
                        System.out.println(choosenLaptops.get(Integer.parseInt(choice)-1).fullInfo());
                        flag = false;
                    }
                    else {
                        System.out.println("Данные введены некорректно. Попробуйте ещё раз");
                    }
                }catch (Exception e){
                    System.out.println("Данные введены некорректно. Попробуйте ещё раз");
                }
            }
            System.out.println("Для покупки этого ноутбука введите 1. Для выхода в главное меню введите 2");
            flag = true;
            while (flag) {
                try {
                    String choice1 = scanner.nextLine();
                    if (Integer.parseInt(choice1) == 1) {
                        System.out.println("Поздравлем! Общая сумма вашей покупки составила:\n" +
                                choosenLaptops.get(Integer.parseInt(choice) - 1).price + "$ + 1327$ (стоимость доставки)" +
                                "=" + (choosenLaptops.get(Integer.parseInt(choice) - 1).price + 1327) + "$. " +
                                "Деньги были автоматически списаны с вашей карты.");
                        return;
                    } else if (Integer.parseInt(choice1) == 2) {
                        flag = false;
                    } else {
                        System.out.println("Данные введены некорректно. Попробуйте ещё раз");
                    }
                } catch (Exception e) {
                    System.out.println("Данные введены некорректно. Попробуйте ещё раз");
                }
            }
        }
    }

    public static void choice(ArrayList<Laptop> laptops, HashMap<String, Set<String>> choosenParameters, TypeParameter typeParameter) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> currentTypeMap = new HashMap<>();
        int i = 0;
        StringBuilder menu = new StringBuilder();
        menu.append("Доступные "+ typeParameter.russianNamePlural +":\n");

        for (Laptop laptop : laptops) {
            if (!currentTypeMap.containsValue(laptop.describedParameters[typeParameter.numberParameter])) {
                currentTypeMap.put(++i, laptop.describedParameters[typeParameter.numberParameter]);
                menu.append(i).append(")").append(currentTypeMap.get(i)).append("\n");
            }
        }
        menu.append(++i).append(")Выход в главное меню");
        System.out.println(menu);
        boolean flag = true;
        while (true) {

            if (flag) {
                System.out.println("Выберите интересующий вас " + typeParameter.russianNameSingle +
                        " или нажмите " + i + " для выхода в главное меню");
            } else {
                System.out.println("Добавьте в критерии поиска дополнительные " + typeParameter.russianNameSingle
                        + " или нажмите " + i + " для выхода в главное меню");
            }
            int choice;
            try {
                choice = scanner.nextInt();
                if (choice == i) {
                    return;
                }
                if(choosenParameters.get(typeParameter.type).contains(currentTypeMap.get(choice))){
                    System.out.println("Данный " + typeParameter.russianNameSingle +
                            " уже был добавлен. Желаете удалить его из параметров поиска? \n1)да \n2)нет ");
                    String answer = scanner.next();
                    do {
                        if (answer.equals("1")) {
                            choosenParameters.get(typeParameter.type).remove(currentTypeMap.get(choice));
                            System.out.println(typeParameter.russianNameSingle + " был удалён");
                            System.out.println("Выбранные вами " + typeParameter.russianNamePlural +
                                    " - " + choosenParameters.get(typeParameter.type));
                            System.out.println(menu);
                            if (choosenParameters.get(typeParameter.type).size() == 0) {
                                flag = true;
                            }
                        } else if (answer.equals("2")) {
                            System.out.println(typeParameter.russianNameSingle + " не был удалён");
                            System.out.println("Выбранные вами " + typeParameter.russianNamePlural + " - "
                                    + choosenParameters.get(typeParameter.type));
                            System.out.println(menu);
                        } else {
                            System.out.println("ответ введён некорректно. Введите 1, если хотите удалить "
                                    + typeParameter.russianNameSingle + " "+ currentTypeMap.get(choice) +
                                    ", 2, если не хотите его удалять");
                            answer = scanner.next();
                        }
                    }while (!answer.equals("1") && !answer.equals("2"));
                }
                else {
                    choosenParameters.get(typeParameter.type).add(currentTypeMap.get(choice));
                    flag = false;
                    System.out.println("Выбранные вами " + typeParameter.russianNamePlural + " - "
                            + choosenParameters.get(typeParameter.type));
                    System.out.println(menu);
                }
            } catch (Exception e) {
                System.out.println("Данные введены некорректно. Повторите ввод.");
            }
        }
    }


    public static double choiceDigital(TypeParameter typeParameter) {
        Scanner scanner = new Scanner(System.in);
        String dimention = null;
        switch (typeParameter.type){
            case "screenSize": dimention = " дюйм";
                break;
            case "price": dimention = " $";
                break;
            case "hardDiskSize":
            case "ramMemoryInstalledSize": dimention = " ГБ";
                break;
        }
        System.out.println("Введите минимальное значение для параметра " + typeParameter.russianNameSingle + " (" + dimention +"). Для выхода введите 0");
        boolean flag = true;
        while (flag) {
            try {
                double result = scanner.nextDouble();
                flag = false;
                return result;
            } catch (Exception e) {
                System.out.println("Данные введены некорректно. Повторите ввод.");
            }
        }
        return 0;
    }
    public static String bluetoothChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные варианты\n" +
                "1)bluetooth присутствует\n" +
                "2)bluetooth отсутствует\n" +
                "3)Не имеет значения\n" +
                "\n");
        String choice;
        System.out.println("Выберите интересующий вас вариант");
        while (true) {
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                return "bluetooth присутствует";
            } else if (choice.equals("2")) {
                return "bluetooth отсутствует";
            } else if (choice.equals("3")) {
                return "Не имеет значения";
            } else {
                System.out.println("Введённый ответ некорректен. Попробуйте ещё раз (1, 2 или 3");
            }
        }
    }
}
