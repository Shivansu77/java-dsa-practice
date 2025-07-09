package hashMapsForTrees;

import javax.swing.text.html.parser.Entity;

public class mapUsingHash {
    private Entity[] entities;
    public mapUsingHash() {
        entities = new Entity[100];
    }
    private class Entity {
        String key;
        String value;
        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    public void put(String key, String value) {
        int hash = Math.abs(key.hashCode()%entities.length);
        entities[hash] = new Entity(key, value);//overriding

    }
    public String get(String key) {
        int hash = Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null&&entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }
    public void remove(String key) {
        int hash = Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null&&entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }
}
class Main{
    public static void main(String[] args) {
        mapUsingHash map = new mapUsingHash();
        map.put("Mango","King of fruits");
        map.put("Apple","A sweet red fruits");
        map.put("Litchi","Kunal's favourite food");
        System.out.println(map.get("Mango"));
        System.out.println(map.get("Apple"));
    }
}
