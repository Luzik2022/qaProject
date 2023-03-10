package org.example;

/**
 * Класс HeronTriangle
 *      класс описывающий тругольник с тремя известными сторонами
 */

public class HeronTriangle {

    /**
     * Площадь треугльника по формуле Герона
     *      S=sqrt(p(p-a)(p-b)(p-c)), где a,b,c - стороны, а р- полупериметр
     * @param a
     * @param b
     * @param c
     * @return
     * @throws DegenerateTriangleException
     * @throws InvalidTriangleException
     */
    public static Double getSquare (int a, int b, int c) throws DegenerateTriangleException, InvalidTriangleException {

        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        Integer p = (a+b+c)/2;
        if (p-a<0||p-b<0||p-c<0) {
            throw new InvalidTriangleException();
        } else if (p==0||p-a==0||p-b==0||p-c==0) {
            throw new DegenerateTriangleException();
        } else {
            System.out.println(" - "+Math.sqrt(p * (p - a) * (p - b) * (p - c)));
            Double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
    }
}