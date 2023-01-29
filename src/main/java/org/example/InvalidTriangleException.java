/**
 * Класс InvalidTriangleException
 *      Исключение на случай невозможности треугольника херона по трем сторонам
 * @author : Хильченко А.Н
 * @project : HW_4
 * @date : 11.02.2022
 */

package org.example;
import java.util.*;

public class InvalidTriangleException extends Exception{
    public InvalidTriangleException() {
        super("Треугольник не существует");
    }
}


