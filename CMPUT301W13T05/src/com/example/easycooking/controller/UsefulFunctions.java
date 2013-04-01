package com.example.easycooking.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Environment;

import com.example.easycooking.model.*;
import com.google.gson.Gson;

/**
 * This class contains some functions that make our life easier.
 * @author HongZu
 */
public class UsefulFunctions {
	private Gson gson = new Gson();
	/**
	 * This operation receives a ArrayList<Recipe> that may contain 2 or more same recipes
	 * the operation will pick distinct recipes and put them to a new ArrayList<Recipe>
	 * then return this ArrayList<Recipe>
	 * @param inputList
	 * @return ArrayList<Recipe>
	 */
	public ArrayList<Recipe> Unique(ArrayList<Recipe> inputList){
		ArrayList<String> uniqueString = new ArrayList<String>();
		ArrayList<Recipe> uniqueList= new ArrayList<Recipe>();
		
		for(int i = 0;i<inputList.size();i++){
			if(!uniqueString.contains(inputList.get(i).getID())){
				uniqueString.add(inputList.get(i).getID());
				uniqueList.add(inputList.get(i));
			}
		}
		return uniqueList;
	}
	/**
	 * This operation saves a recipe into a .json file
	 * @param recipe
	 * @throws IOException
	 */
	public String saveInJason(Recipe recipe) throws IOException{
		String Json = gson.toJson(recipe);
    	Intent intent = new Intent(Intent.ACTION_SEND);
    	
    	String folder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cachedrecipes";
        File folderF = new File(folder);
        if (!folderF.exists()) {
            folderF.mkdir();
        }
       
        String jsonFilePath = folder + "/" +recipe.getID()+".json";
		File jsonFile = new File(jsonFilePath);
		FileWriter fw=new FileWriter(jsonFile);
	    BufferedWriter buffw=new BufferedWriter(fw);
	    PrintWriter pw=new PrintWriter(buffw);
	    fw.flush();
	    pw.write(Json);
	    pw.close();
	    buffw.close();
	    fw.close();
	    
	    return jsonFilePath;
	}
	public void deleteFile(String path){
		File temp = new File(path);
		temp.delete();
	}
	public Recipe getJsonFile(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		Recipe recipe = gson.fromJson(br, Recipe.class);
		return recipe;	
	}
}                                                                                                                                                                                                                                                                                                                    

