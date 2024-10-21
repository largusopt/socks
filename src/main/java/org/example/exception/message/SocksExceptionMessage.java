package org.example.exception.message;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SocksExceptionMessage {
    public static final String COLOR_IS_INVALID = "Поле color  в объекте Socks не может быть пустым/null"; // дописаь для каждого и для другого класса
    public static final String COTTON_PART_IS_INVALID = "Поле cottonPart в объекта Socks не может быть пустым/null";
    public static final String QUANTITY_IS_INVALID = "Поле quantity не может быть пустым/null";
    public static final String SOCKS_ALREADY_EXISTS = "Носки уже существуют";
    public static final String SOCKS_NOT_FOUND = "Носков по данному запросу не найдено";
    public static final String OPERATION_NOT_FOUND = "Операция не найдена";
    public static final String SOCKS_NOT_ENOUGHT = "Носков недостаточно";
    public static final String COTTON_PART_MIN = "Минимальное значение хлопка 1";
    public static final String COTTON_PART_MAX = "Максимальное значение хлопка 100";
    public static final String QUANTITY_MIN = "Минимальное количество носков 1";

}
