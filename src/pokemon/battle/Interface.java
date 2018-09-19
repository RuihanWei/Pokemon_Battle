/*Name : Ruihan Wei
 Teacher : Ms. Hideg 
 Date : 6/1/2015
 Description: A pokemon battle simulator (details in proposal)
 */
package pokemon.battle;

import java.util.*;
import javax.swing.ImageIcon;

public class Interface extends javax.swing.JFrame {

    public static int round = 1;  // a variable that stores the number of rounds elapsed
    public static String battle; // a string that stores the battle aspects, displayed on on the textarea on the left of the interface
    public static Pokemon[] comp = new Pokemon[3]; // 2 arrays that stores the pokemons used by the user and the computer
    public static Pokemon[] user = new Pokemon[3];
    public static Pokemon useron; // stores the pokemon on battle of the user
    public static Pokemon compon; // stores the pokemon on battle of the computer
    int counter = 0; // a variable making sure that the frame is not called twice
    
    static Random inp = new Random(); // random number

    public Interface() {

        initComponents(); // initialize initial components

        char[] tydragonite = {'d', 'y'}; //initialize types of pokemons; dragonite:  'd' = dragon, 'y' = flying
        char[] tyarcanine = {'f', '0'}; // arcanine: 'f' = fire, '0' = none
        char[] tylucario = {'s', 'i'};  // lucario: 's' steel, 'i' = fighting
        char[] tyumbreon = {'k', '0'}; // umbreon: 'k' = dark
        char[] tygengar = {'h', 'o'};   // gengar: 'h' = ghost, 'o' = poison
        char[] tymilotic = {'w', '0'};    // milotic: 'w' = water

        char[] scaldEffectOn = {'b', '0'};  // effects and degree of effects of moves; sclad: 'b' = burn (when a move affects the status of a pokemon, the effect is directly stored), 30 = 30% chance 
        double[] scaldEffectDegree = {30, 0};
        char[] noeffect = {'0', '0'}; // for moves that do not have special effects
        double[] nodegree = {0, 0};
        char[] recoverEffectOn = {'h', '0'}; // recover: affects the hp of the pokemon and increases the hp by 1.5 of the base HP 
        double[] recoverEffectDegree = {1.5, 0};  // when the number is lower than 5, it shows the degree of the effect
        char[] iceBeamEffectOn = {'0', '0'}; // ice beam: cause freezing, 10 percent chance 
        double[] iceBeamEffectDegree = {10, 0}; // when the number is larger than 5, it shows the chance of the effect and the degree of effect is set to 1 stage (50%) if the stats (attack, defense etc. )is changed. Or if a status is inflicted (burn, freezing etc.), then it is just a chance
        char[] toxicEffectOn = {'p', '0'}; // toxic: cause poison, if hit, the opponent is 100% poisoned
        double[] toxicEffectDegree = {100, 0};
        char[] dragonDanceEffectOn = {'a', 's'}; // dragon dance: raises the attack and speed stats by 1 stage (50%)
        double[] dragonDanceEffectDegree = {-1.5, -1.5};
        char[] flareBlizEffectOn = {'h', 'b'};  // flare bliz: 10% chance of buring the foe, reduces the user's HP by 25% (when the number is negative, the effect is on the user)
        double[] flareBlizEffectDegree = {-0.75, 10};
        char[] closeCombatEffectOn = {'d', 'n'}; // close combat: lowers user's defense and special defense by 1 stage
        double[] closeCombatEffectDegree = {-0.5, -0.5};
        char[] wildChargeEffectOn = {'h', '0'}; // wild charge: reduces the user's HP by 20%
        double[] wildChargeEffectDegree = {-0.8, 0};
        char[] crunchEffectOn = {'d', '0'}; // cruch : 20% chance of lowering the foe's defense by 1 stage
        double[] cruchEffectDegree = {20, 0};
        char[] swordsDanceEffectOn = {'a', '0'}; // swords dance: increases the user's attack by 2
        double[] swordsDanceEffectDegree = {-2, 0};
        char[] screechEffectOn = {'d', '0'}; // screech: decreases the foe's defense by 2 stages
        double[] screechEffectDegree = {0.25, 0};
        char[] focusBlastEffectOn = {'n', '0'}; // focus blast: 10% chance of decreasing the foe's special defense by 1 stage
        double[] focusBlastEffectDegree = {10, 0};
        char[] shadowBallEffectOn = {'n', '0'}; // shadow ball: 20% of lower the foe's special defense by 1 stage
        double[] shadowBallEffectDegree = {20, 0};
        char[] energyBallEffectOn = {'n', '0'};  // energy ball: 10% chance of lowering the foe's special defense
        double[] energyBallEffectDegree = {10, 0};

        Move Scald = new Move("Scald", 's', 'w', 80, 100, 15, scaldEffectOn, scaldEffectDegree);  // initializing moves with unique values
        Move Recover = new Move("Recover", '0', 'n', 0, 100, 10, recoverEffectOn, recoverEffectDegree);
        Move IceBeam = new Move("Ice Beam", 's', 'c', 95, 100, 10, iceBeamEffectOn, iceBeamEffectDegree);
        Move Toxic = new Move("Toxic", '0', 'o', 0, 90, 10, toxicEffectOn, toxicEffectDegree);
        Move DragonDance = new Move("Dragon Dance", '0', 'd', 0, 100, 20, dragonDanceEffectOn, dragonDanceEffectDegree);
        Move DragonClaw = new Move("Dragon Claw", 'p', 'd', 80, 100, 15, noeffect, nodegree);
        Move AquaTail = new Move("Aqua Tail", 'p', 'w', 90, 90, 10, noeffect, nodegree);
        Move Roost = new Move("Roost", '0', 'n', 0, 100, 10, recoverEffectOn, recoverEffectDegree); // this move is identical to recover
        Move FlareBliz = new Move("Flare Bliz", 'p', 'f', 120, 100, 15, flareBlizEffectOn, flareBlizEffectDegree);
        Move CloseCombat = new Move("Close Combat", 'p', 'i', 120, 100, 5, closeCombatEffectOn, closeCombatEffectDegree);
        Move WildCharge = new Move("Wild Charge", 'p', 'e', 90, 100, 15, wildChargeEffectOn, wildChargeEffectDegree);
        Move Crunch = new Move("Crunch", 'p', 'k', 80, 100, 15, crunchEffectOn, cruchEffectDegree);
        Move SwordsDance = new Move("Swrods Dance", '0', 'i', 0, 100, 30, swordsDanceEffectOn, swordsDanceEffectDegree);
        Move Screech = new Move("Screech", '0', 'n', 0, 85, 40, screechEffectOn, screechEffectDegree);
        Move FocusBlast = new Move("Focus Blast", 's', 'i', 120, 70, 5, focusBlastEffectOn, focusBlastEffectDegree);
        Move ShadowBall = new Move("Shadow Ball", 's', 'h', 80, 100, 15, shadowBallEffectOn, shadowBallEffectDegree);
        Move EnergyBall = new Move("Energy Ball", 's', 'r', 80, 100, 10, energyBallEffectOn, energyBallEffectDegree);

        Move[] dragonitem = {DragonDance, DragonClaw, AquaTail, Roost}; // initialize pokemon moves
        Move[] miloticm = {Scald, Recover, IceBeam, Toxic};
        Move[] arcaninem = {FlareBliz, CloseCombat, WildCharge, Crunch};
        Move[] lucariom = {SwordsDance, CloseCombat, WildCharge, Screech};
        Move[] gengarm = {FocusBlast, ShadowBall, EnergyBall, Toxic};
        Move[] umbreonm = {EnergyBall, Crunch, Recover, ShadowBall};

        Pokemon Dragonite = new Pokemon("Dragonite", tydragonite, 91, 134, 95, 100, 100, 200, dragonitem);   //Initialize pokemons 
        Pokemon Arcanine = new Pokemon("Arcanine", tyarcanine, 90, 110, 80, 100, 80, 95, arcaninem);
        Pokemon Lucario = new Pokemon("Lucario", tylucario, 70, 110, 70, 115, 70, 90, lucariom);
        Pokemon Umbreon = new Pokemon("Umbreon", tyumbreon, 95, 65, 110, 60, 130, 65, umbreonm);
        Pokemon Gengar = new Pokemon("Gengar", tygengar, 60, 65, 60, 130, 75, 110, gengarm);
        Pokemon Milotic = new Pokemon("Milotic", tymilotic, 95, 60, 79, 100, 125, 80, miloticm);

        int[] a = {11, 11, 11, 11, 11, 11}; // an array that stores the randomly generated numbers that determines the computer and user's pokemons, all numbers initialized to 11 to not interfere with the process of eliminating same pokemons
        int storerandint = 11; // an integer that stores the randomly generated number to eliminate same pokemon being chosen twice (so that this number is not the same as other numbers existing in the array)

        for (int i = 0; i <= 5; i++) {      // for loop that randomly generates 6 pokemons
            storerandint = inp.nextInt(6);     // generating random integer that represents pokemons

            while (storerandint == a[0] || storerandint == a[1] || storerandint == a[2] || storerandint == a[3] || storerandint == a[4] || storerandint == a[5]) {
                storerandint = inp.nextInt(6);   // making sure that none of the pokemon overlap
            }
           
            a[i] = storerandint; // after the check, store the random integers
            
            if (i < 3) {              // storing the pokemons (represented by hte integers) that the user and computer use
                if (storerandint == 0) {
                    user[i] = Dragonite;
                }
                if (storerandint == 1) {
                    user[i] = Arcanine;
                }
                if (storerandint == 2) {
                    user[i] = Lucario;
                }
                if (storerandint == 3) {
                    user[i] = Umbreon;
                }
                if (storerandint == 4) {
                    user[i] = Gengar;
                }
                if (storerandint == 5) {
                    user[i] = Milotic;
                }

            } else {
                if (storerandint == 0) {
                    comp[i - 3] = Dragonite;
                }
                if (storerandint == 1) {
                    comp[i - 3] = Arcanine;
                }
                if (storerandint == 2) {
                    comp[i - 3] = Lucario;
                }
                if (storerandint == 3) {
                    comp[i - 3] = Umbreon;
                }
                if (storerandint == 4) {
                    comp[i - 3] = Gengar;
                }
                if (storerandint == 5) {
                    comp[i - 3] = Milotic;
                }
            }
        }

        useron = user[0]; // the first pokemon is the one on stage
        compon = comp[0];

        if (a[0] == 0) {  // detect the random variable stored and assign the photo corresponding to the number (representing a pokemon) to the label
            userpokemon.setIcon(new ImageIcon("dragonite.png"));
        }
        if (a[0] == 1) {
            userpokemon.setIcon(new ImageIcon("arcanine.png"));
        }

        if (a[0] == 2) {
            userpokemon.setIcon(new ImageIcon("lucario.png"));
        }
        if (a[0] == 3) {
            userpokemon.setIcon(new ImageIcon("umbreon.png"));
        }

        if (a[0] == 4) {
            userpokemon.setIcon(new ImageIcon("gengar.png"));
        }

        if (a[0] == 5) {
            userpokemon.setIcon(new ImageIcon("milotic.png"));
        }
        if (a[3] == 0) {
            computerpokemon.setIcon(new ImageIcon("dragonite.png"));
        }
        if (a[3] == 1) {
            computerpokemon.setIcon(new ImageIcon("arcanine.png"));
        }

        if (a[3] == 2) {
            computerpokemon.setIcon(new ImageIcon("lucario.png"));
        }
        if (a[3] == 3) {
            computerpokemon.setIcon(new ImageIcon("umbreon.png"));
        }

        if (a[3] == 4) {
            computerpokemon.setIcon(new ImageIcon("gengar.png"));
        }

        if (a[3] == 5) {
            computerpokemon.setIcon(new ImageIcon("milotic.png"));
        }

        ComputerPokemon.setText(compon.toString());  // showing the information of the pokemons and the moves
        UserPokemon.setText(useron.toString());
        move1.setText(useron.moves[0].toString());
        move2.setText(useron.moves[1].toString());
        move3.setText(useron.moves[2].toString());
        move4.setText(useron.moves[3].toString());
        switchp1.setText(user[0].toString());
        switchp2.setText(user[1].toString());
        switchp3.setText(user[2].toString());

        Disable(); // disable some irrelevant buttons

    }
    /*
     Determine if a pokemon won
     pre: at least 3 Pokemon stored in the arrays "comp" and "user" 
     post: open Win frame if a pokemon won and dispose of "this" frame
     */
    public void Win() {
        Win inFrame;
        if ((comp[0].hp <= 0) && (comp[1].hp <= 0) && (comp[2].hp <= 0) && (counter == 0)) { // when the hp of all computer pokemons are 0 and counter is 0
            counter = 1;
            inFrame = new Win(1);  // passing an integer to "Win"
            this.dispose();   // disposing this frame            
            inFrame.setVisible(true);   // setting the new frame visible            
        }

        else  if ((user[0].hp <= 0) && (user[1].hp <= 0) && (user[2].hp <= 0) && (counter == 0)) { // when the hp of all the user pokemons are 0 and coutner is 0
            counter = 1;
            inFrame = new Win(2);  // passing an integer to "Win"
            this.dispose();   // disposing this frame
            inFrame.setVisible(true);   // setting the new frame visible           
        }
    }
    
