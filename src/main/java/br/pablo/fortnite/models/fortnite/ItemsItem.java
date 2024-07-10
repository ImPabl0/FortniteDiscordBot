package br.pablo.fortnite.models.fortnite;

import java.util.List;
import lombok.Data;

@Data
public class ItemsItem{
	private Object displayAssetPath;
	private Images images;
	private Set set;
	private List<String> shopHistory;
	private String added;
	private String definitionPath;
	private Object searchTags;
	private String description;
	private List<VariantsItem> variants;
	private Type type;
	private String path;
	private Series series;
	private String name;
	private Object metaTags;
	private Object dynamicPakId;
	private String id;
	private Introduction introduction;
	private List<String> gameplayTags;
	private Object showcaseVideo;
	private Rarity rarity;
	private String itemPreviewHeroPath;
	private List<String> builtInEmoteIds;
}