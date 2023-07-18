public class Laptop {
    String[] describedParameters;
    double screenSize;
    int price;
    int hardDiskSize;
    int ramMemoryInstalledSize;
    double customersRating;
    String bluetooth;

    public Laptop(String[] describedParameters, double screenSize, int price, int hardDiskSize,
                  int ramMemoryInstalledSize, double customersRating, String bluetooth) {
        this.describedParameters = describedParameters;
        this.screenSize = screenSize;
        this.price = price;
        this.hardDiskSize = hardDiskSize;
        this.ramMemoryInstalledSize = ramMemoryInstalledSize;
        this.customersRating = customersRating;
        this.bluetooth = bluetooth;
    }

    @Override
    public String toString() {
        return describedParameters[0] + " --- " + describedParameters[1] + " --- " + price + "$";
    }

    public String fullInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Фирма-производитель: " + describedParameters[0] + "\n");
        info.append("Название модели: " + describedParameters[1] + "\n");
        info.append("Диагональ экрана: " + screenSize + " дюймов \n");
        info.append("Цвет: " + describedParameters[2] + "\n");
        info.append("Цена: " + price + "$\n");
        info.append("Размер жёского диска: " + hardDiskSize + " ГБ\n");
        info.append("Модель процессора: " + describedParameters[3] + "\n");
        info.append("Оперативная память: " + ramMemoryInstalledSize + " ГБ\n");
        info.append("Операционная система: " + describedParameters[4] + "\n");
        info.append("Наличие Bluetooth: " + bluetooth + "\n");
        return info.toString();
    }
}