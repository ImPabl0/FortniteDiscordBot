package br.pablo.fortnite.models.fortnite;

import java.util.List;
import lombok.Data;

@Data
public class NewDisplayAsset{
	private Object cosmeticId;
	private String id;
	private List<MaterialInstancesItem> materialInstances;
}