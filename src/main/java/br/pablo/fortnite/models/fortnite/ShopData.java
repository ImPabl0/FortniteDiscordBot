package br.pablo.fortnite.models.fortnite;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class ShopData{
	@MongoId
	private String date;
	private Featured featured;
	private String vbuckIcon;
	private Daily daily;
	private String hash;
}