    /*
     Applying the effect of an attack on a pokemon
     pre: none
     post: Pokemons returned after the damage is applied
     */

    public static Pokemon[] AttackOnPokemon(Pokemon a, Move m, Pokemon b) {
        int chance; // determines if a move is used by 
        double typem = 1; // stores the type modifier variable, this is changed accroding to the type of move and pokemon
        int Attack = 0, defense = 0, z = 0; // variables storing the attack, base power of move, defense, and a random number
        double SameType = 1; // variable that stores 1.5 when the attack is of same type as the move
        chance = inp.nextInt(100) + 1;  // generate a random number between 0 and 100

        if (chance <= m.accuracy) {  // when the random number is higher than the accuracy (a number between 100 reprsenting the change out of 100 that the move can hit) the move is applied
            if (m.category == 'p') { // if the attack is physical store the attack and defense stats of both pokemons
                Attack = a.at;
                defense = b.d;
            }

            if (m.category == 's') { // if the attack is special, store the special atack and special defense stats of both pokemons
                Attack = a.sat;
                defense = b.sd;
            }

            if (m.type == a.type[0] || m.type == a.type[1]) {
                SameType = 1.5; //if the attack is of the same type as the user pokemon, the attack is 50% stronger
            }

            z = inp.nextInt(39) + 217; // a random integer between 217 and 255

            if (m.type == 'd') {  // when the type of the move is dragon 

                if (b.type[0] == 's' || b.type[1] == 's') {  // type modifier has halved when the pokemon is steel type
                    typem = typem * 0.5;
                }
                if (b.type[0] == 'd' || b.type[1] == 'd') {  // type modifier has doubled when the pokemon is dragon type
                    typem = typem * 2;
                }
            }
            if (m.type == 'w') { // when the type of the move is water
                if (b.type[0] == 'w' || b.type[1] == 'w') {  // when the pokemon has water type, damage halved
                    typem = typem * 0.5;
                }
                if (b.type[0] == 'g' || b.type[1] == 'g') { // when the pokemon has ground type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'f' || b.type[1] == 'f') { // when the pokemon has fire type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'r' || b.type[1] == 'r') { // when the pokemon has grass type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'd' || b.type[1] == 'd') { // when the pokemon has dragon type, damage halved
                    typem *= 0.5;
                }
            }
            if (m.type == 'c') {   //when the move is ice type
                if (b.type[0] == 'c' || b.type[1] == 'c') { //when the pokemon has ice type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'y' || b.type[1] == 'y') { // when the pokemon has flying type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'g' || b.type[1] == 'g') { // when the pokemon has ground type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 's' || b.type[1] == 's') { // when the pokemon has steel type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'f' || b.type[1] == 'f') { // when the pokemon has fire type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'w' || b.type[1] == 'w') { // when the pokemon has water type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'r' || b.type[1] == 'r') { // when the pokemon has gras type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'd' || b.type[1] == 'd') { // when the pokemon has dragon type, damage doubled
                    typem *= 2;
                }

            }
            if (m.type == 'n') {  // when the move is of normal type
                if (b.type[0] == 'h' || b.type[1] == 'h') { // when the pokemon has ghost type, no damage is dealt
                    typem *= 0;
                }
                if (b.type[0] == 's' || b.type[1] == 's') { // when the pokemon has steel type, damage halved
                    typem *= 0.5;
                }
            }
            if (m.type == 'o') { // when the move is poison type
                if (b.type[0] == 'o' || b.type[1] == 'o') { // when the pokemon has poison type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 's' || b.type[1] == 's') { // when the pokemon has steel type, no damage is dealt
                    typem *= 0;
                }
                if (b.type[0] == 'g' || b.type[1] == 'g') { // when the pokemon has gound type, damage halved 
                    typem *= 0.5;
                }
                if (b.type[0] == 'h' || b.type[1] == 'h') { // when the pokemon has ghost type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'r' || b.type[1] == 'r') { // when the pokemon has grass type, damage doubled
                    typem *= 2;
                }

            }
            if (m.type == 'f') { // when the move is fire type
                if (b.type[0] == 's' || b.type[1] == 's') { // when the pokemon has steel type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'f' || b.type[1] == 'f') { // when the pokemon has fire type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'w' || b.type[1] == 'w') { // when the pokemon has water type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'r' || b.type[1] == 'r') { // when the pokemon has gras type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'c' || b.type[1] == 'c') { // when the pokemon has ice type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'd' || b.type[1] == 'd') { // when the pokemon has dragon type, damage halved
                    typem *= 0.5;
                }
            }
            if (m.type == 'i') {
                if (b.type[0] == 'n' || b.type[1] == 'n') { // when the pokemon has normal type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'y' || b.type[1] == 'y') { // when the pokemon has flying type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'o' || b.type[1] == 'o') { // when the pokemon has poison type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'h' || b.type[1] == 'h') { // when the pokemon has ghost type, no damage dealt 
                    typem *= 0;
                }
                if (b.type[0] == 's' || b.type[1] == 's') { // when the pokemon has steel type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'c' || b.type[1] == 'c') { // when the pokemon has ice type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'k' || b.type[1] == 'k') { // when the pokemon has dark type, damage doubled
                    typem *= 2;
                }
            }
            if (m.type == 'e') { // when the move is electric type
                if (b.type[0] == 'e' || b.type[1] == 'e') { // when the pokemon has electric type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'y' || b.type[1] == 'y') { // when the pokemon has flying type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'g' || b.type[1] == 'g') { // when the pokemon has ground type, no damage dealt
                    typem *= 0;
                }
                if (b.type[0] == 'w' || b.type[1] == 'w') { // when the pokemon has water type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'r' || b.type[1] == 'r') { // when the pokemon has grass type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'd' || b.type[1] == 'd') { // when the pokemon has dragon type, damage halved
                    typem *= 0.5;
                }
            }
            if (m.type == 'k') { // when the type of the move is dark
                if (b.type[0] == 'i' || b.type[1] == 'i') { // when the pokemon has fighting type, damage halved 
                    typem *= 0.5;
                }
                if (b.type[0] == 'h' || b.type[1] == 'h') { // when the pokemon has ghost type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'k' || b.type[1] == 'k') { // when the pokemon has dark type, damage halved
                    typem *= 0.5;
                }
            }
            
            if (m.type == 'h') { // when the type of the move is ghost
                if (b.type[0] == 'n' || b.type[1] == 'n') { // when the pokemon has normal type, damage is 0 
                    typem *= 0;
                }
                if (b.type[0] == 'h' || b.type[1] == 'h') { // when the pokemon has ghost type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'k' || b.type[1] == 'k') { // when the pokemon has dark type, damage halved
                    typem *= 0.5;
                }
            }
                
            if (m.type == 'r') { // when the move is of grass type
                if (b.type[0] == 'y' || b.type[1] == 'y') { // when the pokemon has flying type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'o' || b.type[1] == 'o') { // when the pokemon has poison type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'g' || b.type[1] == 'g') { // when the pokemon has gound type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 's' || b.type[1] == 's') { // when the pokemon has steel type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'f' || b.type[1] == 'f') { // when the pokemon has fire type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'w' || b.type[1] == 'w') { // when the pokemon has water type, damage doubled
                    typem *= 2;
                }
                if (b.type[0] == 'r' || b.type[1] == 'r') { // when the pokemon has grass type, damage halved
                    typem *= 0.5;
                }
                if (b.type[0] == 'd' || b.type[1] == 'd') { // when the pokemon has dragon type, damage halved
                    typem *= 0.5;
                }
                
            }

            double damage = ((((((200 / 5) + 2) * Attack * m.basepower)/ defense) / 50) + 2) * typem * SameType / 10 * z / 255; //storing the damage
            if (a.status == 'b') {
                damage *= 1 / 2; // damage halved when the attacking pokemon has a burn condition
            }
            b.hp -= (int) Math.round(damage);  // damage deducted with rounded damage
        }

        Pokemon[] ret = {a, b}; //return the two pokemon
        return ret; // two pokemon returned
    }
    /*
     A method that applies the status/stats change of a pokemon caused by a move
     pre: none:
     post: pokemon status/stats changed if applicable
     */

