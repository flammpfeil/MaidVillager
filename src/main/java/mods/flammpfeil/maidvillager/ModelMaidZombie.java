package mods.flammpfeil.maidvillager;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.MathHelper;

public class ModelMaidZombie extends ModelZombieVillager
{
    public ModelSimpleLittleMaid maid;

    public ModelMaidZombie()
    {
        super();
        maid = new ModelSimpleLittleMaid();
    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        maid.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        float var8 = MathHelper.sin(this.onGround * (float)Math.PI);
        float var9 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
        maid.bipedRightArm.rotateAngleY = (-(0.1F - var8 * 0.6F));
        maid.bipedLeftArm.rotateAngleY = (0.1F - var8 * 0.6F);
        maid.bipedRightArm.rotateAngleX = (-((float)Math.PI / 2F) - var8 * 1.2F + var9 * 0.4F + MathHelper.sin(par4 * 0.067F) * 0.05F);
        maid.bipedLeftArm.rotateAngleX = (-((float)Math.PI / 2F) - var8 * 1.2F + var9 * 0.4F - MathHelper.sin(par4 * 0.067F) * 0.05F);
        maid.render(par1Entity, par2, par3, par4, par5, par6, par7);
    }
}
