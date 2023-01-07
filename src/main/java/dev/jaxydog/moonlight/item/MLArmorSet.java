package dev.jaxydog.moonlight.item;

import dev.jaxydog.moonlight.Moonlight;
import dev.jaxydog.moonlight.item.MLArmorItem.Material;
import dev.jaxydog.moonlight.item.MLItem.Config;
import dev.jaxydog.moonlight.utility.Registerable;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;

public class MLArmorSet implements Registerable {

	protected final Material _MATERIAL;
	protected final Settings _SETTINGS;
	protected final Config _CONFIG;
	protected final MLArmorItem[] _SET;

	public MLArmorSet(Material material, Settings settings, Config config) {
		_MATERIAL = material;
		_SETTINGS = settings;
		_CONFIG = config;
		_SET = _getSet();
	}

	protected MLArmorItem[] _getSet() {
		var h = new MLArmorItem(
			_MATERIAL.clone(),
			EquipmentSlot.HEAD,
			_SETTINGS,
			_CONFIG.clone(_CONFIG.getName() + "_helmet")
		);
		var c = new MLArmorItem(
			_MATERIAL.clone(),
			EquipmentSlot.CHEST,
			_SETTINGS,
			_CONFIG.clone(_CONFIG.getName() + "_chestplate")
		);
		var l = new MLArmorItem(
			_MATERIAL.clone(),
			EquipmentSlot.LEGS,
			_SETTINGS,
			_CONFIG.clone(_CONFIG.getName() + "_leggings")
		);
		var b = new MLArmorItem(
			_MATERIAL.clone(),
			EquipmentSlot.FEET,
			_SETTINGS,
			_CONFIG.clone(_CONFIG.getName() + "_boots")
		);

		return new MLArmorItem[] { b, l, c, h };
	}

	@Override
	public Identifier getId() {
		return Moonlight.id(_MATERIAL.getName());
	}

	@Override
	public MLArmorSet register() {
		for (var item : _SET) {
			item.register();
		}

		return this;
	}
}
