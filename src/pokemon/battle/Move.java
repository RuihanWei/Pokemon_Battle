/*
Class move: a class that stores a move's name, category, type, basepower, accuracy, pp, effect of the move on different statusses and the degree of the effect
*/
package pokemon.battle;
public class Move {
    public String name; //variables of a move: name, category, type, basepower, accuracy, pp, effect of the move on different statusses and the degree of the effect
    public char category;  // 'p' for physical attack, 's' for special attack, '0' for status move
    public char type;
    public int basepower;
    public int accuracy;
    public int pp;
    public char [] effectOn;
    public double [] effectDegree;
    // constructor initializing variables
    Move(String name,char category, char type, int basepower, int accuracy, int pp, char [] effectOn, double [] effectDegree){
        this.name = name;
        this.category = category;
        this.type= type;
        this.basepower = basepower;
        this.accuracy = accuracy;
        this.pp = pp;
        this.effectOn = effectOn;
        this.effectDegree = effectDegree;
    }
    /*
    a method that returns the status of a move
    pre: none
    post: ret returned
    */
    public String toString(){
        String ret; // a variable that stores the return value
        ret = "name: " + this.name + "\r\ncategory: " + this.category + "\r\ntype: " + this.type + "\r\nBase Power: " + this.basepower + "\r\naccuracy: " + this.accuracy + "\r\npp: " + this.pp;
        return ret;
    }
}
