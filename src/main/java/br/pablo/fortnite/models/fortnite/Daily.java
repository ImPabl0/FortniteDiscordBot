package br.pablo.fortnite.models.fortnite;

import java.util.List;
import lombok.Data;

@Data
public class Daily{
	private List<EntriesItem> entries;
	private String name;
}