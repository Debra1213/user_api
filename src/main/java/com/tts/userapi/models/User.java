package com.tts.userapi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data 
@Builder
@AllArgsConstructor
@NoArgConstructor
@Entity
public class User 
{
	@Id
	@GenerateValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Data
	public class Item {
	    @ApiModelProperty(notes = "The name of the menu item")
	    private String name;
	    @ApiModelProperty(notes = "The description of the menu item")
	    private String description;
	    @ApiModelProperty(notes = "The category of the menu item "
	                              "appetizer, entree, dessert, etc"
	    private String category;
	    @ApiModelProperty(notes = "The ingredients used in the menu item")
	    private List<String> ingredients;
	    @ApiModelProperty(notes = "The price of the menu item")
	    private double price;
	    @ApiModelProperty(notes = "The creation date of the menu item")
	    private Date createdDate;
	    @ApiModelProperty(notes = "The last updated date of the menu item")
	    private Date updatedDate;
	}
}
