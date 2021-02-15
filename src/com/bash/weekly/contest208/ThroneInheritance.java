package com.bash.weekly.contest208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {

    String king;
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Boolean> deathMap = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        deathMap.put(kingName, false);
        map.put(kingName, new ArrayList<>());
    }

    public Integer birth(String parentName, String childName) {
        if (map.containsKey(parentName)){
            List<String> list = map.get(parentName);
            list.add(childName);
            map.put(parentName, list);
        }else {
            List<String> newList = new ArrayList<>();
            newList.add(childName);
            map.put(parentName, newList);
        }
        return null;
    }

    public Integer death(String name) {
        deathMap.put(name, true);
        return null;
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        if(deathMap.containsKey(king) && deathMap.get(king)){
            //do nothing
        }else{
            order.add(king);
        }
        inheritanceOrder(king, order, visited);
        return order;
    }

    private boolean hasNoChildren(String name){
        if(!map.containsKey(name)){
            return false;
        }
        List<String> childern =  map.get(name);
        return childern.isEmpty();
    }

    public void inheritanceOrder(String name, List<String> currOrder, Map<String, Boolean> visited){
        if(hasNoChildren(name)){
            return;
        }
        List<String> children = map.get(name);
        visited.put(name, true);
        if(children == null || children.isEmpty()){
            return;
        }
        for(String child : children){
            if(deathMap.containsKey(child) && deathMap.get(child)){
                //do nothing
            }else{
                currOrder.add(child);
            }
            inheritanceOrder(child, currOrder, visited);
        }
    }

    public static void main(String[] args){
        ThroneInheritance t= new ThroneInheritance("king");
        System.out.println(t.birth("king", "andy")); // order: king > andy
        System.out.println(t.birth("king", "bob")); // order: king > andy > bob
        System.out.println(t.birth("king", "catherine")); // order: king > andy > bob > catherine
        System.out.println(t.birth("andy", "matthew")); // order: king > andy > matthew > bob > catherine
        System.out.println(t.birth("bob", "alex")); // order: king > andy > matthew > bob > alex > catherine
        System.out.println(t.birth("bob", "asha")); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        System.out.println(t.death("bob")); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
    }

}