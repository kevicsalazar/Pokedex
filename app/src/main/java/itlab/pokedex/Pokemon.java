package itlab.pokedex;


import java.util.List;

/**
 * Created by Kevin.
 */

class Pokemon {

    private String id;
    private String name;
    private int attack;
    private int defense;
    private int hp;
    private int height;
    private int weight;
    private int speed;
    private List<String> type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public String getType() {
        return type.get(0);
    }

    public String getImageUrl() {
        return "https://raw.githubusercontent.com/fanzeyi/Pokemon-DB/master/img/" + id + name.replace(". ", "_").replace("'", "") + ".png";
    }

}
