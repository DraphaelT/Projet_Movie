package DTO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import fr.diginamic.Films;
import fr.diginamic.Genre;

public class Traitement {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	/*	ArrayList<FilmDTO> films;
		try {
			films = lireFichier();
		
		for(FilmDTO f : films) {
		System.out.println(f);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static ArrayList<FilmDTO> lireFichier() throws Exception{
		
	ObjectMapper mapper = new ObjectMapper();
	
	File files = new File("C:/Users/Thomas/Desktop/Projet 1 - Internet Movie Database/films.json");
	
	//Lis les Pays dans le fichier JSON
	CollectionType collType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, FilmDTO.class);
	
	ArrayList<FilmDTO> film = mapper.readValue(files, collType);
	
	return film;
	}
}
