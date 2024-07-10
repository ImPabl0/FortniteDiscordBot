package br.pablo.fortnite.models.fortnite;

import java.util.List;
import lombok.Data;

@Data
public class Series{
	private String image;
	private String backendValue;
	private String value;
	private List<String> colors;
}