    public static Pokemon[] StatusOnPokemon(Pokemon a, Move m, Pokemon b) {
        int chance;     //a variable that determines whether a status is afflicted (for moves with and without accuracy)

        if (m.category == '0') {  // if the move is a status move
            chance = inp.nextInt(100) + 1;  // random int between 0 and 100
            if (chance <= m.accuracy) {  // when the move hits
                if (m.effectOn[0] == 'h' || m.effectOn[1] == 'h') { // if a move affests the hp of a pokemon, 47 hp is added
                    a.hp += 47; // 47 is added to the hp
                    if (a.hp >= 95) {
                        a.hp = 95; // if the hp goes above 95 after the move is applied, make the hp 95 (to ensure fairness of the game)
                    }
                }
                if (m.effectOn[0] == 'a' || m.effectOn[1] == 'a') { //effect on attack
                    
                    if (m.effectOn[0] == 'a' && m.effectDegree[0] > 0) {
                        b.at *= m.effectDegree[0];  //if the effect is on the opponent 
                    }
                    if (m.effectOn[1] == 'a' && m.effectDegree[1] > 0) {
                        b.at *= m.effectDegree[1];
                    }
                    if (m.effectOn[0] == 'a' && m.effectDegree[0] < 0) {   //when the number is less than 0, the effect is on the user
                        a.at *= m.effectDegree[0] * (-1);  // if the effect is on the user, the number will be negagive so a -1 is timed to the result
                    }
                    if (m.effectOn[1] == 'a' && m.effectDegree[1] < 0) {
                        a.at *= m.effectDegree[1] * (-1);
                    }
                }

                if (m.effectOn[0] == 's' || m.effectOn[1] == 's') {  // effect on speed
                    if (m.effectOn[0] == 's' && m.effectDegree[0] > 0) {
                        b.s *= m.effectDegree[0];  //if the effect is on the opponent 
                    }
                    if (m.effectOn[1] == 's' && m.effectDegree[1] > 0) {
                        b.s *= m.effectDegree[1];
                    }
                    if (m.effectOn[0] == 's' && m.effectDegree[0] < 0) {
                        a.s *= m.effectDegree[0] * (-1);  // if the effect is on the user
                    }
                    if (m.effectOn[1] == 's' && m.effectDegree[1] < 0) {
                        a.s *= m.effectDegree[1] * (-1);
                    }
                }

                if (m.effectOn[0] == 'd' || m.effectOn[1] == 'd') { // effect on defense
                    if (m.effectOn[0] == 'd' && m.effectDegree[0] > 0) {
                        b.s *= m.effectDegree[0];  //if the effect is on the opponent 
                    }
                    if (m.effectOn[1] == 'd' &&  m.effectDegree[1] > 0) {
                        b.s *= m.effectDegree[1];
                    }
                    if (m.effectOn[0] == 'd' &&  m.effectDegree[0] < 0) {
                        a.s *= m.effectDegree[0] * (-1);  // if the effect is on the user
                    }
                    if (m.effectOn[1] == 'd' &&  m.effectDegree[1] < 0) {
                        a.s *= m.effectDegree[1] * (-1);
                    }
                }

                if (m.effectOn[0] == 'n' || m.effectOn[1] == 'n') {   // effect on special defense
                    if (m.effectOn[0] == 'n' && m.effectDegree[0] > 0) {
                        b.sd *= m.effectDegree[0];  //if the effect is on the opponent 
                    }
                    if (m.effectOn[1] == 'n' && m.effectDegree[1] > 0) {
                        b.sd *= m.effectDegree[1];
                    }
                    if (m.effectOn[0] == 'n' && m.effectDegree[0] < 0) {
                        a.sd *= m.effectDegree[0] * (-1);  // if the effect is on the user
                    }
                    if (m.effectOn[1] == 'n' && m.effectDegree[1] < 0) {
                        a.sd *= m.effectDegree[1] * (-1);
                    }
                }

                if (m.effectOn[0] == 'p' || m.effectOn[1] == 'p') {   //poisons the pokemon 
                    b.status = 'p';  // changes the status to poison 
                }
            }
        }

        if (m.category != '0') {    // when the move is not a status move
            if (m.effectOn[0] != '0') { // when there is an effect on the first slot

                if (m.effectDegree[0] > 5) { //when effectDegree is larger than 5, it stores the percent chance of inflicting the status change

                    chance = inp.nextInt(100) + 1; // chance of hit
                    if (chance <= m.effectDegree[0]) {   //determine if the status change is afflicted
                        if (m.effectOn[0] == 's') {
                            b.s *= 0.5;
                        }
                        if (m.effectOn[0] == 'a') {
                            b.at *= 0.5;
                        }
                        if (m.effectOn[0] == 'd') {
                            b.d *= 0.5;
                        }
                        if (m.effectOn[0] == 'n') {
                            b.sd *= 0.5;
                        }
                        if (m.effectOn[0] == 'b') {
                            b.status = 'b';
                        }

                    }
                } else {
                    if (m.effectOn[0] == 'a') { //effect on attack
                        if (m.effectDegree[0] > 0) {
                            b.at *= m.effectDegree[0];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[0] < 0) {
                            a.at *= m.effectDegree[0] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[0] == 's') { //effect on attack
                        if (m.effectDegree[0] > 0) {
                            b.s *= m.effectDegree[0];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[0] < 0) {
                            a.s *= m.effectDegree[0] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[0] == 'd') { //effect on attack
                        if (m.effectDegree[0] > 0) {
                            b.d *= m.effectDegree[0];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[0] < 0) {
                            a.d *= m.effectDegree[0] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[0] == 'n') { //effect on attack
                        if (m.effectDegree[0] > 0) {
                            b.sd *= m.effectDegree[0];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[0] < 0) {
                            a.sd *= m.effectDegree[0] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[0] == 'h') { //effect on attack
                        if (m.effectDegree[0] > 0) {
                            b.hp *= m.effectDegree[0];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[0] < 0) {
                            a.hp *= m.effectDegree[0] * (-1);  // if the effect is on the user
                        }
                    }

                }
            }

            if (m.effectOn[1] != '0') { // when there is an effect on the first slot

                if (m.effectDegree[1] > 5) { //when effectDegree is larger than 5, it stores the percent chance of inflicting the status change

                    chance = inp.nextInt(100) + 1; // chance of hit
                    if (chance <= m.effectDegree[1]) {   //determine if the status change is afflicted
                        if (m.effectOn[1] == 's') {
                            b.s *= 0.5;
                        }
                        if (m.effectOn[1] == 'a') {
                            b.at *= 0.5;
                        }
                        if (m.effectOn[1] == 'd') {
                            b.d *= 0.5;
                        }
                        if (m.effectOn[1] == 'n') {
                            b.sd *= 0.5;
                        }
                        if (m.effectOn[1] == 'b') {
                            b.status = 'b';
                        }
                    }
                } else {
                    if (m.effectOn[1] == 'a') { //effect on attack
                        if (m.effectDegree[1] > 0) {
                            b.at *= m.effectDegree[1];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[1] < 0) {
                            a.at *= m.effectDegree[1] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[1] == 's') { //effect on attack
                        if (m.effectDegree[1] > 0) {
                            b.s *= m.effectDegree[1];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[1] < 0) {
                            a.s *= m.effectDegree[1] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[1] == 'd') { //effect on attack
                        if (m.effectDegree[1] > 0) {
                            b.d *= m.effectDegree[1];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[1] < 0) {
                            a.d *= m.effectDegree[1] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[1] == 'n') { //effect on attack
                        if (m.effectDegree[1] > 0) {
                            b.sd *= m.effectDegree[1];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[1] < 0) {
                            a.sd *= m.effectDegree[1] * (-1);  // if the effect is on the user
                        }
                    }

                    if (m.effectOn[1] == 'h') { //effect on attack
                        if (m.effectDegree[1] > 0) {
                            b.hp *= m.effectDegree[1];  //if the effect is on the opponent 
                        }
                        if (m.effectDegree[1] < 0) {
                            a.hp *= m.effectDegree[1] * (-1);  // if the effect is on the user
                        }
                    }

                }
            }

        }
        if (a.status == 'p') {
            a.hp *= 0.875;   // deduct 1/8 of the hp if the pokemon is poisoned or burned
        }
        if (b.status == 'p') {
            b.hp *= 0.875;
        }
        if (a.status == 'b') {
            a.hp *= 0.875;
        }
        if (b.status == 'b') {
            b.hp *= 0.875;
        }
        Pokemon[] ret = {a, b}; // returning the two pokemon variables
        return ret;  // pokemon returned
    }

    /* 
     Method that operates the battle
     pre: 0 < b < 5
     post: pokemon variables changed according to the moves used, some labels and textboxes changed if applicable
     */
    
    public void Battle(char a, int b) {
        round++; // adds 1 to round count
        Pokemon[] retpoke = new Pokemon[2]; // an array that stores the return of the two methods 
        int compmove = inp.nextInt(4);  // a random integer between 0 and 3

        if (a == 'm') {
            if (useron.s >= compon.s) {  // when the speed of the user pokemon is higher than the speed of the computer's pokemon, the user moves first

                if (useron.moves[b - 1].category == 'p' || useron.moves[b - 1].category == 's') { // when the move is an attack move
                    retpoke = AttackOnPokemon(useron, useron.moves[b - 1], compon);  // pass in the user, move and pokemon to the method "AttackOnPokemon"
                    useron = retpoke[0];  //storing the return values
                    compon = retpoke[1];

                }
                retpoke = StatusOnPokemon(useron, useron.moves[b - 1], compon); // apply status effects of moves on pokemon (status effects exist for attack moves and status moves)

                useron = retpoke[0]; // returning pokemons
                compon = retpoke[1];
                if (!Faint('c')) { // if the opponent did not faint apply the opponents' attack (in this case the computer's attack)

                    if (compon.moves[compmove].category == 'p' || compon.moves[compmove].category == 's') {
                        retpoke = AttackOnPokemon(compon, compon.moves[compmove], useron);
                        compon = retpoke[0];
                        useron = retpoke[1];

                    }
                    retpoke = StatusOnPokemon(compon, compon.moves[compmove], useron);

                    compon = retpoke[0];
                    useron = retpoke[1];
                }
                

            } else { // else the computer moves first
                if (compon.moves[compmove].category == 'p' || compon.moves[compmove].category == 's') {
                    retpoke = AttackOnPokemon(compon, compon.moves[compmove], useron);
                    compon = retpoke[0];
                    useron = retpoke[1];

                }
                retpoke = StatusOnPokemon(compon, compon.moves[compmove], useron);

                compon = retpoke[0];
                useron = retpoke[1];

                if (!Faint('u')) { // if the user did not faint, apply the user's move

                    if (useron.moves[b - 1].category == 'p' || useron.moves[b - 1].category == 's') {
                        retpoke = AttackOnPokemon(useron, useron.moves[b - 1], compon);
                        useron = retpoke[0];
                        compon = retpoke[1];

                    }
                    retpoke = StatusOnPokemon(useron, useron.moves[b - 1], compon);

                    useron = retpoke[0];
                    compon = retpoke[1];
                }
            }

            useron.moves[b - 1].pp--; //computer pp does not go down
        } else {     // when the user swithces pokemon
            if (useron.name == user[0].name) {
                user[0].hp = useron.hp;        // when a pokemon is switched out, the hp, number of pp remaining for each move and type remains the same
                user[0].status = useron.status;
                user[0].moves = useron.moves;
            }
            if (useron.name == user[1].name) {
                user[1].hp = useron.hp;        // when a pokemon is switched out, the hp, number of pp and type remains the same
                user[1].status = useron.status;
                user[1].moves = useron.moves;
            }
            if (useron.name == user[2].name) {
                user[2].hp = useron.hp;        // when a pokemon is switched out, the hp, number of pp and type remains the same
                user[2].status = useron.status;
                user[2].moves = useron.moves;
            }

            if (compon.moves[compmove].category == 'p' || compon.moves[compmove].category == 's') { // the computer makes its move
                retpoke = AttackOnPokemon(compon, compon.moves[compmove], useron);
                compon = retpoke[0];
                useron = retpoke[1];

            }
            retpoke = StatusOnPokemon(compon, compon.moves[compmove], useron);

            compon = retpoke[0];
            useron = retpoke[1];

            WhichPokemon(user[b - 1], 'u'); // change the label to the new pokemon
            Disable();  // disable unnecessary buttons
            useron = user[b - 1];  // swtich to the new pokemon
        }

        Faint('q'); // switching pokemon when necessary. No return value is stored

        ComputerPokemon.setText(compon.toString()); // updating the labels and textarea information
        UserPokemon.setText(useron.toString());
        move1.setText(useron.moves[0].toString());
        move2.setText(useron.moves[1].toString());
        move3.setText(useron.moves[2].toString());
        move4.setText(useron.moves[3].toString());
        Disable(); //disables some buttons that are not usable in the context 
    }
    
    /*
    determine if the pokemon onstage fainted, if so apply acitons
    pre: none
    post: true or false returned depending on whether the pokemon faints, when all the pokemon on a team faints, win mothod is run
    */
    public boolean Faint(char a) {
        if ((useron.moves[0].pp == 0) && (useron.moves[1].pp == 0) && (useron.moves[2].pp == 0) && (useron.moves[3].pp == 0)) {// the pokemon faints if the pp's area 0
            useron.hp = 0;
        }
        if ((useron.hp <= 0)) { // when the user's pokemon on the stage faints

            if ((user[0].name != useron.name) && (useron.hp <= 0) && (user[0].hp > 0)) { //when the hp of the first pokemon is not 0, switch to that pokemon
                useron = user[0];
                WhichPokemon(user[0], 'u'); // updating the label picture depending on which pokemon is on stage

            } else if ((user[1].name != useron.name) && (useron.hp <= 0) && (user[1].hp > 0)) { // if the hp of the second pokemon is not 0, switch to that pokemon
                useron = user[1];
                WhichPokemon(user[1], 'u');

            } else if ((user[2].name != useron.name) && (useron.hp <= 0) && (user[2].hp > 0)) { // if the hp of the third pokemon is not 0, switch to that pokemon
                useron = user[2];
                WhichPokemon(user[2], 'u');
            } else {  // if all hp's are 0, run Win method
                Win();
            }
            if (a == 'u') { // if a the variable wished to be detected is the user's, return true
                return true;
            }

        }
        if ((compon.moves[0].pp == 0) && (compon.moves[1].pp == 0) && (compon.moves[2].pp == 0) && (compon.moves[3].pp == 0)) {// the pokemon faints if the pp's area 0
            compon.hp = 0;
        }

        if (compon.hp <= 0) { // when the computer's pokemon on stage is 0

            if ((comp[0].name != compon.name) && (compon.hp <= 0) && (comp[0].hp > 0)) { // swtich to the first pokemon if possible
                compon = comp[0];
                WhichPokemon(comp[0], 'c');
            }

            else if ((comp[1].name != compon.name) && (compon.hp <= 0) && (comp[1].hp > 0)) { // switch to second pokemon if possible
                compon = comp[1];
                WhichPokemon(comp[1], 'c');
            }

            else if ((comp[2].name != compon.name) && (compon.hp <= 0) && (comp[2].hp > 0)) { // switchj to third pokemon if possible
                compon = comp[2];
                WhichPokemon(comp[2], 'c');

            } else { // if all pokemon fainted, run the Win method
                Win();
            }

            if (a == 'c') { // if the variable to be detected is the user's, return true
                return true;
            }
        }
        return false; // if the on stage pokemons did not faint, return false
    }
    /* 
    a method that sets the label to a pokemon required
    pre: none
    post: label picture changed
    */
    public static void WhichPokemon(Pokemon a, char which) {
        if (which == 'u') {
            if (a.name == "Dragonite") {
                userpokemon.setIcon(new ImageIcon("dragonite.png"));
            }
            if (a.name == "Arcanine") {
                userpokemon.setIcon(new ImageIcon("arcanine.png"));
            }
            if (a.name == "Lucario") {
                userpokemon.setIcon(new ImageIcon("lucario.png"));
            }
            if (a.name == "Umbreon") {
                userpokemon.setIcon(new ImageIcon("umbreon.png"));
            }
            if (a.name == "Gengar") {
                userpokemon.setIcon(new ImageIcon("gengar.png"));
            }
            if (a.name == "Milotic") {
                userpokemon.setIcon(new ImageIcon("milotic.png"));
            }
        }

        if (which == 'c') {
            if (a.name == "Dragonite") {
                computerpokemon.setIcon(new ImageIcon("dragonite.png"));
            }
            if (a.name == "Arcanine") {
                computerpokemon.setIcon(new ImageIcon("arcanine.png"));
            }
            if (a.name == "Lucario") {
                computerpokemon.setIcon(new ImageIcon("lucario.png"));
            }
            if (a.name == "Umbreon") {
                computerpokemon.setIcon(new ImageIcon("umbreon.png"));
            }
            if (a.name == "Gengar") {
                computerpokemon.setIcon(new ImageIcon("gengar.png"));
            }
            if (a.name == "Milotic") {
                computerpokemon.setIcon(new ImageIcon("milotic.png"));
            }
        }
    }
/*
    disable unnecessary buttons
    pre: none
    post: buttons disabled
    */
    public static void Disable() {
        if (useron.name == user[0].name) { // if a pokemon is on stage, the pokemon cannot be switched on stage
            pokemon1.setEnabled(false);
            pokemon2.setEnabled(true);
            pokemon3.setEnabled(true);
        }
        if (useron.name == user[1].name) {
            pokemon1.setEnabled(true);
            pokemon2.setEnabled(false);
            pokemon3.setEnabled(true);
        }
        if (useron.name == user[2].name) {
            pokemon3.setEnabled(false);
            pokemon1.setEnabled(true);
            pokemon2.setEnabled(true);
        }
        if (user[0].hp <= 0) { // if the hp of a pokemon not on stage is 0. set the switch button for that pokemon to false
            pokemon1.setEnabled(false);
        }
        if (user[1].hp <= 0) {
            pokemon2.setEnabled(false);
        }
        if (user[2].hp <= 0) {
            pokemon3.setEnabled(false);
        }

        if (useron.moves[0].pp == 0) { // if the pp of a move is 0, disable the switch button for that option, else enable the button 
            use1.setEnabled(false);
        } else {
            use1.setEnabled(true);
        }
        if (useron.moves[1].pp == 0) {
            use2.setEnabled(false);
        } else {
            use2.setEnabled(true);
        }
        if (useron.moves[2].pp == 0) {
            use3.setEnabled(false);
        } else {
            use3.setEnabled(true);
        }
        if (useron.moves[3].pp == 0) {
            use4.setEnabled(false);
        } else {
            use4.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userpokemon = new javax.swing.JLabel();
        computerpokemon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComputerPokemon = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        UserPokemon = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        move3 = new javax.swing.JTextArea();
        use1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        move1 = new javax.swing.JTextArea();
        use4 = new javax.swing.JButton();
        use2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        move4 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        move2 = new javax.swing.JTextArea();
        use3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        switchp2 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        switchp1 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        switchp3 = new javax.swing.JTextArea();
        pokemon3 = new javax.swing.JButton();
        pokemon2 = new javax.swing.JButton();
        pokemon1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComputerPokemon.setColumns(20);
        ComputerPokemon.setRows(5);
        jScrollPane1.setViewportView(ComputerPokemon);

        UserPokemon.setColumns(20);
        UserPokemon.setRows(5);
        jScrollPane2.setViewportView(UserPokemon);

        move3.setColumns(20);
        move3.setRows(5);
        jScrollPane3.setViewportView(move3);

        use1.setText("Use");
        use1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                use1ActionPerformed(evt);
            }
        });

        move1.setColumns(20);
        move1.setRows(5);
        jScrollPane4.setViewportView(move1);

        use4.setText("Use");
        use4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                use4ActionPerformed(evt);
            }
        });

        use2.setText("Use");
        use2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                use2ActionPerformed(evt);
            }
        });

