package net.minecraft.client.renderer.entity;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;
import mods.flammpfeil.maidvillager.ModelMaidZombie;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.src.ModLoader;

public class MaidVillagerRenderAccessHelper {
	static public void setModel(RenderVillager render, ModelBase model){

		render.mainModel = model;
		render.villagerModel = (ModelVillager)model;
	}

	static public void setModel(RenderWitch render, ModelBase model){

		render.mainModel = model;
	}

	static public void setMaidModel(RenderZombie render){


		ReflectionHelper.setPrivateValue(RenderZombie.class, render, 10,"field_82431_q");

		ReflectionHelper.setPrivateValue(RenderZombie.class, render, new ModelMaidZombie(), "field_82432_p");

		ModelMaidZombie hideModel = new ModelMaidZombie();
		hideModel.maid.root.isHidden = true;
		ReflectionHelper.setPrivateValue(RenderZombie.class, render, hideModel, "field_82436_m");
		ReflectionHelper.setPrivateValue(RenderZombie.class, render, hideModel, "field_82433_n");
	}
}
