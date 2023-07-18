import java.util.*;


public class EndHomework {
    public static void main(String[] args) {
//        в describerParameters - brand, modelName, color, CPUModel, operatingSystem
        Laptop laptop1 = new Laptop(new String[]{"HP","14-dq0030nr", "Pale rose gold", "Celeron N4020", "Windows 11 S"},
                14, 207, 64, 4, 4.5,"bluetooth присутствует");
        Laptop laptop2 = new Laptop(new String[]{"Asus", "ASUS VivoBook L203", "black", "Celeron N4000", "Windows 10 S"},
                13.6, 182, 64, 4, 4, "bluetooth присутствует");
        Laptop laptop3 = new Laptop(new String[]{"Asus","ASUS Chromebook C203XA Rugged & Spill Resistant Laptop", "yellow", "Celeron", "Windows, Mac OS"},
                15.6,  479, 64, 6, 3.6, "bluetooth отсутствует");
        Laptop laptop4 = new Laptop(new String[]{"Lenovo", "IdeaPad Gaming 3", "green", "Core i5 Family", "Windows 11 in S mode"},
                15.6, 805, 250, 8, 4.9, "bluetooth присутствует");
        Laptop laptop5 = new Laptop(new String[]{"Dell", "Dell Vostro 5620 Business Laptop", "black", "Intel Core i7", "Windows 11 in S mode"}, 23.4,
                 595, 400, 4, 5.0, "bluetooth присутствует");
        Laptop laptop6 = new Laptop(new String[]{"Apple","Apple 2022 MacBook Air Laptop", "dark red", "AMD Ryzen 7", "Mac OS"},
                11.5, 1200, 128 , 12, 4.7, "bluetooth присутствует");
        Laptop laptop7 = new Laptop(new String[]{"Apple", "Late-2018 Apple MacBook Air", "gold", "Core i5 Family", "Mac OS"},
                14.8, 399, 256, 16, 3.8, "bluetooth присутствует");
        Laptop laptop8 = new Laptop(new String[]{"HP", "HP 14 Laptop, Intel Celeron N4020", "silver", "AMD Ryzen 7", "Windows 11 in S mode"},
                17, 501,300, 16, 4.9, "bluetooth присутствует");
        Laptop laptop9 = new Laptop(new String[]{"Asus", "ASUS TUF Gaming A17 Gaming Laptop", "lemon", "Intel Core i7", "Windows 10 in S mode"},
                20.3, 733,512, 4, 4.0, "bluetooth отсутствует");
        Laptop laptop10 = new Laptop(new String[]{"Asus", "ASUS TUF Dash 15 (2021) Ultra Slim Gaming Laptop", "white", "AMD Ryzen 7", "Windows 10 in S mode"},
                19.5,  401, 64 , 20, 4.6, "bluetooth отсутствует");
        Laptop laptop11 = new Laptop(new String[]{"HP", "HP EliteBook 840 G3 Laptop", "white", "Intel Core i5 12450H", "Windows 11 in S mode"},
                20.3, 950, 512, 2, 5.0, "bluetooth присутствует");
        Laptop laptop12 = new Laptop(new String[]{"Dell", "Dell G15 5520", "green", "Intel Core i7", "Windows Legacy System"},
                18.5, 666, 50, 8, 3.9, "bluetooth отсутствует");
        Laptop laptop13 = new Laptop(new String[]{"Lenovo", "Lenovo IdeaPad 3 11 Chromebook Laptop", "black", "AMD Ryzen 7", "Windows Legacy System"}, 22.2,
                 860, 128, 4, 4.1, "bluetooth присутствует");
        ArrayList<Laptop> laptops = new ArrayList<>();

        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
        laptops.add(laptop7);
        laptops.add(laptop8);
        laptops.add(laptop9);
        laptops.add(laptop10);
        laptops.add(laptop11);
        laptops.add(laptop12);
        laptops.add(laptop13);

        TypeParameter brand = new TypeParameter("brand", "бренд", "бренды", 0);//correct
        TypeParameter modelName = new TypeParameter("modelName", "модель", "модели", 1);
        TypeParameter screenSize = new TypeParameter("screenSize", "диагональ экрана", "диагонали экрана", 2);
        TypeParameter color = new TypeParameter("color", "цвет", "цвета", 2);//correct
        TypeParameter price = new TypeParameter("price", "цена", "цены", 8);
        TypeParameter hardDiskSize = new TypeParameter("hardDiskSize", "размер жёсткого диска", "размеры жёсткого диска", 5);
        TypeParameter cpuModel = new TypeParameter("cpuModel", "модель процессора", "модели процессора", 3);//correct
        TypeParameter ramMemoryInstalledSize = new TypeParameter("ramMemoryInstalledSize", "размер оперативной памяти", "размеры оперативной памяти", 7);
        TypeParameter operatingSystem = new TypeParameter("operatingSystem", "операционная система", "операционные системы", 4);//correct
        TypeParameter customersRating = new TypeParameter("customersRating", "рейтинг", "рейтингм", 9);
        TypeParameter bluetooth = new TypeParameter("bluetooth", "параметр bluetooth", "параметры bluetooth", 10);

        ArrayList<TypeParameter> typeParameters = new ArrayList<>();
        typeParameters.add(brand);
        typeParameters.add(modelName);
        typeParameters.add(screenSize);
        typeParameters.add(color);
        typeParameters.add(price);
        typeParameters.add(hardDiskSize);
        typeParameters.add(cpuModel);
        typeParameters.add(ramMemoryInstalledSize);
        typeParameters.add(operatingSystem);
        typeParameters.add(customersRating);
        typeParameters.add(bluetooth);


        HashMap<String, Set<String>> choosenParameters = new HashMap<>();

        choosenParameters.put("brand", new HashSet<>());
        choosenParameters.put("modelName", new HashSet<>());
        choosenParameters.put("screenSize", new HashSet<>());
        choosenParameters.put("color", new HashSet<>());
        choosenParameters.put("price", new HashSet<>());
        choosenParameters.put("hardDiskSize", new HashSet<>());
        choosenParameters.put("CPUModel", new HashSet<>());
        choosenParameters.put("ramMemoryInstalledSize", new HashSet<>());
        choosenParameters.put("operatingSystem", new HashSet<>());
        choosenParameters.put("customersRating", new HashSet<>());
        choosenParameters.put("bluetooth", new HashSet<>());

        double currentMinScreensize = 0;
        int currentMinPrice = 0;
        int currentMinHardDiskSize = 0;
        int currentMinRamMemoryInstalledSize = 0;
        String currentBluetoothCondition = "Не имеет значения";

        choiceCustomer(laptops, choosenParameters, typeParameters, currentMinScreensize, currentMinPrice, currentMinHardDiskSize, currentMinRamMemoryInstalledSize, currentBluetoothCondition);
    }

