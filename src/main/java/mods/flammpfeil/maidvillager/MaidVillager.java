package mods.flammpfeil.maidvillager;


import net.minecraft.client.renderer.entity.MaidVillagerRenderAccessHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

@Mod(name = "MaidVillager", modid = "flammpfeil.maidvillager", version = "mc1.7.2 r1")
public class MaidVillager
{
    public static final boolean isDebug = false;
    public static float defaultSize = 1.1f;
    public static float childSize = 0.5f;

    public static Configuration mainConfiguration;

    @EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        mainConfiguration = new Configuration(evt.getSuggestedConfigurationFile());

        try
        {
            mainConfiguration.load();
            Property prop;
            prop = mainConfiguration.get(Configuration.CATEGORY_GENERAL, "DefaultSize", defaultSize);
            defaultSize = (float)prop.getDouble(defaultSize);
            prop = mainConfiguration.get(Configuration.CATEGORY_GENERAL, "ChildSize", childSize);
            childSize = (float)prop.getDouble(childSize);
        }
        finally
        {
            mainConfiguration.save();
        }
    }

    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent evt)
    {
        RenderVillager render = (RenderVillager)RenderManager.instance.entityRenderMap.get(EntityVillager.class);
        MaidVillagerRenderAccessHelper.setModel(render, new ModelMaidVillager(0.0F));
        RenderWitch renderWitch = (RenderWitch)RenderManager.instance.entityRenderMap.get(EntityWitch.class);
        MaidVillagerRenderAccessHelper.setModel(renderWitch, new ModelMaidWitch(0.0F));
        RenderZombie renderZombie = (RenderZombie)RenderManager.instance.entityRenderMap.get(EntityZombie.class);
        MaidVillagerRenderAccessHelper.setMaidModel(renderZombie);
    }
}
