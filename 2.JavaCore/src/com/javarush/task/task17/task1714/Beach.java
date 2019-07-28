package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {
//        Beach first = new Beach("first", 11.3f, 4);
//        Beach second = new Beach("second", 3f, 8);
//        Beach third = new Beach("third", 10f, 10);
//
//        System.out.println(first.compareTo(second));
//        System.out.println(first.compareTo(third));
//        System.out.println(second.compareTo(third));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int thisBeachQuality = this.getQuality() - (int) this.getDistance();
        int comparedBeachQuality = o.getQuality() - (int) o.getDistance();
        return thisBeachQuality - comparedBeachQuality;
    }
}
