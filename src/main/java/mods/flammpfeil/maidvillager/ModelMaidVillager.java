package mods.flammpfeil.maidvillager;

import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;

import org.lwjgl.opengl.GL11;

public class ModelMaidVillager extends ModelVillager
{
    public ModelSimpleLittleMaid maid;

    public ModelMaidVillager(float par1)
    {
        super(par1);
        maid = new ModelSimpleLittleMaid();
    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        GL11.glPushMatrix();
        float f6 = 0.0625F;
        GL11.glTranslatef(0.0F, -(-24.0F * f6 - 0.0078125F), 0.0F);
        float f1;

        if (par1Entity instanceof EntityVillager && ((EntityVillager)par1Entity).getGrowingAge() < 0)
        {
            f1 = 2.0f * MaidVillager.childSize;
        }
        else
        {
            f1 = 1.1f * MaidVillager.defaultSize;
        }

        GL11.glScalef(f1, f1, f1);
        GL11.glTranslatef(0.0F, -24.0F * f6 - 0.0078125F, 0.0F);
        maid.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        maid.render(par1Entity, par2, par3, par4, par5, par6, par7);
        GL11.glPopMatrix();
    }
}
