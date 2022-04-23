package com.example.examplemod.integration.crafttweaker;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.examplemod.CustomObject")
@Document("mods/examplemod/CustomObject")
public class CustomObject {

    //Simple Object implementation, exposed to CraftTweaker

    //Recipe managers require an Object IRecipeHandler and an IProcessingRecipeManager.

    private String name;
    private int amount;


    private static int objectCount;

    @ZenCodeType.Constructor
    public CustomObject(String name, int amount){
        this.name = name;
        this.amount = amount;

        objectCount++;
    }

    @ZenCodeType.Method
    public static void printObjects(){
        CraftTweakerAPI.LOGGER.info("There are " + objectCount + " Custom Objects registered");
    }

    @ZenCodeType.Method
    public void setName(String name){

    }

}
