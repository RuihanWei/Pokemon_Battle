/*
Class Pokemon: a class that stores the variables of a pokemon: name, types, hp, at for attack, d for defense, sat for special attack, sd for special defense, s for speed, status and moves
*/
package pokemon.battle;

/**
 *
 * @author Wei
 */
public class Pokemon {
    public String name; // variables of a pokemon: name, types, hp, at for attack, d for defense, sat for special attack, sd for special defense, s for speed, status and moves.
    public char type[];
    public int hp;
    public int at;
    public int d;
    public int sat;
    public int sd;
    public int s;
    public char status;
    public Move [] moves;
    // move
    
    // constructor initializing variables
    public Pokemon(String name, char[] type, int hp, int at, int d, int sat, int sd, int s, Move [] move){
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.at = at;
        this.sat = sat;
        this.d = d;
        this.sd = sd;
        this.s = s;
        status = '0';// status is always initialized to '0' because a pokemon is not preimposed with a status
        this.moves = move;
        
    }
    
    /*
    a method that returns the status of a pokemon
    pre: length of type at least 2
    post: ret returned
    */
    public String toString(){
        String ret; // the string stroing the return value
        if (this.type[1] == '0')ret = this.name + "\r\ntype: " + this.type[0] + "\r\nHP: " + this.hp + "\r\nattack: " + this.at + "\r\nspecial attack: " + this.sat + "\r\ndefense: "+ this.d + "\r\nspecial defense: " + this.sd + "\r\nspeed: " + this.s + "\r\nstatus: " + this.status;
        else ret = this.name + "\r\ntype: " + this.type[0] +" and " + this.type[1] + "\r\nHP: " + this.hp + "\r\nattack: " + this.at + "\r\nspecial attack: " + this.sat + "\r\ndefense: "+ this.d + "\r\nspecial defense: " + this.sd + "\r\nspeed: " + this.s + "\r\nstatus: " + this.status;
        return ret;
    }
}
