package com.wolviegames.exodus;

import com.wolviegames.exodus.equipment.exodus.equipment.EquipmentLoader;

public class Exodus {

    public static void main(String[] args){

        // Loaders
        EquipmentLoader equipmentLoader = new EquipmentLoader("config/EquipmentFileList.xml");

        System.out.println("Exodus");
    }
}