    private static void choiceCustomer(ArrayList<Laptop> laptops, HashMap<String, Set<String>> choosenParameters, ArrayList<TypeParameter> typeParameters, double currentMinScreensize, int currentMinPrice, int currentMinHardDiskSize, int currentMinRamMemoryInstalledSize, String currentBluetoothCondition) {
        Scanner scanner = new Scanner(System.in);
        String choice = " ";
        while (!choice.equals("13")) {
            System.out.println("Параметры выбора ноутбука: " +
                    "\n 1)Бренд" +
                    "\n 2)Модель" +
                    "\n 3)Диагональ экрана" +
                    "\n 4)Цвет" +
                    "\n 5)Цена" +
                    "\n 6)Размер жёского диска" +
                    "\n 7)Модель процессора" +
                    "\n 8)Оперативная память" +
                    "\n 9)Операционная система" +
                    "\n 10)Наличие Bluetooth" +
                    "\n  " +
                    "\n 11)Показать имеющиеся варианты" +
                    "\n 12)Очистить критерии поиска" +
                    "\n 13)Покинуть магазин");
            String[] variants = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
            choice = scanner.nextLine();
            while (!Arrays.asList(variants).contains(choice)) {
                System.out.println("Введено некорректное значение");
                choice = scanner.nextLine();
            }

            switch (choice){
                case "1": Menu.choice(laptops, choosenParameters, typeParameters.get(0));
                    continue;
                case "2": Menu.choice(laptops, choosenParameters, typeParameters.get(1));
                    continue;
                case "3": currentMinScreensize = Menu.choiceDigital(typeParameters.get(2));
                    continue;
                case "4": Menu.choice(laptops, choosenParameters, typeParameters.get(3));
                    continue;
                case "5": currentMinPrice = (int) Menu.choiceDigital(typeParameters.get(4));
                    continue;
                case "6": currentMinHardDiskSize = (int) Menu.choiceDigital(typeParameters.get(5));
                    continue;
                case "7": Menu.choice(laptops, choosenParameters, typeParameters.get(6));
                    continue;
                case "8": currentMinRamMemoryInstalledSize = (int) Menu.choiceDigital(typeParameters.get(7));
                    continue;
                case "9": Menu.choice(laptops, choosenParameters, typeParameters.get(8));
                    continue;
                case "10":currentBluetoothCondition = Menu.bluetoothChoice();
                    continue;
                case "11": Menu.addResults(laptops, choosenParameters, currentMinScreensize, currentMinPrice, currentMinHardDiskSize, currentMinRamMemoryInstalledSize, currentBluetoothCondition);
                    continue;
                case "12":
                    Iterator<Map.Entry<String, Set<String>>> iterator = choosenParameters.entrySet().iterator();
                    while (iterator.hasNext()){
                        iterator.next().getValue().clear();
                    }
                    currentMinScreensize = 0;
                    currentMinPrice = 0;
                    currentMinHardDiskSize = 0;
                    currentMinRamMemoryInstalledSize = 0;
                    currentBluetoothCondition = "Не имеет значения";
                    System.out.println("Все фильтры поиска были очищены");
                    continue;
                default: break;
            }
        }
    }




}
