package br.pablo.fortnite.models.fortnite;

import java.util.List;
import lombok.Data;

@Data
public class EntriesItem{
	private String displayAssetPath;
	private Bundle bundle;
	private String newDisplayAssetPath;
	private int regularPrice;
	private int finalPrice;
	private Banner banner;
	private Object section;
	private String sectionId;
	private String devName;
	private boolean giftable;
	private Layout layout;
	private int sortPriority;
	private NewDisplayAsset newDisplayAsset;
	private String tileSize;
	private String offerId;
	private boolean refundable;
	private Object categories;
	private List<ItemsItem> items;
}