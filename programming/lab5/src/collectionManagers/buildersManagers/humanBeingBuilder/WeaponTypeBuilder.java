package collectionManagers.buildersManagers.humanBeingBuilder;

import collection.HumanBeing.WeaponType;
import collectionManagers.buildersManagers.ObjectBuilder;
import collectionManagers.validators.InputValidator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class WeaponTypeBuilder implements ObjectBuilder<WeaponType> {

    private Scanner scanner;

    public WeaponType build() throws IllegalArgumentException {
        try {
            System.out.println("Создание WeaponType:");
            InputValidator inputValidator = new InputValidator();
            String nextLine;
            while (true){
                try {
                    System.out.println("Выберите значение weaponType:");
                    for(WeaponType vales: WeaponType.values()){
                        System.out.println(vales);
                    }
                    nextLine = scanner.nextLine().toUpperCase();
                    if (inputValidator.validate(nextLine)) {
                        return WeaponType.valueOf(nextLine);
                    } else {
                    System.out.println("Строка на должна быть пустой. Попробуй еще.");
                    }
                } catch (IllegalArgumentException e){
                    System.out.println("Неправильное значение ввода. Попробуй еще.");
                }
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Во время конструирования объекта произошла ошибка: " + e.getMessage());
        }
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
