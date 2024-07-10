package br.pablo.fortnite.models.fortnite;

import java.util.List;
import lombok.Data;

@Data
public class VariantsItem{
	private String channel;
	private List<OptionsItem> options;
	private String type;
}