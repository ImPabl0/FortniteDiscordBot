package br.pablo.fortnite.models.fortnite;

import lombok.Data;

@Data
public class MaterialInstancesItem{
	private Images images;
	private String primaryMode;
	private Scalings scalings;
	private String productTag;
	private Object flags;
	private String id;
	private Colors colors;
}