        move4.setColumns(20);
        move4.setRows(5);
        jScrollPane5.setViewportView(move4);

        move2.setColumns(20);
        move2.setRows(5);
        jScrollPane6.setViewportView(move2);

        use3.setText("Use");
        use3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                use3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(use1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 413, Short.MAX_VALUE)
                        .addComponent(use3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(use2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(use4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(498, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(use1)
                            .addComponent(use3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(use2)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(use4)
                                .addGap(61, 61, 61))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(129, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Moves", jPanel1);

        switchp2.setColumns(20);
        switchp2.setRows(5);
        jScrollPane7.setViewportView(switchp2);

        switchp1.setColumns(20);
        switchp1.setRows(5);
        jScrollPane8.setViewportView(switchp1);

        switchp3.setColumns(20);
        switchp3.setRows(5);
        jScrollPane9.setViewportView(switchp3);

        pokemon3.setText("Switch");
        pokemon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon3ActionPerformed(evt);
            }
        });

        pokemon2.setText("Switch");
        pokemon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon2ActionPerformed(evt);
            }
        });

        pokemon1.setText("Switch");
        pokemon1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pokemon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemon1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Pokemon Default stats");

        jLabel2.setText("Pokemon Default stats");

        jLabel3.setText("Pokemon Default stats");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(pokemon1)
                        .addGap(209, 209, 209)
                        .addComponent(pokemon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(160, 160, 160)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(166, 166, 166))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(pokemon3)
                            .addGap(105, 105, 105)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pokemon3)
                    .addComponent(pokemon1)
                    .addComponent(pokemon2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pokemon", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(computerpokemon)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(userpokemon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(computerpokemon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userpokemon))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /* 
    runs the battle method with 'm' representing move, and 1 representing which move
    pre: none
    post: "Battle" method run
    */
    private void use1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_use1ActionPerformed
        Battle('m', 1);
    }//GEN-LAST:event_use1ActionPerformed
    // see use1ActionPerformed
    private void use4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_use4ActionPerformed
        Battle('m', 4);
    }//GEN-LAST:event_use4ActionPerformed
    // see use1ActionPerformed
    private void use2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_use2ActionPerformed
        Battle('m', 2);
    }//GEN-LAST:event_use2ActionPerformed
    // see use1ActionPerformed
    private void use3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_use3ActionPerformed
        Battle('m', 3);
    }//GEN-LAST:event_use3ActionPerformed
