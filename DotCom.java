package sinkadotcom;

import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourSelf(String userInput) {
        String result = "errado";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "eliminar";
            } else {
                result = "correto";
            }
        }

        return result;
    }
}