/* 
    runs the "battle" method with 's' representing switch and 1 representing switching to which pokemon
    pre: none
    post: Battle run
    */
    private void pokemon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokemon1ActionPerformed
        Battle('s', 1);
    }//GEN-LAST:event_pokemon1ActionPerformed
    // see pokemon1ActionPerformed
    private void pokemon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokemon2ActionPerformed
        Battle('s', 2);
    }//GEN-LAST:event_pokemon2ActionPerformed
    //see pokemon1ActionPerformed
    private void pokemon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokemon3ActionPerformed
        Battle('s', 3);
    }//GEN-LAST:event_pokemon3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea ComputerPokemon;
    public static javax.swing.JTextArea UserPokemon;
    public static javax.swing.JLabel computerpokemon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea move1;
    public static javax.swing.JTextArea move2;
    public static javax.swing.JTextArea move3;
    public static javax.swing.JTextArea move4;
    public static javax.swing.JButton pokemon1;
    public static javax.swing.JButton pokemon2;
    public static javax.swing.JButton pokemon3;
    public static javax.swing.JTextArea switchp1;
    public static javax.swing.JTextArea switchp2;
    public static javax.swing.JTextArea switchp3;
    public static javax.swing.JButton use1;
    public static javax.swing.JButton use2;
    public static javax.swing.JButton use3;
    public static javax.swing.JButton use4;
    public static javax.swing.JLabel userpokemon;
    // End of variables declaration//GEN-END:variables
}
